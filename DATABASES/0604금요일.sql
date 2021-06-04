-- 19장 사용자 추가시 오라클 데스크탑 안 씀. 대신, 
-- CreateWorkSpace : (https://127.0.0.1:9000/apepx/f?p=4950
-- 15장 PK 생성시 자동으로 2가지가 생성됨 : not null(빈값 방지), UNIQUE(중복 방지)
-- 제약조건 : constraint, foreign key 부자 관계, INDEX(테이블)도 자동생성됨
-- ERD로 게시판테이블-댓글|첨부파일 FOREIGN 키로 부자관계생성
-- 14장 트랜잭션 DB에서는 사용하지 않고 스프링에서 사용예정
-- commint과 rollback; (DML문 : insert,update,delete)
-- rollback은 제일 마지막 커밋된 부분으로 되돌아감

-- 12테이블 구조 생성(create;), 변경(alter;), 삭제(drop;)
-- ERD관계 다이어그램 물리테이블 생성
drop table tbl_member_del;
CREATE table TBL_MEMBER_DEL
(
USER_ID VARCHAR(50) PRIMARY KEY
,USER_PW VARCHAR(255)
,USER_NAME VARCHAR(255)
,EMAIL VARCHAR(255)
,POINT NUMBER(11,0)
,ENABLED NUMBER(1,0)
,LEVELS VARCHAR(255)
,REG_DATE TIMESTAMP(6)
,UPDATE_DATE TIMESTAMP(6)
);
-- ALTER TABLE로 필드명 변경 ALTER TABLE [원본 테이블] RENAME TO [바꾸려는 테이블명];
ALTER table tbl_member_del rename column EMAIL to user_email;
-- DEPT테이블 deptno 값이 숫자 2자리 때문에 에러 ->4자리로 변경
desc dept; -- 작은자리에서 큰자리로 이동 문제없음.반대는 문제있음
ALTER table dept MODIFY(deptno number(4));

-- 11장 서브쿼리
-- 단일행서브쿼리 필드값을 비교할 때 , 비교하는 값이 단일 (필드값)
-- 다중행 서브쿼리 테이블 값을 selec 쿼리로 생성(레코드형식)
-- 10장 테이블 조인 2개 테이블을 연결해서 결과를 구하는 예약어
-- 댓글 개수 구할 때
-- 카티시안 프로덕트 조인 (합집합- 게시물 10개, 댓글 100 = 110개 )
-- 아래조인방식이 Oracle 방식
select * from emp, dept 
where emp.deptno = dept.deptno
and emp.ename ='SCOTT';
-- 표준 방식 INNER 키워드 디폴트값임
-- 조인과 그룹을 이용해서 댓글카운터도 출력하는 게시판리스트 만들기
select bod.bno,title,count(*) as reply_count
,writer,bod.reg_date,view_count
from tbl_board BOD 
inner join tbl_reply REP on bod.bno = rep.bno
group by bod.bno,title,writer,bod.reg_date,view_count
order by bod.bno;
SELECT * FROM emp e join dept d on e.deptno = d.deptno
WHERE e.ename = 'SCOTT';


-- 8장 함수.
-- 부서별 연봉의 합계
-- DB 셋팅에서 대소문자 구분해서 사용할지, 구분하지 않을 지 셋팅.
-- having은 group by의 조건문을 적습니다.
-- 부서별 평균 연봉이 2000 이상인 부서의 번호와 부서별 평균 급여구하기

select deptno, round(avg(sal)) from emp group by deptno
having avg(sal) >= 2000; --그룹 조건
select * from (select deptno, sum(sal) as "DEPT_SAL"
from emp group by deptno) order by dept_sal DESC;
select ename,round(sal,-3) from emp;
select sum(sal) from emp;
select round(avg(sal)) from emp;
select MAX(sal), Min(sal) from emp;
select MAX(sal), MIN(sal), MAX(sal)-MIN(sal) as "대표와 사원의 연봉차" FROM emp;
select COUNT(*) from emp WHERE sal >= 
(select round(avg(sal)) from emp);


--DDL 문(create; alter;), DCL문(commit;rollback;)
--DML 문 (Data Maufacture Language), insert, update, delete
--insert문: 테이블에 새로운 레코드(row) 추가
create table dept02 as SELECT * from dept where 1=0;
-- 테이블을 복제하는 명령
-- where 조건 뒤에는 구조는 같으나 빈 테이블로 생성하라는 1=0;을 붙임
insert into dept02 (
-- 필드명
deptno, dname, loc)
values (10,'개발부서','천안');
-- 바인딩 값
COMMIT;--데이터베이스쿼리로 직접입력한 결과는 반드시 커밋을 해줘야지만 저장이 됨
SELECT * FROM dept02 order by deptno;
--insert into dept02 values(20,'디자인부','경기도')
delete from dept02 where deptno >= 0;
--delete from dept02; -- 이렇게 작업하면사용은 되는데 모든 레코드가 삭제되서 안됨.
--drop table 테이블명은 테이블자체를 물리적으로 없애는 명령
drop TABLE dept02; --drop 테이블은 커밋필요없이 바로 걍 사라짐 ㅠㅠ 슬펑
create table emp01 as SELECT * from emp;
select * from emp01;
-- UPDATE 테이블명 SET 필드명 = '바꿀값' where empno = '특정id값' 해줘야댐
UPDATE emp01 SET ename = '김성중' where empno = 7839;
ROLLBACK;
--ROLLBACK은 마지막 커밋 전 까지 되돌아감.
UPDATE emp01 SET sal = sal*110/100; 
-- 모든 직원의 연봉을 10프로 인상
UPDATE emp01 SET hiredate = sysdate;
