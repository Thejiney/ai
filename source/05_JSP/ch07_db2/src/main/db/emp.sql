-- ch06_db프로젝트에서 쓸 query

-- ex1
SELECT * FROM EMP;

-- ex2 : 입력받은 부서번호의 직원정보 출력
SELECT * FROM DEPT; -- select 태그내에 보여질 부서정보
-- 10->10번 부서 직원들, 0 -> 모든부서직원
SELECT E.*, DNAME
	FROM EMP E, DEPT D
	WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO LIKE '%0';
	
-- QUIZ : 사원명(일부 알파벳)으로 직원검색 ('      s '로 입력시 's'가 들어간 직원 출력) upper, trim함수 적용
SELECT *
	FROM EMP E, DEPT D
	WHERE ENAME LIKE '%'||UPPER(TRIM('  S  '))||'%'
		AND E.DEPTNO=D.DEPTNO;
	
SELECT DEPTNO, DNAME FROM DEPT;

