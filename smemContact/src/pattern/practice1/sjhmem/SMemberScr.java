package pattern.practice1.sjhmem;

import java.util.ArrayList;
import java.util.Scanner;

import pattern.practice1.sjhmem.dao.SMemberDAO;
import pattern.practice1.sjhmem.dao.SMemberDAOImpl;
import pattern.practice1.sjhmem.vo.SMemberVO;

public class SMemberScr {


	
	// 1. insert �Լ�
//	public void sMemInsert(String sMemData){
//		System.out.println("[log] sMemInsert �Լ� ����, sMemData : " + sMemData);
//		
//		String sData = sMemData;
//		String[] sDataArray = sData.split("/");
//		System.out.println("sDataArray ���� : " + sDataArray.length);
//		
//		// ������ �б� �� vo�� �ֱ�
//		sName = sDataArray[0];
//		sPw = sDataArray[1];
//		sBirth = sDataArray[2];
//		sHp = sDataArray[3];
//		sMail = sDataArray[4];
//		sPost = sDataArray[5];
//		sAddr = sDataArray[6];
//
//		System.out.println("������ Ȯ�� sName:" + sName
//						+ "/sPw:" + sPw
//						+ "/sBirth:" + sBirth
//						+ "/sHp:" + sHp
//						+ "/sMail:" + sMail
//						+ "/sPost:" + sPost
//						+ "/sAddr:" + sAddr);
//		
//	}// end of sMemInsert(){}
	
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
				+ "3.ȸ�� ����\n"
				+ "4.��ü ȸ�� ��ȸ\n"
				+ "5.ȸ����ȣ �˻�\n"
				+ "6.�̸� �˻�(like�˻�)\n"
				+ ">>> ");
		
		String strNum = scan.nextLine();
		System.out.println("�Էµ����� Ȯ�� strNum : " + strNum);
		
		// 1.ȸ�����(insert)
		if(strNum.equals("1")){
			System.out.println("if�� 1.ȸ�����");
			
	//		// ȸ������ �Է�
	//		System.out.println("ȸ�������� �Է��ϼ���.\n"
	//				+ "(�̸�/��й�ȣ 4�ڸ� ����/������� 8�ڸ�/��ȭ��ȣ/�̸���/�����ȣ/�ּ�)\n"
	//				+ ">>> ");
	//		
	//		String sMemData = scan.nextLine();
	//		System.out.println("�Էµ����� Ȯ�� sMemData : " + sMemData);
	//		
	//		// insert �Լ� ȣ��
	//		smsc.sMemInsert(sMemData);
			
		}// end of if(ȸ�����)
		
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
				System.out.println(i + ". " + sno + "/" + sname + "/" + spw + "/"
								+ sbirth + "/" + shp + "/" + smail + "/" + spost + "/"
								+ saddr + "/" + sinsertdate + "/" + supdatedate + "/"
								+ sdeleteyn + "\n");
			}// end of for
			
		}// end of if(��üȸ�� ��ȸ)
		
		System.out.println("[log] SMemberScr Ŭ���� >>> main �Լ� ��");
	}// end of main

}// end of class SMemberSCr
