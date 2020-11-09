package pattern.practice1.sjhmem.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import pattern.practice1.sjhmem.sql.SjhSqlQueryMap;

public abstract class SjhChaebun {

	public static final String SMEMBER_GUBUN_S = "S";
	
	public static String SMemChaebun(){
//		System.out.println("[log] SjhChaebun.SMemChaebun 함수 호출!");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String smemNo = "";
		
		try {
			// db연결
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.SMEMBER_CHAEBUN_SNO);
			rsRs = pstmt.executeQuery();
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String date = sdf.format(d);
			String commno = "";
					
			boolean rsBool = false;
			rsBool = rsRs.next();
			
			if(rsRs!=null){
				while(rsBool){
					commno = rsRs.getString("commno");
//					System.out.println("데이터확인 commno : " + commno);
					rsBool = false;
				}// end of while
			}// end of if
			
			// 01 11
			int commLen = commno.length();
			
			for(commno.length();commLen<2;commLen++){
				commno = 0 + commno;
			}// end of for
			
			smemNo = SMEMBER_GUBUN_S + date + commno;
//			System.out.println("데이터확인 smemNo : " + smemNo);
			
			// db연결 종료
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] 채번클래스 db연결 종료");
		} catch (Exception e) {
			System.out.println("db연결 에러가 >>> " + e.getMessage());
		} finally {
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] 채번클래스 db연결 종료");
		}// end of try catch
		
		return smemNo;
	}// end of SMemChaebun
	
	public static void main(String[] args) {
		System.out.println("[log] SjhChaebun.main 함수 test 시작!");

		// test
		String sss = SjhChaebun.SMemChaebun();
		System.out.println("sss : " + sss);
		
		System.out.println("[log] SjhChaebun.main 함수 끝!");
	}// end of main

}// end of class SjhChaebun
