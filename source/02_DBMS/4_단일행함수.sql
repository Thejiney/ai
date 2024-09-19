-- [IV] 단일행함수
-- 함수 = 단일행함수(4장) + 그룹함수(5장)
SELECT
    hiredate,
    to_char(
        hiredate, 'YYYY-MM-DD HH24:MI:SS'
    )
FROM
    emp;

SELECT
    SUM(sal),
    AVG(sal)
FROM
    emp; -- 그룹함수(INPUT 14행 -> OUTPUT 1행)
SELECT
    deptno,
    AVG(sal)
FROM
    emp
GROUP BY
    deptno; --INPUT N행 -> OUTPUT 1행

-- ★ 단일행함수 = 숫자관련함수, 문자관련함수, 날짜관련함수, 형변환함수, NVL, etc...
-- 1. 숫자관련함수
    -- DUAL테이블 : 오라클에서 제공한 1행 1열 짜리 DUMMY TABLE
SELECT
    *
FROM
    dual;

DESC DUAL;

SELECT
    floor(
        34.567
    )
FROM
    dual; -- 소수점에서 내림(버림)
SELECT
    floor(34.567 * 10) / 10
FROM
    dual; -- 정수/정수 => 실수
SELECT
    trunc(
        34.567, 1
    )
FROM
    dual;

SELECT
    trunc(
        34.567
    )
FROM
    dual;

SELECT
    trunc(
        34.567, - 1
    )
FROM
    dual;
    -- EX. EMP에서 이름, 급여(십의 자리에서 내림)
SELECT
    ename,
    sal,
    trunc(
        sal, - 2
    )
FROM
    emp;

SELECT
    ceil(
        34.567
    )
FROM
    dual; -- 소수점에서 올림

SELECT
    round(
        34.567
    )
FROM
    dual; -- 소수점에서 반올림    
SELECT
    round(
        34.567, 2
    )
FROM
    dual; -- 소수점 두자리에서 반올림
SELECT
    round(
        34.567, - 1
    )
FROM
    dual; -- 일의 자리에서 반올림

SELECT
    mod(
        9, 2
    )
FROM
    dual;
    -- 홀수년도에 입사한 사원의 모든 정보 출력
SELECT
    *
FROM
    emp
WHERE
    mod(
        to_char(
            hiredate, 'RR'
        ), 2
    ) = 1;
        
-- 2. 문자관련함수
-- (1) 대소문자 관련
SELECT
    upper(
        'abcABC'
    )
FROM
    dual; -- 대문자로
SELECT
    lower(
        'abcABC'
    )
FROM
    dual; -- 소문자로
SELECT
    initcap(
        'welcome to oracle'
    )
FROM
    dual; -- 어절단위로 나눠서 첫문자만 대문자
SELECT
    initcap(
        'WELCOME TO ORACLE'
    )
FROM
    dual; -- 어절단위로 나눠서 첫문자만 대문자
    -- EX. 이름이 SCOTT인 직원의 모든 필드
SELECT
    *
FROM
    emp
WHERE
    upper(ename) = 'SCOTT';

SELECT
    *
FROM
    emp
WHERE
    initcap(ename) = 'Scott';

SELECT
    *
FROM
    emp
WHERE
    lower(ename) = 'scott';
-- (2)문자 연결(CONCAT함수, ||연산자)
SELECT
    'AB'
    || 'CD'
    || 'EF'
    || 'GH'
FROM
    dual;

SELECT
    concat(
        concat(
            'AB', 'CD'
        ), concat(
            'EF', 'GH'
        )
    )
FROM
    dual;
        --"SMITH는 MANNAGER다" 포맷을 EMP테이블 데이터를 출력
SELECT
    ename
    || '는 '
    || job
    || '다'
FROM
    emp;

SELECT
    concat(
        concat(
            ename, '는 '
        ), concat(
            job, '다'
        )
    )
FROM
    emp;

-- (3) SUBSTR(STR, 시작위치, 문자갯수) : STR을 시작위치부터 문자갯수만큼 출력
--    SUBSTRB(STR, 시작바이트위치, 바이트갯수) : STR을 시작부터 바이트갯수만큼 문자 추출
                    -- O R A C L E
                    -- 1 2 3 4 5 6
                    -- -6 -5 -4 -3 -2 -1
