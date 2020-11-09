/* 20201012 월
비상연락망 테이블 생성

테이블명 SMEMBER_CONTACT
회원번호	SNO	    VARCHAR2	12
성명  	SNAME	VARCHAR2	50
비밀번호	SPW	    VARCHAR2	4
생년월일	SBIRTH	VARCHAR2	8
전화번호	SHP	    VARCHAR2	13
이메일	SMAIL	VARCHAR2	50
우편번호	SPOST	VARCHAR2	6
주소	    SADDR	VARCHAR2	300
등록일	SINSERTDATE	DATE	
수정일	SUPDATEDATE	DATE	
삭제여부	SDELETEYN	VARCHAR2	1
*/

-- 테이블 생성
CREATE TABLE SMEMBER_CONTACT(
     SNO	    VARCHAR2(12)
    ,SNAME	    VARCHAR2(50)
    ,SPW	    VARCHAR2(4)
    ,SBIRTH	    VARCHAR2(8)
    ,SHP 	    VARCHAR2(13)
    ,SMAIL	    VARCHAR2(50)
    ,SPOST	    VARCHAR2(6)
    ,SADDR	    VARCHAR2(300)
    ,SINSERTDATE	DATE
    ,SUPDATEDATE	DATE
    ,SDELETEYN	VARCHAR2(1)
    ,CONSTRAINT    SMEMBER_CONTACT_PK PRIMARY KEY(SNO)
);

SELECT * FROM SMEMBER_CONTACT;

-- 인덱스 조회
SELECT
         S.TABLE_NAME   TABLE_NAME
        ,S.INDEX_NAME   INDEX_NAME
        ,S.COLUMN_NAME  COLUMN_NAME
FROM     ALL_IND_COLUMNS S
WHERE    S.TABLE_NAME = 'SMEMBER_CONTACT';

-- 전체회원 조회
SELECT
     S.SNO	        SNO
    ,S.SNAME	    SNAME
    ,S.SPW	        SPW
    ,S.SBIRTH	    SBIRTH
    ,S.SHP 	        SHP
    ,S.SMAIL	    SMAIL
    ,S.SPOST	    SPOST
    ,S.SADDR	    SADDR
    ,TO_CHAR(S.SINSERTDATE,'YYYY-MM-DD')	SINSERTDATE
    ,TO_CHAR(S.SUPDATEDATE,'YYYY-MM-DD')	SUPDATEDATE
    ,S.SDELETEYN	SDELETEYN
FROM SMEMBER_CONTACT    S
WHERE S.SDELETEYN = 'N'
ORDER BY 1;

-- 채번
SELECT /* INDEX_DESC(SMEMBER_CONTACT_PK) */
    NVL(MAX(SUBSTR(S.SNO,-2)),0)+1  COMMNO
FROM SMEMBER_CONTACT   S;

-- 회원등록
INSERT INTO SMEMBER_CONTACT (SNO
                            ,SNAME
                            ,SPW
                            ,SBIRTH
                            ,SHP
                            ,SMAIL
                            ,SPOST
                            ,SADDR
                            ,SINSERTDATE
                            ,SUPDATEDATE
                            ,SDELETEYN
                       )VALUES ( 'S2020101201'
                                ,'김아무'
                                ,'1224'
                                ,'19901205'
                                ,'01012341234'
                                ,'kimanony@gmail.com'
                                ,'12345'
                                ,'서울시 종로구'
                                ,SYSDATE
                                ,SYSDATE
                                ,'N');
                          ROLLBACK;      
-- 비밀번호 수정
UPDATE SMEMBER_CONTACT  S
SET  S.SPW	= '0125'
    ,S.SUPDATEDATE = SYSDATE
WHERE S.SNO = 'S2020101200'
AND   S.SDELETEYN = 'N';

-- 회원삭제
UPDATE SMEMBER_CONTACT  S
SET  S.SDELETEYN	= 'Y'
    ,S.SUPDATEDATE = SYSDATE
WHERE S.SNO = 'S2020101200'
AND   S.SDELETEYN = 'N';

-- 회원번호로 검색
SELECT
     S.SNO	        SNO
    ,S.SNAME	    SNAME
    ,S.SPW	        SPW
    ,S.SBIRTH	    SBIRTH
    ,S.SHP 	        SHP
    ,S.SMAIL	    SMAIL
    ,S.SPOST	    SPOST
    ,S.SADDR	    SADDR
    ,TO_CHAR(S.SINSERTDATE,'YYYY-MM-DD')	SINSERTDATE
    ,TO_CHAR(S.SUPDATEDATE,'YYYY-MM-DD')	SUPDATEDATE
    ,S.SDELETEYN	SDELETEYN
FROM SMEMBER_CONTACT    S
WHERE S.SNO = 'S2020102303'
AND   S.SDELETEYN = 'N';

-- 이름검색(likeSearch)
SELECT
     S.SNO	        SNO
    ,S.SNAME	    SNAME
    ,S.SPW	        SPW
    ,S.SBIRTH	    SBIRTH
    ,S.SHP 	        SHP
    ,S.SMAIL	    SMAIL
    ,S.SPOST	    SPOST
    ,S.SADDR	    SADDR
    ,TO_CHAR(S.SINSERTDATE,'YYYY-MM-DD')	SINSERTDATE
    ,TO_CHAR(S.SUPDATEDATE,'YYYY-MM-DD')	SUPDATEDATE
    ,S.SDELETEYN	SDELETEYN
FROM SMEMBER_CONTACT    S
WHERE S.SNAME LIKE '%김%'
AND   S.SDELETEYN = 'N';

