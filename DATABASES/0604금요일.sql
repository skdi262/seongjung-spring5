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
