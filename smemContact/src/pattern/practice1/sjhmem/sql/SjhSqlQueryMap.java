package pattern.practice1.sjhmem.sql;

public class SjhSqlQueryMap {

	// ä�� ���
	
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
		
		System.out.println("[log] getSelectQuery() �Լ� ��");
		return sb.toString();
	}// end of getSelectQuery()
	
	// ȸ����ȣ �˻�(search)
	
	// �̸� �˻�(likeSearch)
	
	// ȸ�����(insert)
	
	// ��й�ȣ ����(update)
	
	// ȸ�� ����(delete)

}// end of SjhSqlQueryMap
