package pattern.practice1.sjhmem.sql;

public class SjhSqlQueryMap {

	// 채번 상수
	public static final String SMEMBER_CHAEBUN_SNO = 
					  " SELECT 		/* INDEX_DESC(SMEMBER_CONTACT_PK) */ "
				    + " 	 NVL(MAX(SUBSTR(S.SNO,-2)),0)+1  	COMMNO "
				    + " FROM SMEMBER_CONTACT   S ";
	
	// 전체 회원 조회(select)
	public static String getSelectQuery(){
//		System.out.println("[log] 쿼리맵 >>> getSelectQuery() 함수 시작");
		
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
		sb.append(" FROM  SMEMBER_CONTACT   S		\n");
		sb.append(" WHERE S.SDELETEYN = 'N'			\n");
		sb.append(" ORDER BY 1");
		
		String selectStr = sb.toString();
//		System.out.println("[log] getSelectQuery() 함수 끝");
		return selectStr;
	}// end of getSelectQuery()
	
	// 회원번호 검색(search)
	public static String getSearchQuery(){
//		System.out.println("[log] 쿼리맵 >>> getSearchQuery() 함수 시작");
		
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
		sb.append(" FROM  SMEMBER_CONTACT   S		\n");
		sb.append(" WHERE S.SNO = ?					\n");
		sb.append(" AND	  S.SDELETEYN = 'N'			  ");		
		
		String searchStr = sb.toString();
//		System.out.println("[log] getSearchQuery() 함수 끝");
		return searchStr;
	}// end of getSearchQuery()
	
	// 이름으로 검색(likeSearch)
	public static String getLikeSearchQuery(){
//		System.out.println("[log] getLikeSearchQuery() 함수 시작");
		
		String likeSearchStr = "";
		
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
		sb.append(" FROM  SMEMBER_CONTACT   S		\n");
		sb.append(" WHERE S.SNAME LIKE '%' ||?|| '%'	\n");
		sb.append(" AND	  S.SDELETEYN = 'N'			  ");				
	
		likeSearchStr = sb.toString();
		
//		System.out.println("[log] getLikeSearchQuery() 함수 끝");
		return likeSearchStr;
	}// end of getLikeSearchQuery()
	
	// 회원등록(insert)
	public static String getInsertQuery(){
//		System.out.println("[log] getInsertQuery() 함수 시작");
		
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
//		System.out.println("[log] getInsertQuery() 함수 끝");
		return insertStr;
	}// end of getInsertQuery()
	
	// 비밀번호 수정(update)
	public static String getUpdateQuery(){
//		System.out.println("[log] getUpdateQuery() 함수 시작");
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE 	 SMEMBER_CONTACT  S		\n");
		sb.append("SET  	 S.SPW = ?				\n");
		sb.append("    		,S.SUPDATEDATE = SYSDATE	\n");
		sb.append("WHERE 	 S.SNO = ?				\n");
		sb.append("AND   	 S.SDELETEYN = 'N'		\n");
		
		String updateStr = sb.toString();		
//		System.out.println("[log] getUpdateQuery() 함수 끝");
		return updateStr;
	}// end of getUpdateQuery()
	
	// 회원 삭제(delete)
	public static String getDeleteQuery(){
//		System.out.println("[log] getDeleteQuery() 함수 시작");
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE SMEMBER_CONTACT  S			\n");
		sb.append("SET  	 S.SDELETEYN = ?			\n");
		sb.append("    		,S.SUPDATEDATE = SYSDATE	\n");
		sb.append("WHERE 	 S.SNO = ?					\n");
		sb.append("AND   	 S.SDELETEYN = 'N'			  ");
		
		String deleteStr = sb.toString();
//		System.out.println("[log] getDeleteQuery() 함수 끝");
		return deleteStr;
	}

}// end of SjhSqlQueryMap