SELECT
    substr(
        'ORACLE', 4, 2
    )
FROM
    dual;

SELECT
    substrb(
        'ORACLE', 4, 2
    )
FROM
    dual;

SELECT
    substr(
        '데이터베이스', 4, 2
    )
FROM
    dual;

SELECT
    substrb(
        '데이터베이스', 4, 3
    )
FROM
    dual;
    --9월에 입사한 사원의 모든 필드 ( 날짜형 표기 'RR/MM/DD')
SELECT
    *
FROM
    emp
WHERE
    substr(
        hiredate, 4, 2
    ) = '09'; -- (DATE)날짜형도 가능
DESC EMP;
    -- 9일에 입사한 사원의 모든 필드
SELECT
    *
FROM
    emp
WHERE
    substr(
        hiredate, - 2, 2
    ) = '09';

-- (4) LENGTH(STR) : STR의 글자수
    -- LENGTHN(STR) : STR의 바이트 수
SELECT
    length(
        'ABCD'
    )
FROM
    dual; -- 글자수
SELECT
    length(
        '오라클'
    ),
    lengthb(
        '오라클'
    )
FROM
    dual;
-- (5) LPAD(STR, 자리수, 채울문자):" STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울문자로 출력
    -- LPAD(STR, 자리수) : STR을 자리수만큼 확보하고 왼쪽 빈자리에 ' '를 출력
    -- RPAD(STR, 자리수, 채울문자): STR을 자리수만큼 확보하고 오른쪽 빈자리에 채울문자로 출력
    -- RPAD(STR, 자리수) : STR을 자리수만큼 확보하고 오른쪽 빈자리에 ' '로 출력
SELECT
    lpad(
        'ORACLE', 10, '#'
    )
FROM
    dual;

SELECT
    lpad(
        'ORACLE', 10
    )
FROM
    dual;

DESC EMP;
    -- ENAME : 최장 10글자, SAL : 5자리.2자리
SELECT
    lpad(
        ename, 10, '-'
    ),
    lpad(
        sal, 5, '$'
    )
FROM
    emp;
    -- EX. 사번, 이름 (7369 S**** / 1111 W*** ...)
SELECT
    empno,
    rpad(
        substr(
            ename, 1, 1
        ), length(ename), '*'
    ) ename
