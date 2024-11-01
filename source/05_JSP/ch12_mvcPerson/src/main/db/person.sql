-- 테이블 및 시퀀스 제거
DROP TABLE PERSON;
DROP SEQUENCE PERSON_ID_SEQ;
-- 테이블 및 시퀀스 생성
CREATE TABLE PERSON(
	ID 			NUMBER(6), 								-- 인위적인 PK
	NAME 		VARCHAR2(50) 	NOT NULL,  	-- 이름
	TEL 		VARCHAR2(50) 	UNIQUE,			-- 연락처
	ADDRESS VARCHAR2(250),						-- 주소
	BIRTH 	DATE,											-- 생년월일
	MEMO 		VARCHAR2(4000),						-- 메모
	RDATE 	DATE 					DEFAULT SYSDATE NOT NULL, -- 등록 시점
	PRIMARY KEY(ID)
);

CREATE SEQUENCE PERSON_ID_SEQ
	NOCACHE
	NOCYCLE
	MAXVALUE 999999;

-- 더미데이터 생성
INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
VALUES (PERSON_ID_SEQ.NEXTVAL, '홍길동', '010-9999-9999', '서울', TO_DATE('99/12/12'), '테스트');

INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
VALUES (PERSON_ID_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울', NULL, NULL);
COMMIT;

-- DAO에 들어갈 쿼리
-- 1. LIST (PAGING 없이) : public ArrayList<Person> getPersonList()
SELECT * FROM PERSON;

-- 1. LIST (PAGING 포함) : public ArrayList<Person> getPersonList(int startRow, int endRow) : 몇등~몇등
SELECT * 
	FROM (
		SELECT ROWNUM RN, A.*
			FROM (
				SELECT *
					FROM PERSON 
					ORDER BY ID desc
			) A
	)
	WHERE RN BETWEEN 11 AND 20;
	
-- 2. getCount (PAGING처리시 필요한 전체 갯수)
SELECT COUNT(*) CNT FROM PERSON;

-- 3. 추가 : public int insertPerson(Person person)
INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
VALUES(PERSON_ID_SEQ.NEXTVAL, '김길동', '010-7777-7777', '인천', '95-11-01', NULL);
-- 4. 한명출력 : public Person getPerson(int id)
SELECT * FROM PERSON WHERE ID=3;

-- 5. 수정 : public int updatePerson(Person person)
UPDATE PERSON
	SET NAME = '함길동',
		TEL = '010-1234-4567',
		ADDRESS = '수원',
		BIRTH = '99/12/12',
		MEMO = '',
		RDATE = SYSDATE
	WHERE ID='4';

-- 6. 삭제 : public int deletePerson(int id)
DELETE FROM PERSON
	WHERE ID='3';
COMMIT;
select * from person;