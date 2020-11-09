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
	@Override
	public boolean sMemInsert(SMemberVO smvo){
//		System.out.println("[log] SMemberDAOImpl.sMemInsert �Լ� ȣ��!\n"
//								+ "������ Ȯ�� >>> smvo.getSname : " + smvo.getSname());
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
			
//			System.out.println("SjhChaebun.SMemChaebun() : " + SjhChaebun.SMemChaebun());
			pstmt.setString(1, SjhChaebun.SMemChaebun());
			pstmt.setString(2, smvo.getSname());
			pstmt.setString(3, smvo.getSpw());
			pstmt.setString(4, smvo.getSbirth());
			pstmt.setString(5, smvo.getShp());
			pstmt.setString(6, smvo.getSmail());
			pstmt.setString(7, smvo.getSpost());
			pstmt.setString(8, smvo.getSaddr());
			pstmt.setString(9, "N");
			
			nCntInsert = pstmt.executeUpdate();
//			System.out.println("������Ʈ ���� nCntInsert : " + nCntInsert);
			
			// �ڵ� Ŀ��
//			boolean b = !con.getAutoCommit();
//			System.out.println("b >>> : " + b);
//			if (b) con.commit();
			
			SjhConnProperty.conClose(con, pstmt);
//			System.out.println("[log] db���� ����");
		} catch (Exception e) {
			System.out.println("insert ���� >>> " + e.getMessage());
		} finally{
			SjhConnProperty.conClose(con, pstmt);
//			System.out.println("[log] db���� ����");
		}// end of try catch
		
		if(nCntInsert==1){
			insertBool = true;
		}else{
			System.out.println("insert ����");
		}// end of if
		
//		System.out.println("insertBool : " + insertBool);
		
		return insertBool;
	}// end of sMemInsert(ȸ�����)
	
	// 2.��й�ȣ ����(update)
	@Override
	public boolean sMemUpdate(SMemberVO smvo){
//		System.out.println("[log] daoimpl ������� sMemUpdate() ����! >>>"
//										+ " ������Ȯ�� smvo.getSno : " + smvo.getSno() 
//										+ ", smvo.getSpw : "+ smvo.getSpw());
		boolean updateBool = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateInt = 0;
		
		try {
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getUpdateQuery());
			
			pstmt.setString(1, smvo.getSpw());
			pstmt.setString(2, smvo.getSno());
			updateInt = pstmt.executeUpdate();
//			System.out.println("update ���� ���� updateInt : " + updateInt);
			
			SjhConnProperty.conClose(con, pstmt);
//			System.out.println("[log] update db���� ����");
		} catch (Exception e){
			System.out.println("update ������ >>> " + e.getMessage());
		} finally{
			SjhConnProperty.conClose(con, pstmt);
//			System.out.println("[log] update db���� ����");
		}// end of try catch
		
		if(updateInt>0){
			updateBool = true;
		}else{
			System.out.println("update ����");
		}// end of if
		return updateBool;
	}// end of sMemUpdate
	
	// 3.ȸ��Ż��
	@Override
	public boolean sMemDelete(SMemberVO smvo){
//		System.out.println("[log] daoimpl ȸ��Ż�� �Լ� ȣ�� >>> smvo.getSno : " + smvo.getSno());
		boolean deleteBool = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int nCntDelete = 0;
		
		try{
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getDeleteQuery());
			
			pstmt.setString(1, "Y");
			pstmt.setString(2, smvo.getSno());
			nCntDelete = pstmt.executeUpdate();
//			System.out.println("nCntDelete : " + nCntDelete);
			
			SjhConnProperty.conClose(con, pstmt);
//			System.out.println("[log] ȸ��Ż�� db���� ����");
		}catch(Exception e){
			System.out.println("delete ������ >>> " + e.getMessage());
		}finally{
			SjhConnProperty.conClose(con, pstmt);
//			System.out.println("[log] ȸ��Ż�� db���� ����");
		}// end of finally
		
		if(nCntDelete>0){
			deleteBool = true;
		}else{
			System.out.println("delete ����");
		}// end of if else
		return deleteBool;
	}// end of sMemDelete()
	
	// 4.��ü��ȸ
	@Override
	public ArrayList<SMemberVO> sMemSelect() {
//		System.out.println("[log] daoimpl >>> ��ü��ȸ sMemSelect() �Լ� ȣ��");
		
		// db���� ��������
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<SMemberVO> alist = null;
		SMemberVO svo = null;
		
		try {
			// db ����
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getSelectQuery());
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
//				System.out.println("alist.size() : " + alist.size());
				
			}else{
				System.out.println("[log] rsRs�� null");
			}// end of if else				
			
		} catch (Exception e) {
			// getConnection ����
			System.out.println("[log] DB ���� ���� >>> " + e.getMessage());
		} finally {
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] DB ���� ����");
			
		}// end of try catch finally
		