FROM
    emp;
    -- EX. 사번, 이름, 직책(9자리확보), 입사일
    --     7369 Smith ____****K 80/12/**
    --     7566 Jones ___*****r 81/02/**
SELECT
    empno,
    initcap(ename) ename,
    lpad(
        lpad(
            substr(
                job, - 1, 1
            ), length(job), '*'
        ), 9
    )              job,
    to_char(
        hiredate, 'RR/MM/'
    )
    || '**'        hiredate
FROM
    emp;
    
-- (6) INSTR (STR, 찾을문자) : STR에서 찾을문자가 첫번째로 나오는 위치(처음1, 없으면 0 )
-- INSTR (STR, 찾을문자, 시작위치) : STR의 시작위치부터 찾을 문자가 나오는 위치
SELECT
    instr(
        'ABCABCABC', 'B'
    ),
    instr(
        'ABCABCABC', 'B', 3
    )
FROM
    dual;
    -- EX. 9월에 입사한 사원의 모든 필드 (날짜 RR/MM/DD)
SELECT
    *
FROM
    emp
WHERE
    instr(
        hiredate, '09', 4
    ) = 4;

SELECT
    *
FROM
    emp
WHERE
    substr(
        hiredate, 4, 2
    ) = '09';

SELECT
    *
FROM
    emp
WHERE
    hiredate LIKE '__/09/__';
    -- EX. 9일에 입사한 사원의 모든 필드
SELECT
    *
FROM
    emp
WHERE
    instr(
        hiredate, '09', 7
    ) = 7;

SELECT
    *
FROM
    emp
WHERE
    substr(
        hiredate, 7, 2
    ) = '09';

SELECT
    *
FROM
    emp
WHERE
    hiredate LIKE '%/09';
    
    -- EX. 9일이 아닌 날에 입사한 사원의 모든 필드
SELECT
    *
FROM
    emp
WHERE
    instr(
        hiredate, '09', 7
    ) = 0;

SELECT
    *
FROM
    emp
WHERE
    substr(
        hiredate, 7, 2
    ) != '09';

SELECT
    *
FROM
    emp
WHERE
    hiredate NOT LIKE '%/09';
    
-- (7) 여백제거 : TRIM(STR), LTRIM(STR), RTRIM(STR)
SELECT
    '   ORACLE    ' "MSG"
FROM
    dual;

SELECT
    TRIM('  ORACLE  ') "MSG"
FROM
    dual;

SELECT
    ltrim(
        '  ORACLE   '
    ) "msg"
FROM
    dual;

SELECT
    rtrim(
        '  oracle   '
    ) "msg"
FROM
    dual;
-- (8) REPLACE(STR, '바꿔야할문자', '바꿀문자')
SELECT
    replace(
        ename, 'A', 'XX'
    )
FROM
    emp;

SELECT
    replace(
        sal, '0', 'X'
    )
FROM
    emp;

SELECT
    replace(
        hiredate, 0, 'X'
    )
FROM
    emp;

-- 3. 날짜관련함수 및 예약어
--(1) SYSDATE : 지금
SELECT
    sysdate
FROM
    dual;

SELECT
    to_char(
        sysdate, 'RR/MM/DD HH:MI'
    )
FROM
    dual;
--(2) 날짜 계산 : 오라클 기본 타입(문자, 숫자, 날짜) 중 숫자, 날짜 타입은 연산가능
SELECT
    to_char(
        sysdate, 'RR/MM/DD HH:MI'
    ),
    to_char(
        sysdate + 1, 'RR/MM/DD HH:MI'
    )
FROM
    dual;
    -- 개강시점(24/08/26 09:30)부터 현재(24/09/09 09:30)까지 몇일 지났나?
SELECT
    trunc(sysdate - TO_DATE('24/08/26 09:30', 'RR/MM/DD HH24:MI'))
FROM
    dual;
    -- 현재부터 수료까지 몇일 남았나?
SELECT
    trunc(TO_DATE('25/03/07 18:00', 'RR/MM/DD HH24:MI') - sysdate) duedate
FROM
    dual;
    -- emp에서 이름, 입사일, 근무일수
SELECT
    ename,
    hiredate,
    trunc(sysdate - hiredate)         day,
    trunc((sysdate - hiredate) / 7)   week,
    trunc((sysdate - hiredate) / 365) year
FROM
    emp;
--(3) MONTHS_BETWEEN(날짜형1, 날짜형2) : 두 날짜형 데이터 간 개월수 (날짜형1이 큰 시점)
    -- EX. 이름, 입사일, 근무월수
SELECT
    ename,
    hiredate,
    TRIM(trunc(
        months_between(
            sysdate, hiredate
        )
    )) month
FROM
    emp;
    -- EX. 수료시점까지 남은 개월수
SELECT
    trunc(
        months_between(TO_DATE('25/03/07 18:00', 'RR/MM/DD HH24:MI'), sysdate), 2
    )
FROM
    dual;
-- (4) NEXT_DAY(특정시점, '토') : 특정시점부터 처음 돌아오는 토요일
SELECT
    next_day(
        sysdate, '토'
    )
FROM
    dual;
-- (5) ADD_MONTHS(특정시점, 개월수) : 특정시점부터 몇개월 후
SELECT
    add_months(
        sysdate, 1
    )
FROM
    dual;
    -- EX. 이름, 입사일, 수습종료기간(수습기간은 입사일로부터 6개월까지)
SELECT
    ename,
    hiredate,
    add_months(
        hiredate, 6
    )
FROM
    emp;
    -- 입사일을 8월 31일로
INSERT INTO emp VALUES (
    9999,
    '홍길동',
    NULL,
    NULL,
    '80/08/31',
    900,
    NULL,
    40
);
-- (6) LAST_DAY(특정시점) : 특정시점의 말일(28, 29, 30, 31)
SELECT
    last_day(sysdate)
FROM
    dual;
    -- EX. 이름, 입사일, 첫월급날(말일)
SELECT
    ename,
    hiredate,
    last_day(hiredate)
FROM
    emp;
-- (7) ROUND(날짜, xx) : 날짜 반올림(XX:'YEAR', 'MONTH', 'DAY', TODFIR)
    -- TRUNC(날짜, XX) : 날짜 버림
SELECT
    round(
        34, 56
    ),
    round(
        34.56, 1
    )
FROM
    dual;

SELECT
    round(sysdate)
FROM
    dual;

SELECT
    to_char(
        round(sysdate), 'MM/DD HH24:MI'
    )
FROM
    dual; -- 가까운 0시 0분
SELECT
    round(
        sysdate, 'DAY'
    )
FROM
    dual; -- 가까운 일요일
SELECT
    round(
        sysdate, 'MONTH'
    )
FROM
    dual; -- 가까운 1일
SELECT
    round(
        sysdate, 'YEAR'
    )
FROM
    dual; -- 가까운 1월 1일

SELECT
    to_char(
        trunc(sysdate), 'MM/DD HH24:MI'
    )
FROM
    dual; -- 오늘 0시 0분
SELECT
    trunc(
        sysdate, 'DAY'
    )
FROM
    dual; -- 지난 일요일
SELECT
    trunc(
        sysdate, 'MONTH'
    )
FROM
    dual; -- 이번달 1일
SELECT
    trunc(
        sysdate, 'YEAR'
    )
FROM
    dual; -- 올해 1월 1일
    -- EX. 이름, 입사일, 첫월급날(16일)
SELECT
    ename,
    hiredate,
    round(
        hiredate, 'MONTH'
    ) + 15 월급날
FROM
    emp;
    -- EX. 이름, 입사일, 첫월급날(15일) : ROUND기준 15/16을 14/15로
SELECT
    ename,
    hiredate,
    round(
        hiredate + 1, 'MONTH'
    ) + 14 월급날
FROM
    emp;
    -- EX. 이름, 입사일, 첫월급날(12일) : ROUND기준 15/16을 11/12로
SELECT
    ename,
    hiredate,
    round(
        hiredate + 4, 'MONTH'
    ) + 11 월급날
FROM
    emp;
    -- EX. 이름, 입사일, 첫월급날(25일) : ROUND기준 15/16을 24/25로
SELECT
    ename,
    hiredate,
    round(
        hiredate - 9, 'MONTH'
    ) + 24 월급날
FROM
    emp;

-- 4. 형변환함수 (TO_CHAR:문자로 변환시키는 함수, TO_DATE:날짜형으로 변환시키는 함수, TO_NUMBER:숫자로 변환시키는 함수
-- (1) TO_CHAR(날짜형, '출력형식')
    -- YYYY 년도4자리 / RR 년도2자리 / MM 월 / DD 일 / DY 목 / DAY 목요일
    -- HH24 / HH12/ HH (12시간) / MI 분 / SS 초 / AM 오전/오후
	-- 출력형식에 문자를 포함할 경우 ""
SELECT
    ename,
    to_char(
        hiredate, 'YYYY-MM-DD DAY HH24:MI:SS'
    )
FROM
    emp;

SELECT
    ename,
    to_char(
        hiredate, 'RR"년"MM"월"DD"일" DY"요일" AM HH"시"MI"분"SS"초"'
    )
FROM
    emp;
-- (2) TO_CHAR(숫자, '출력형식')
	-- 0 : 자릿수. 출력형식의 자릿수가 많으면 0으로 채움
	-- 9 : 자릿수. 출력형식의 자릿수가 많아도 숫자만큼출력
	-- , : 세자리마다 ,
	-- . : 소수점
	-- $ : 통화단위 $
	-- L : 지역통화단위로 출력
SELECT
    to_char(
        sal, 'L99,999'
    )
FROM
    emp;

SELECT
    to_char(
        sal, '$00,000.9'
    )
FROM
    emp;

SELECT
    to_char(
        1234.56, '9,999.9'
    )
FROM
    dual;
-- (3) TO_DATE(문자, '패턴')
	-- EX. 81/5/1 ~ 83/5/1 사이에 입사한 사원의 모든 필드
SELECT
    *
FROM
    emp
WHERE
    to_char(
        hiredate, 'RR/MM/DD'
    ) BETWEEN '81/05/01' AND '83/05/01';

SELECT
    *
FROM
    emp
WHERE
    hiredate BETWEEN TO_DATE('81/05/01', 'RR/MM/DD') AND TO_DATE('83/05/01', 'RR/MM/DD');

ALTER SESSION SET nls_date_format = 'YYYY-MM-DD';
-- (4) TO_NUMBER(문자, '패턴')
SELECT
    TO_NUMBER('3,456', '9,999') + 1
FROM
    dual;
-- 5. NVL(널일수도 있는 데이터, 널이면 대신할 값) - 매개변수 2개의 타입 일치
	-- EX. 사원이름, 직속상사이름(직속상사가 없으면 CEO로 출력)
SELECT
    w.ename,
    nvl(
        m.ename, 'CEO'
    )
FROM
    emp w,
    emp m
WHERE
    w.mgr = m.empno (+);
	-- EX. 사원이름 ,직속상사의 사번(직속상사가 없으면 CEO)
SELECT
    ename,
    nvl(
        to_char(mgr), 'CEO'
    )
FROM
    emp;
-- 6. ETC
--(1) EXTRACT ; 날짜형 데이터에서 년도, 월, 일만 추출하고자 할 때
SELECT
    hiredate,
    EXTRACT(YEAR FROM hiredate)
FROM
    emp; --년도만 추출(숫자로 추출)
SELECT
    hiredate,
    to_char(
        hiredate, 'YYYY'
    )
FROM
    emp; -- 년도만 추출(문자로 추출)
SELECT
    hiredate,
    EXTRACT(MONTH FROM hiredate)
FROM
    emp; -- 월만 추출(숫자로 추출)
SELECT
    hiredate,
    to_char(
        hiredate, 'MM'
    )
FROM
    emp; -- 월만 추출(문자로 추출)
SELECT
    hiredate,
    EXTRACT(DAY FROM hiredate)
FROM
    emp; -- 일만 추출(숫자로 추출)
SELECT
    hiredate,
    to_char(
        hiredate, 'DD'
    )
FROM
    emp; -- 일만 추출(문자로 추출)

-- (2) 계층별 출력
SELECT
    *
FROM
    emp; -- 계층없이 출력

SELECT
    level,
    emp.*
FROM
    emp
START WITH
    mgr IS NULL
CONNECT BY
    PRIOR empno = mgr
ORDER BY
    level;

SELECT
	level,
	lpad('└', level) || ename
FROM
	emp
START WITH
    mgr IS NULL
CONNECT BY
    PRIOR empno = mgr
ORDER BY
    level;
	
-- <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT
	SYSDATE "Current Date"
FROM
	DUAL;
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT
	EMPNO,
	ENAME,
	JOB,
	SAL,
	TRUNC(SAL*1.15, 0) "New Salary",
	TRUNC(SAL*0.15, 0) "Increase"
FROM
	EMP;
--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT
	ENAME,
	HIREDATE,
	NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월')
FROM
	EMP;
--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT
	ENAME,
	HIREDATE,
	TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE), 0) "WORKING MONTH",
	TO_CHAR(SAL * TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE), 0), '9,999,999') "PAYED SAL"
FROM
	EMP;
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT
	ENAME,
	LPAD(SAL,15,'*') SAL
FROM
	EMP;
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT
	ENAME,
	JOB,
	HIREDATE,
	TO_CHAR(HIREDATE,'DAY') HIREDAY
FROM
	EMP;
--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT
	ENAME,
	LENGTH(ENAME) N_ENAME,
	JOB
FROM 
	EMP
WHERE
	LENGTH(ENAME)>=6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT
	ENAME,
	JOB,
	SAL,
	COMM,
	SAL+NVL(COMM,0) "SAL+COMM"
FROM
	EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT
	SUBSTR(ENAME,2,3)
FROM
	EMP;
--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있음을 고려하자
SELECT
	EMPNO,
	ENAME,
	HIREDATE
FROM
	EMP
WHERE
	TO_CHAR(HIREDATE,'MM')='12';
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO   ENAME	급여
--7369	    SMITH	*******800
--7499	    ALLEN	******1600
--7521	    WARD	******1250
--……. 
SELECT
	EMPNO,
	ENAME,
	LPAD(SAL,10,'*') "급여"
FROM
	EMP;
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO ENAME 입사일
-- 7369	  SMITH	  1980-12-17
-- ….
SELECT
	EMPNO,
	ENAME,
	TO_CHAR(HIREDATE, 'YYYY-MM-DD') "입사일"
FROM
	EMP;
--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT
	EMPNO,
	ENAME,
	JOB,
	TO_CHAR(SAL,'$999,999') SAL
FROM
	EMP
WHERE
	DEPTNO=20;