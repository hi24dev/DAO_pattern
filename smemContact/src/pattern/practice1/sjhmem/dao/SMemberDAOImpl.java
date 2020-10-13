package pattern.practice1.sjhmem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pattern.practice1.sjhmem.common.SjhConnProperty;
import pattern.practice1.sjhmem.sql.SjhSqlQueryMap;
import pattern.practice1.sjhmem.vo.SMemberVO;

public class SMemberDAOImpl implements SMemberDAO {

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
