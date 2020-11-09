/* 20201012 ��
��󿬶��� ���̺� ����

���̺�� SMEMBER_CONTACT
ȸ����ȣ	SNO	    VARCHAR2	12
����  	SNAME	VARCHAR2	50
��й�ȣ	SPW	    VARCHAR2	4
�������	SBIRTH	VARCHAR2	8
��ȭ��ȣ	SHP	    VARCHAR2	13
�̸���	SMAIL	VARCHAR2	50
�����ȣ	SPOST	VARCHAR2	6
�ּ�	    SADDR	VARCHAR2	300
�����	SINSERTDATE	DATE	
������	SUPDATEDATE	DATE	
��������	SDELETEYN	VARCHAR2	1
*/

-- ���̺� ����
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

-- �ε��� ��ȸ
SELECT
         S.TABLE_NAME   TABLE_NAME
        ,S.INDEX_NAME   INDEX_NAME
        ,S.COLUMN_NAME  COLUMN_NAME
FROM     ALL_IND_COLUMNS S
WHERE    S.TABLE_NAME = 'SMEMBER_CONTACT';

-- ��üȸ�� ��ȸ
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

-- ä��
SELECT /* INDEX_DESC(SMEMBER_CONTACT_PK) */
    NVL(MAX(SUBSTR(S.SNO,-2)),0)+1  COMMNO
FROM SMEMBER_CONTACT   S;

-- ȸ�����
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
                                ,'��ƹ�'
                                ,'1224'
                                ,'19901205'
                                ,'01012341234'
                                ,'kimanony@gmail.com'
                                ,'12345'
                                ,'����� ���α�'
                                ,SYSDATE
                                ,SYSDATE
                                ,'N');
                          ROLLBACK;      
-- ��й�ȣ ����
UPDATE SMEMBER_CONTACT  S
SET  S.SPW	= '0125'
    ,S.SUPDATEDATE = SYSDATE
WHERE S.SNO = 'S2020101200'
AND   S.SDELETEYN = 'N';

-- ȸ������
UPDATE SMEMBER_CONTACT  S
SET  S.SDELETEYN	= 'Y'
    ,S.SUPDATEDATE = SYSDATE
WHERE S.SNO = 'S2020101200'
AND   S.SDELETEYN = 'N';

-- ȸ����ȣ�� �˻�
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

-- �̸��˻�(likeSearch)
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
WHERE S.SNAME LIKE '%��%'
AND   S.SDELETEYN = 'N';

