-- com.lec.ex1selectAll
SELECT * FROM EMP;

-- com.lec.ex2selectWhere
-- EX1. 부서번호를 받아 부서정보를 출력
SELECT *
FROM DEPT
WHERE DEPTNO = 10;

INSERT INTO DEPT
VALUES (50, 'IT', '서울');

COMMIT;

-- EX2. 부서번호 입력 받아 부서 정보와 사원 정보 출력
SELECT * FROM DEPT WHERE DEPTNO=10;

SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO
	AND W.DEPTNO = 10;
	
-- EX3. 부서이름으로 부서정보 출력
SELECT * FROM DEPT WHERE DNAME=UPPER('sales');

-- ★★★ com.lec.ex3insert ★★★
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=60;
INSERT INTO dept
VALUES (60, UPPER('cs'), UPPER('pusan'));
rollback;

-- ★★★ com.lec.ex4update ★★★
SELECT * FROM DEPT WHERE DEPTNO=80;
UPDATE DEPT 
SET DNAME=UPPER('marketing'),
	LOC = UPPER('seoul')
WHERE DEPTNO = 80;
COMMIT;
select * from dept;
	
-- ★★★ com.lec.ex5delete ★★★
DELETE FROM DEPT WHERE DEPTNO=99;

-- ★★★ com.lec.ex6prepareStatement ★★★
SELECT * FROM DEPT WHERE DNAME = UPPER('SALES');
SELECT EMPNO, ENAME, SAL
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
	AND DNAME = 'it'
ORDER BY SAL DESC;
select * from dept;