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

	// 1.ȸ�����
	public boolean sMemInsert(SMemberVO smvo){
		System.out.println("[log] SMemberDAOImpl.sMemInsert �Լ� ȣ��!\n"
								+ "������ Ȯ�� >>> smvo.getSname : " + smvo.getSname());
		boolean insertBool = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCntInsert = 0;
		
		try {
			// db����
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getInsertQuery());
			
			// �ڵ� Ŀ��
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
			System.out.println("������Ʈ ���� nCntInsert : " + nCntInsert);
			
			// �ڵ� Ŀ��
//			boolean b = !con.getAutoCommit();
//			System.out.println("b >>> : " + b);
//			if (b) con.commit();
			
			SjhConnProperty.conClose(con, pstmt);
			System.out.println("[log] db���� ����");
		} catch (Exception e) {
			System.out.println("������ 111 >>> " + e.getMessage());
		} finally{
			SjhConnProperty.conClose(con, pstmt);
			System.out.println("[log] db���� ����");
		}// end of try catch
		
		if(nCntInsert==1){
			insertBool = true;
		}else{
			System.out.println("insert ����");
		}// end of if
		
		System.out.println("insertBool : " + insertBool);
		
		return insertBool;
	}// end of sMemInsert(ȸ�����)
	
	// 4.��ü��ȸ
	@Override
	public ArrayList<SMemberVO> sMemSelect() {
		System.out.println("[log] daoimpl >>> ��ü��ȸ sMemSelect() �Լ� ȣ��");
		
		// db���� ��������
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<SMemberVO> alist = null;
		SMemberVO svo = null;
		
		try {
			// oracle�� ����
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
				System.out.println("[log] rsRs�� null");
			}// end of if else				
			
		} catch (Exception e) {
			// getConnection ����
			System.out.println("[log] DB ���� ���� >>> " + e.getMessage());
		} finally {
			SjhConnProperty.conClose(con, pstmt, rsRs);
			System.out.println("[log] DB ���� ����");
			
		}// end of try catch finally
		
		System.out.println("[log] daoimpl >>> ��ü��ȸ sMemSelect() �Լ� ��");
		return alist;
	}// end of sMemSelect()

}// end of SMemberDAOImpl
