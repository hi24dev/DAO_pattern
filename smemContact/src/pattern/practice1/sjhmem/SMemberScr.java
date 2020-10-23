package pattern.practice1.sjhmem;

import java.util.ArrayList;
import java.util.Scanner;

import pattern.practice1.sjhmem.dao.SMemberDAO;
import pattern.practice1.sjhmem.dao.SMemberDAOImpl;
import pattern.practice1.sjhmem.vo.SMemberVO;

public class SMemberScr {

//	String sno = "";
//	String sname = "";
//	String spw = "";
//	String sbirth = "";
//	String shp = "";
//	String smail = "";
//	String spost = "";
//	String saddr = "";
//	String sinsertdate = "";
//	String supdatedate = "";
//	String sdeleteyn = "";
	
	// 1. ȸ�����(insert)
	public boolean sMemInsert(String sMemData){
		System.out.println("[log] sMemInsert �Լ� ����, sMemData : " + sMemData);
		
		boolean insertBool = false;
		String sData = sMemData;
		String[] sDataArray = sData.split("/");
		System.out.println("sDataArray ���� : " + sDataArray.length);
		
		// ������ �б� �� vo�� �ֱ�
		String sname = sDataArray[0];
		String spw = sDataArray[1];
		String sbirth = sDataArray[2];
		String shp = sDataArray[3];
		String smail = sDataArray[4];
		String spost = sDataArray[5];
		String saddr = sDataArray[6];

		System.out.println("������ Ȯ�� sname:" + sname
						+ "/spw:" + spw
						+ "/sbirth:" + sbirth
						+ "/shp:" + shp
						+ "/smail:" + smail
						+ "/spost:" + spost
						+ "/saddr:" + saddr);
		
		SMemberVO smvo = new SMemberVO();
		smvo.setSname(sname);
		smvo.setSpw(spw);
		smvo.setSbirth(sbirth);
		smvo.setShp(shp);
		smvo.setSmail(smail);
		smvo.setSpost(spost);
		smvo.setSaddr(saddr);
		
		// dao����
		SMemberDAO smdao = new SMemberDAOImpl();
		insertBool = smdao.sMemInsert(smvo);
		System.out.println("insertBool : " + insertBool);
		
		return insertBool;
	}// end of sMemInsert(){}
	
	// 2. ��й�ȣ ����(update)
	public boolean sMemUpdate(String sno, String spw){
		System.out.println("[log] SMemberScr.sMemUpdate() >>>"
											+ " ������Ȯ�� sno,spw : " + sno + "," + spw);
		boolean updateBool = false;
		
		// vo�� ���
		SMemberVO smvo = new SMemberVO();
		smvo.setSno(sno);
		smvo.setSpw(spw);
		
		// dao����
		SMemberDAO smdao = new SMemberDAOImpl();
		updateBool = smdao.sMemUpdate(smvo);
		System.out.println("[log] SMemberScr.sMemUpdate >>> updateBool : "  + updateBool);
		return updateBool;
	}// end of sMemUpdate
	
	// 3. ȸ��Ż��(delete)
	public boolean sMemDelete(String sno){
		System.out.println("[log] SMemberScr.sMemDelete() >>> sno : " + sno);
		boolean deleteBool = false;
		
		SMemberVO smvo = new SMemberVO();
		smvo.setSno(sno);
		
		SMemberDAO smdao = new SMemberDAOImpl();
		deleteBool = smdao.sMemDelete(smvo);
		
		System.out.println("sMemDelete() >>> deleteBool : " + deleteBool);
		return deleteBool;
	}
	
