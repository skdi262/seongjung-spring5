-- 8장 함수.
-- 부서별 연봉의 합계
-- DB 셋팅에서 대소문자 구분해서 사용할지, 구분하지 않을 지 셋팅.


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
