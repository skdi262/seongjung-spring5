--DESC : Description : 테이블구조를 설명
DESC dept;
--selcet : 테이블 내용 조회 명령
SELECT 
concat(deptno, ' 번') as "부서번호"
, dname as "부서명" 
, concat(loc, ' 시') as "위치"
FROM dept 
WHERE loc = 'NEW YORK';
--Dual 가상테이블. select할 때
SELECT 3+5 as "3더하기8은" from dual;
--레코드 (row) : 컬럼(필드 field)들로 구성
SELECT concat(count(*),'명') as "연봉이 2000이상인 사람" FROM emp WHERE SAL>2000;
-- 큰따옴표(필드명은 큰따옴표), 작은 따옴표는(일반 문자열 출력할 때)
SELECT * FROM emp WHERE ename <> 'KING';
SELECT * FROM emp WHERE hiredate >= '1982/01/01';
--or은 합집합, and는 교집합
SELECT * FROM emp 
WHERE deptno = 10 AND job = 'MANAGER';
select * from emp where sal between 2000 and 3000;
SELECT * FROM emp WHERE hiredate between '1980/01/01' AND '1980/12/31';
SELECT * FROM emp where comm NOT in (300,500,1400);
-- LIKE 조회, 와일드카드 조회
SELECT * FROM emp WHERE ename like upper('k%');
SELECT * FROM emp where ename like ('%N');
-- null널이 중요한 이유 : null값이 있으면 검색 x
-- null값이 필드에 있을 때, 검색은?
SELECT * FROM emp WHERE comm is null;
--nvl = NULL Value
-- E는 emp 테이블의 알리아스 별칭으로 E.*은 emp.*과 같은 내용.
SELECT nvl2(comm,100,0), E.* from emp E WHERE NVL(comm,0) = 0;
-- NVL2(필드명, 널이아닐때 100, 널일때 0) , NVL(필드명, 널일때 0)
-- 오라클은 표준쿼리x. ANSI쿼리 표준임.
SELECT DECODE(comm,null,100,0),NVL2(comm,100,0), E.* from emp E WHERE NVL(comm,0) = 0;
--정렬 sort, 순서 order by 필드명 오름차순|내림차순 - 연봉기준을 정렬
-- 중요) 서브쿼리= (select쿼리가 중복되어있는 쿼리)
SELECT rownum, E.* from (--테이블 명 대신 
SELECT * FROM emp order by sal DESC--내림차순
) E where rownum = 1;
--위 정렬에서 1등만 구할 수 있는 명령어,
--중복 레코드(row)를 제거하는 ㅁ여렁어 distinct
SELECT deptno as "부서번호" FROM emp ;
SELECT distinct deptno as "부서번호" FROM emp ;
-- 중요) 문자열을 연결할 때 concat 함수 외에 || 이렇게 파이프 라인 두개 겹쳐서 사용하기도 함.
SELECT ename ||' is a '|| job AS"문자열 연결" from emp;
-- 여기까지가 select 끝 Read
-- 이후에는 CRUD 중에 Insert, Update, Delete.
SELECT sysdate +1 from dual;