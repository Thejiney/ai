-- dept DAO에 들어갈 QUERY
-- (1) 부서 정보들 가져오는 함수 : getDeptList
SELECT * FROM DEPT;

-- (2) deptno로 부서정보 가져오는 함수 : getDept(10)
SELECT *
FROM DEPT
WHERE DEPTNO = 10;

-- (3) dname으로 부서정보 가져오는 함수 : getDept("sales"
SELECT *
FROM DEPT
WHERE DNAME = upper('SALES');

-- (4) 부서정보 입력받아 dept에 insert하는 함수 : insertDept
INSERT INTO DEPT (DEPTNO, DNAME, LOC)
VALUES(80,upper('IT'),upper('seoul'));

-- (5) 부서정보 입력받아	dept에 update하는 함수 : updateDept
UPDATE DEPT
SET DNAME = UPPER('CS'),
	LOC = UPPER('kyungju')
WHERE DEPTNO = 70;

-- (6) 부서번호 입력받아 dept에서 delete하는 함수 : deleteDept
DELETE FROM DEPT
WHERE DEPTNO = 10;

-- EMP DAO에 들어갈 QUERY
-- (1) 사원정보들 가져오는 함수 : getEmpList()
SELECT * FROM EMP;

-- (2) 부서번호로 사원정보 가져오는 함수 : getEmpList(deptno)
SELECT *
FROM EMP
WHERE DEPTNO = 10;

-- (3) 부서명으로 사원정보 가져오는 함수 : getEmpList(dname)
SELECT E.*
FROM EMP E, DEPT D
WHERE E.DEPTNO=D.DEPTNO
	AND UPPER(DNAME)=UPPER('SALES');