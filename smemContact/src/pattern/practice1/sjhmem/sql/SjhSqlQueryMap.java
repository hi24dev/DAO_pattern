package pattern.practice1.sjhmem.sql;

public class SjhSqlQueryMap {

	// 채번 상수
	
	// 전체 회원 조회(select)
	public static String getSelectQuery(){
		System.out.println("[log] pattern.practice1.sjhmem.sql.SjhSqlQueryMap 클래스 >>> getSelectQuery() 함수 시작");
		
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
		
		System.out.println("[log] getSelectQuery() 함수 끝");
		return sb.toString();
	}// end of getSelectQuery()
	
	// 회원번호 검색(search)
	
	// 이름 검색(likeSearch)
	
	// 회원등록(insert)
	
	// 비밀번호 수정(update)
	
	// 회원 삭제(delete)

}// end of SjhSqlQueryMap
