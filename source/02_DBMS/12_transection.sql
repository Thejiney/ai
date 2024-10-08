-- [XII] 트랜젝션 명령어 : COMMIT(트랜젝션 반영) ROLLBACK(트랜젝션 취소) SAVEPOINT(트랜젝션 분할)
SELECT * FROM DEPT01;
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS
	SELECT *
	FROM DEPT; -- DEPT01 : 10, 20, 30, 40
-------------------트랜잭션 시작
SELECT * FROM DEPT01; -- 10, 20, 30, 40
DELETE FROM DEPT01 WHERE DEPTNO=10;
ROLLBACK;
-------------------트랜잭션 시작
SELECT * FROM DEPT01; -- 10, 20, 30, 40
DELETE FROM DEPT01 WHERE DEPTNO=40;
COMMIT;
------------------트랜잭션 시작
SELECT * FROM DEPT01; -- 10, 20, 30
DELETE FROM DEPT01 WHERE DEPTNO=30;
SAVEPOINT C1; -- ★C1시점 : 10, 20
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=20;
SAVEPOINT C2; -- ★C2시점 : 10
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=10;
SELECT * FROM DEPT01;
ROLLBACK TO C2;
SELECT * FROM DEPT01;
ROLLBACK TO C1;
SELECT * FROM DEPT01;
COMMIT;