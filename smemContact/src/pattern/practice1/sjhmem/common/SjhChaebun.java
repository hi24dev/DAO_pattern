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
//		System.out.println("[log] SjhChaebun.SMemChaebun �Լ� ȣ��!");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String smemNo = "";
		
		try {
			// db����
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
//					System.out.println("������Ȯ�� commno : " + commno);
					rsBool = false;
				}// end of while
			}// end of if
			
			// 01 11
			int commLen = commno.length();
			
			for(commno.length();commLen<2;commLen++){
				commno = 0 + commno;
			}// end of for
			
			smemNo = SMEMBER_GUBUN_S + date + commno;
//			System.out.println("������Ȯ�� smemNo : " + smemNo);
			
			// db���� ����
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] ä��Ŭ���� db���� ����");
		} catch (Exception e) {
			System.out.println("db���� ������ >>> " + e.getMessage());
		} finally {
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] ä��Ŭ���� db���� ����");
		}// end of try catch
		
		return smemNo;
	}// end of SMemChaebun
	
	public static void main(String[] args) {
		System.out.println("[log] SjhChaebun.main �Լ� test ����!");

		// test
		String sss = SjhChaebun.SMemChaebun();
		System.out.println("sss : " + sss);
		
		System.out.println("[log] SjhChaebun.main �Լ� ��!");
	}// end of main

}// end of class SjhChaebun
