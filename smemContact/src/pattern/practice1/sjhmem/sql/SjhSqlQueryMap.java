package pattern.practice1.sjhmem.sql;

public class SjhSqlQueryMap {

	// ä�� ���
	public static final String SMEMBER_CHAEBUN_SNO = 
					  " SELECT 		/* INDEX_DESC(SMEMBER_CONTACT_PK) */ "
				    + " 	 NVL(MAX(SUBSTR(S.SNO,-2)),0)+1  	COMMNO "
				    + " FROM SMEMBER_CONTACT   S ";
	
	// ��ü ȸ�� ��ȸ(select)
	public static String getSelectQuery(){
		System.out.println("[log] pattern.practice1.sjhmem.sql.SjhSqlQueryMap Ŭ���� >>> getSelectQuery() �Լ� ����");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT							\n");
		sb.append("		 	 S.SNO	        SNO		\n");
		sb.append(" 		,S.SNAME	   	SNAME	\n");
		sb.append(" 		,S.SPW	        SPW		\n");
		sb.append(" 		,S.SBIRTH	   	SBIRTH	\n");
		sb.append(" 		,S.SHP 	        SHP		\n");
		sb.append(" 		,S.SMAIL	    SMAIL	\n");
		sb.append(" 		,S.SPOST	    SPOST	\n");
		sb.append(" 		,S.SADDR	    SADDR	\n");
		sb.append(" 		,TO_CHAR(S.SINSERTDATE,'YYYY-MM-DD')	SINSERTDATE	\n");
		sb.append(" 		,TO_CHAR(S.SUPDATEDATE,'YYYY-MM-DD')	SUPDATEDATE	\n");
		sb.append(" 		,S.SDELETEYN	SDELETEYN	\n");
		sb.append(" FROM  SMEMBER_CONTACT   S	\n");
		sb.append(" WHERE S.SDELETEYN = 'Y'		\n");
		sb.append(" ORDER BY 1");
		
		String selectStr = sb.toString();
		System.out.println("[log] getSelectQuery() �Լ� ��");
		return selectStr;
	}// end of getSelectQuery()
	
	// ȸ����ȣ �˻�(search)
	
	// �̸� �˻�(likeSearch)
	
	// ȸ�����(insert)
	public static String getInsertQuery(){
		System.out.println("[log] getInsertQuery() �Լ� ����");
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO SMEMBER_CONTACT (		\n");
		sb.append("						 SNO			\n");
		sb.append("						,SNAME			\n");
		sb.append("						,SPW			\n");
		sb.append("						,SBIRTH			\n");
		sb.append("						,SHP			\n");
		sb.append("						,SMAIL			\n");
		sb.append("						,SPOST			\n");
		sb.append("						,SADDR			\n");
		sb.append("						,SINSERTDATE	\n");
		sb.append("						,SUPDATEDATE	\n");
		sb.append("						,SDELETEYN		\n");
		sb.append(" 				)VALUES (			\n");
		sb.append("							 ?			\n");
		sb.append("							,?			\n");
		sb.append("							,?			\n");
		sb.append("							,?			\n");
		sb.append("							,?			\n");
		sb.append("							,?			\n");
		sb.append("							,?			\n");
		sb.append("							,?			\n");
		sb.append("							,SYSDATE	\n");
		sb.append("							,SYSDATE	\n");
		sb.append("							,?			\n");
		sb.append("							        )	\n");
		
		String insertStr = sb.toString();
		System.out.println("[log] getInsertQuery() �Լ� ��");
		return insertStr;
	}// end of getInsertQuery()
	
	// ��й�ȣ ����(update)
	
	// ȸ�� ����(delete)

}// end of SjhSqlQueryMap