//		System.out.println("[log] daoimpl >>> ��ü��ȸ sMemSelect() �Լ� ��");
		return alist;
	}// end of sMemSelect()

	// 5.ȸ����ȣ�� ��ȸ
	@Override
	public ArrayList<SMemberVO> sMemSearch(SMemberVO _smvo){
//		System.out.println("[log] �ٿ����� sMemSearch �Լ� ȣ��!\n"
//										+ "������ Ȯ�� _smvo.getSno() : " + _smvo.getSno());
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<SMemberVO> arraySmemSearch = null;
		SMemberVO smvo = null;
		
		try {
			//db����
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getSearchQuery());
			pstmt.setString(1, _smvo.getSno());
			rsRs = pstmt.executeQuery();
						
			if(rsRs!=null){
				arraySmemSearch = new ArrayList<SMemberVO>();
				
				while(rsRs.next()){
					smvo = new SMemberVO();
					smvo.setSno(rsRs.getString("sno"));
					smvo.setSname(rsRs.getString("sname"));
					smvo.setSpw(rsRs.getString("spw"));
					smvo.setSbirth(rsRs.getString("sbirth"));
					smvo.setShp(rsRs.getString("shp"));
					smvo.setSmail(rsRs.getString("smail"));
					smvo.setSpost(rsRs.getString("spost"));
					smvo.setSaddr(rsRs.getString("saddr"));
					smvo.setSinsertdate(rsRs.getString("sinsertdate"));
					smvo.setSupdatedate(rsRs.getString("supdatedate"));
					smvo.setSdeleteyn(rsRs.getString("sdeleteyn"));
					
					arraySmemSearch.add(smvo);
				}// end of while
			}else{
				System.out.println("[log] rsRs�� ����");
			}// end of if-esle(��üũ)
			
			//db���� ����
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] �ٿ����� db���� ����");
		} catch (Exception e) {
			System.out.println("[log] �ٿ����� ������ >>> " + e.getMessage());
		} finally {
			//db���� ����
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] �ٿ����� db���� ����");
		}// end of try catch finally
		
//		System.out.println("[log] �ٿ����� search �Լ� ����!");
		return arraySmemSearch;
	}// end of sMemSearch

	// 6.�̸����� ��ȸ
	@Override
	public ArrayList<SMemberVO> sMemLikeSearch(SMemberVO _smvo){
//		System.out.println("[log] �ٿ����� sMemLikeSearch �Լ� ȣ��! >>> \n"
//									+ "������Ȯ�� _smvo.getSname() : " + _smvo.getSname());
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		SMemberVO smvo = null;
		ArrayList<SMemberVO> arraySmemLikeSearch = null;
		
		try{
			// db����
			con = SjhConnProperty.getConnection();
			pstmt = con.prepareStatement(SjhSqlQueryMap.getLikeSearchQuery());
			pstmt.setString(1, _smvo.getSname());
			rsRs = pstmt.executeQuery();
			
			// rsRs ��üũ
			if(rsRs!=null){
				arraySmemLikeSearch = new ArrayList<SMemberVO>();
				
				while(rsRs.next()){
					smvo = new SMemberVO();
					smvo.setSno(rsRs.getString("sno"));
					smvo.setSname(rsRs.getString("sname"));
					smvo.setSpw(rsRs.getString("spw"));
					smvo.setSbirth(rsRs.getString("sbirth"));
					smvo.setShp(rsRs.getString("shp"));
					smvo.setSmail(rsRs.getString("smail"));
					smvo.setSpost(rsRs.getString("spost"));
					smvo.setSaddr(rsRs.getString("saddr"));
					smvo.setSinsertdate(rsRs.getString("sinsertdate"));
					smvo.setSupdatedate(rsRs.getString("supdatedate"));
					smvo.setSdeleteyn(rsRs.getString("sdeleteyn"));
					
					arraySmemLikeSearch.add(smvo);
				}// end of while
			}else{
				System.out.println("rsRs�� ����");
			}// end of if-else(��üũ)
			
			// db���� ����
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] �ٿ����� db���� ����");
		}catch(Exception e){
			System.out.println("[log] �ٿ����� db���� ������ >>> " + e.getMessage());
		}finally{
			// db���� ����
			SjhConnProperty.conClose(con, pstmt, rsRs);
//			System.out.println("[log] �ٿ����� db���� ����");
		}// end of try catch finally
		
//		System.out.println("[log] �ٿ����� likeSearch ���� ");
		return arraySmemLikeSearch;
	}// end of sMemLikeSearch()

}// end of SMemberDAOImpl
