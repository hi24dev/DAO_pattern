package pattern.practice1.sjhmem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pattern.practice1.sjhmem.common.SjhChaebun;
import pattern.practice1.sjhmem.common.SjhConnProperty;
import pattern.practice1.sjhmem.sql.SjhSqlQueryMap;
import pattern.practice1.sjhmem.vo.SMemberVO;

public class SMemberDAOImpl implements SMemberDAO {

	// 1.회원등록
	public boolean sMemInsert(SMemberVO smvo){
		System.out.println("[log] SMemberDAOImpl.sMemInsert 함수 호출!\n"
								+ "데이터 확인 >>> smvo.getSname : " + smvo.getSname());
		boolean insertBool = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCntInsert = 0;
		
		try {
			// db연결
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getInsertQuery());
			
			// 자동 커밋
//			setAutoCommit(boolean autoCommit)
			// Sets this connection's auto-commit mode to the given state.
			
			System.out.println("SjhChaebun.SMemChaebun() : " + SjhChaebun.SMemChaebun());
			pstmt.setString(1, SjhChaebun.SMemChaebun());
			pstmt.setString(2, smvo.getSname());
			pstmt.setString(3, smvo.getSpw());
			pstmt.setString(4, smvo.getSbirth());
			pstmt.setString(5, smvo.getShp());
			pstmt.setString(6, smvo.getSmail());
			pstmt.setString(7, smvo.getSpost());
			pstmt.setString(8, smvo.getSaddr());
			pstmt.setString(9, "Y");
			
			nCntInsert = pstmt.executeUpdate();
			System.out.println("업데이트 갯수 nCntInsert : " + nCntInsert);
			
			// 자동 커밋
//			boolean b = !con.getAutoCommit();
//			System.out.println("b >>> : " + b);
//			if (b) con.commit();
			
			SjhConnProperty.conClose(con, pstmt);
			System.out.println("[log] db연결 종료");
		} catch (Exception e) {
			System.out.println("에러가 111 >>> " + e.getMessage());
		} finally{
			SjhConnProperty.conClose(con, pstmt);
			System.out.println("[log] db연결 종료");
		}// end of try catch
		
		if(nCntInsert==1){
			insertBool = true;
		}else{
			System.out.println("insert 실패");
		}// end of if
		
		System.out.println("insertBool : " + insertBool);
		
		return insertBool;
	}// end of sMemInsert(회원등록)
	
	// 4.전체조회
	@Override
	public ArrayList<SMemberVO> sMemSelect() {
		System.out.println("[log] daoimpl >>> 전체조회 sMemSelect() 함수 호출");
		
		// db연동 변수선언
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<SMemberVO> alist = null;
		SMemberVO svo = null;
		
		try {
			// oracle에 연결
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getSelectQuery());
//			System.out.println("SjhSqlQueryMap.getSelectQuery() : " + SjhSqlQueryMap.getSelectQuery());
			rsRs = pstmt.executeQuery();

			if(rsRs!=null){
				alist = new ArrayList<SMemberVO>();
				
				while(rsRs.next()){
					svo = new SMemberVO();
					svo.setSno(rsRs.getString("sno"));
					svo.setSname(rsRs.getString("sname"));
					svo.setSpw(rsRs.getString("spw"));
					svo.setSbirth(rsRs.getString("sbirth"));
					svo.setShp(rsRs.getString("shp"));
					svo.setSmail(rsRs.getString("smail"));
					svo.setSpost(rsRs.getString("spost"));
					svo.setSaddr(rsRs.getString("saddr"));
					svo.setSinsertdate(rsRs.getString("sinsertdate"));
					svo.setSupdatedate(rsRs.getString("supdatedate"));
					svo.setSdeleteyn(rsRs.getString("sdeleteyn"));
					alist.add(svo);
				}// end of while
				System.out.println("alist.size() : " + alist.size());
				
			}else{
				System.out.println("[log] rsRs가 null");
			}// end of if else				
			
		} catch (Exception e) {
			// getConnection 실패
			System.out.println("[log] DB 연결 에러 >>> " + e.getMessage());
		} finally {
			SjhConnProperty.conClose(con, pstmt, rsRs);
			System.out.println("[log] DB 연결 종료");
			
		}// end of try catch finally
		
		System.out.println("[log] daoimpl >>> 전체조회 sMemSelect() 함수 끝");
		return alist;
	}// end of sMemSelect()

}// end of SMemberDAOImpl
