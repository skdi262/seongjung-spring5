--DESC : Description : ���̺����� ����
DESC dept;
--selcet : ���̺� ���� ��ȸ ���
SELECT 
concat(deptno, ' ��') as "�μ���ȣ"
, dname as "�μ���" 
, concat(loc, ' ��') as "��ġ"
FROM dept 
WHERE loc = 'NEW YORK';
--Dual �������̺�. select�� ��
SELECT 3+5 as "3���ϱ�8��" from dual;
--���ڵ� (row) : �÷�(�ʵ� field)��� ����
SELECT concat(count(*),'��') as "������ 2000�̻��� ���" FROM emp WHERE SAL>2000;
-- ū����ǥ(�ʵ���� ū����ǥ), ���� ����ǥ��(�Ϲ� ���ڿ� ����� ��)
SELECT * FROM emp WHERE ename <> 'KING';
SELECT * FROM emp WHERE hiredate >= '1982/01/01';
--or�� ������, and�� ������
SELECT * FROM emp 
WHERE deptno = 10 AND job = 'MANAGER';
select * from emp where sal between 2000 and 3000;
SELECT * FROM emp WHERE hiredate between '1980/01/01' AND '1980/12/31';
SELECT * FROM emp where comm NOT in (300,500,1400);
-- LIKE ��ȸ, ���ϵ�ī�� ��ȸ
SELECT * FROM emp WHERE ename like upper('k%');
SELECT * FROM emp where ename like ('%N');
-- null���� �߿��� ���� : null���� ������ �˻� x
-- null���� �ʵ忡 ���� ��, �˻���?
SELECT * FROM emp WHERE comm is null;
--nvl = NULL Value
-- E�� emp ���̺��� �˸��ƽ� ��Ī���� E.*�� emp.*�� ���� ����.
SELECT nvl2(comm,100,0), E.* from emp E WHERE NVL(comm,0) = 0;
-- NVL2(�ʵ��, ���̾ƴҶ� 100, ���϶� 0) , NVL(�ʵ��, ���϶� 0)
-- ����Ŭ�� ǥ������x. ANSI���� ǥ����.
SELECT DECODE(comm,null,100,0),NVL2(comm,100,0), E.* from emp E WHERE NVL(comm,0) = 0;
--���� sort, ���� order by �ʵ�� ��������|�������� - ���������� ����
-- �߿�) ��������= (select������ �ߺ��Ǿ��ִ� ����)
SELECT rownum, E.* from (--���̺� �� ��� 
SELECT * FROM emp order by sal DESC--��������
) E where rownum = 1;
--�� ���Ŀ��� 1� ���� �� �ִ� ��ɾ�,
--�ߺ� ���ڵ�(row)�� �����ϴ� �������� distinct
SELECT deptno as "�μ���ȣ" FROM emp ;
SELECT distinct deptno as "�μ���ȣ" FROM emp ;
-- �߿�) ���ڿ��� ������ �� concat �Լ� �ܿ� || �̷��� ������ ���� �ΰ� ���ļ� ����ϱ⵵ ��.
SELECT ename ||' is a '|| job AS"���ڿ� ����" from emp;
-- ��������� select �� Read
-- ���Ŀ��� CRUD �߿� Insert, Update, Delete.
SELECT sysdate +1 from dual;