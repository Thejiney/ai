DROP TABLE PERSON;
DROP TABLE JOB;

CREATE TABLE JOB(
	jNO NUMBER(2),
	jNAME VARCHAR2(30) NOT NULL,
	PRIMARY KEY(jNO)
);

CREATE TABLE PERSON(
	pNO NUMBER(5),
	pNAME VARCHAR2(30) NOT NULL,
	jNO NUMBER(2),
	KOR NUMBER(3),
	ENG NUMBER(3),
	MAT NUMBER(3),
	PRIMARY KEY(pNO),
	FOREIGN KEY(jNO) REFERENCES JOB(jNO)
);

INSERT INTO JOB(jNO, jNAME)
VALUES(10, '배우');
INSERT INTO JOB(jNO, jNAME)
VALUES(20, '가수');
INSERT INTO JOB(jNO, jNAME)
VALUES(30, '엠씨');

DROP SEQUENCE p_SEQ;
CREATE SEQUENCE p_SEQ
	MAXVALUE 999
	NOCACHE
	NOCYCLE;

INSERT INTO PERSON(pNO, pNAME, jNO, KOR, ENG, MAT)
VALUES(p_SEQ.NEXTVAL, '정우성', 10, 90, 80, 81);
INSERT INTO PERSON(pNO, pNAME, jNO, KOR, ENG, MAT)
VALUES(p_SEQ.NEXTVAL, '박세영', 10, 80, 90, 80);
INSERT INTO PERSON(pNO, pNAME, jNO, KOR, ENG, MAT)
VALUES(p_SEQ.NEXTVAL, '배수지', 20, 20, 90, 90);

SELECT * FROM PERSON;

--2 직업명 입력, 직업별 조회 후 총점추가 총점이 높은 순으로 이름(번호) 출력
SELECT ROWNUM||'등' "RANK", A.* 
FROM (
	SELECT pNAME||'('||pNO||'번)' "pNAME", jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) "TOT"
	FROM PERSON P, JOB J
	WHERE P.jNO=J.jNO
		AND jNAME='배우'
	ORDER BY TOT DESC
) A;