	// 4. ��üȸ�� ��ȸ
	public ArrayList<SMemberVO> sMemSelect(){
		System.out.println("[log] SMemberScr Ŭ���� >>> sMemSelect() ��üȸ�� ��ȸ �Լ� ȣ��");
		
		ArrayList<SMemberVO> arraySmemSelect = null;
		
		SMemberDAO smdao = new SMemberDAOImpl();
		
		arraySmemSelect = smdao.sMemSelect();
		System.out.println("arraySmemSelect.size() : " + arraySmemSelect.size());
		
		return arraySmemSelect;
	}// end of sMemSelect(){}
	
	
	// main �Լ� ����
	public static void main(String[] args) {
		System.out.println("[log] SMemberScr Ŭ���� >>> main �Լ� ����");
		
		// ����
		String sno = "";
		String sname = "";
		String spw = "";
		String sbirth = "";
		String shp = "";
		String smail = "";
		String spost = "";
		String saddr = "";
		String sinsertdate = "";
		String supdatedate = "";
		String sdeleteyn = "";
		
		// Ŭ���� �ν��Ͻ�
		SMemberScr smsc = new SMemberScr();
		Scanner scan = new Scanner(System.in);
		
		// ������ �Է¸�Ʈ ���
		System.out.println("������ ����� ��ȣ�� �Է����ּ���.\n"
				+ "1.ȸ�� ���\n"
				+ "2.��й�ȣ ����\n"
				+ "3.ȸ�� Ż��\n"
				+ "4.��ü ȸ�� ��ȸ\n"
				+ "5.ȸ����ȣ �˻�\n"
				+ "6.�̸� �˻�(like�˻�)\n"
				+ ">>> ");
		
		String strNum = scan.nextLine();
		System.out.println("�Էµ����� Ȯ�� strNum : " + strNum);
		
		// 1.ȸ�����(insert)
		if(strNum.equals("1")){
			System.out.println("if�� 1.ȸ�����");
			
			// ȸ������ �Է�
			System.out.println("ȸ�������� �Է��ϼ���.\n"
					+ "(�̸�/��й�ȣ 4�ڸ� ����/������� 8�ڸ�/��ȭ��ȣ/�̸���/�����ȣ/�ּ�)\n"
					+ ">>> ");
			
			String sMemData = scan.nextLine();
			System.out.println("�Էµ����� Ȯ�� sMemData : " + sMemData);
			
			// insert �Լ� ȣ��
			boolean insertBool = false;
			insertBool = smsc.sMemInsert(sMemData);
			System.out.println("insertBool 1 : " + insertBool);
			
			if(insertBool){
				System.out.println("ȸ������� �Ϸ�Ǿ����ϴ�.");
			}else{
				System.out.println("ȸ����Ͽ� �����Ͽ����ϴ�. �ٽ� �õ��Ͻðų� �����ڿ��� �����Ͻʽÿ�.");
			}// end of if
			
		}// end of if(ȸ�����)
		
		// 2. ��й�ȣ ����(update)
		if(strNum.equals("2")){
			System.out.println("if�� 2.��й�ȣ ����");
			
			System.out.println("ȸ����ȣ�� �Է����ּ���. >>> ");
			sno = scan.nextLine();
			
			System.out.println("������ ��й�ȣ�� �Է����ּ���. >>> ");
			spw = scan.nextLine();
			
			System.out.println("�Էµ����� Ȯ�� >>> sno,spw : " + sno + "," + spw);
			
			boolean updateBool = smsc.sMemUpdate(sno, spw);
			
			if(updateBool){
				System.out.println("��й�ȣ�� ���� �Ǿ����ϴ�.");
			}else{
				System.out.println("��й�ȣ ������ �����Ͽ����ϴ�. �ٽ� �õ��Ͻðų� �����ڿ��� �����Ͻʽÿ�.");
			}// end of if
			
		}// end of if(update)
		
		// 3. ȸ�� ����(delete)
		if(strNum.equals("3")){
			System.out.println("if�� 3.ȸ��Ż��");

			System.out.println("Ż���� ȸ���� ȸ����ȣ�� �Է����ּ���. >>> ");
			sno = scan.nextLine();
			
			boolean deleteBool = smsc.sMemDelete(sno);
			
			if(deleteBool){
				System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�.");
			}else{
				System.out.println("ȸ��Ż�� �����Ͽ����ϴ�. �ٽ� �õ��ϰų� �����ڿ��� �����ϽʴϿ�.");
			}// end of if else
		
		}// end of if(delete)
		// 4. ��üȸ�� ��ȸ(select)
		if(strNum.equals("4")){
			System.out.println("if�� 4.��üȸ�� ��ȸ");
			
			ArrayList<SMemberVO> arraySmemSelect = null;
			SMemberVO svo = null;
			
			// ��üȸ�� ��ȸ �Լ� ȣ��
			arraySmemSelect = smsc.sMemSelect();
			
			String test = arraySmemSelect.get(0).getSname();
			System.out.println("test : " + test);
			
			for(int i=0; i<arraySmemSelect.size(); i++){
				svo = new SMemberVO();
				svo = arraySmemSelect.get(i);
				
				sno = svo.getSno();
				sname = svo.getSname();
				spw = svo.getSpw();
				sbirth = svo.getSbirth();
				shp = svo.getShp();
				smail = svo.getSmail();
				spost = svo.getSpost();
				saddr = svo.getSaddr();
				sinsertdate = svo.getSinsertdate();
				supdatedate = svo.getSupdatedate();
				sdeleteyn = svo.getSdeleteyn();
				System.out.println(i+1 + ". " + sno + "/" + sname + "/" + spw + "/"
								+ sbirth + "/" + shp + "/" + smail + "/" + spost + "/"
								+ saddr + "/" + sinsertdate + "/" + supdatedate + "/"
								+ sdeleteyn);
			}// end of for
			
		}// end of if(��üȸ�� ��ȸ)
		
		System.out.println("[log] SMemberScr Ŭ���� >>> main �Լ� ��");
	}// end of main

}// end of class SMemberSCr
