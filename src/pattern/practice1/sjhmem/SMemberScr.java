package pattern.practice1.sjhmem;

import java.util.Scanner;

public class SMemberScr {

	// ����
	String sName = "";
	String sPw = "";
	String sBirth = "";
	String sHp = "";
	String sMail = "";
	String sPost = "";
	String sAddr = "";
	
	// 1. insert �Լ�
	public void sMemInsert(String sMemData){
		System.out.println("[log] sMemInsert �Լ� ����, sMemData : " + sMemData);
		
		String sData = sMemData;
		String[] sDataArray = sData.split("/");
		System.out.println("sDataArray ���� : " + sDataArray.length);
		
		// ������ �б� �� vo�� �ֱ�
		sName = sDataArray[0];
		sPw = sDataArray[1];
		sBirth = sDataArray[2];
		sHp = sDataArray[3];
		sMail = sDataArray[4];
		sPost = sDataArray[5];
		sAddr = sDataArray[6];

		System.out.println("������ Ȯ�� sName:" + sName
						+ "/sPw:" + sPw
						+ "/sBirth:" + sBirth
						+ "/sHp:" + sHp
						+ "/sMail:" + sMail
						+ "/sPost:" + sPost
						+ "/sAddr:" + sAddr);
		
	}// end of sMemInsert(){}
	
	// 4. ��üȸ�� ��ȸ
	public static String sMemSelect(){
		
		
		return "";
	}// end of sMemSelect(){}
	
	
	// main �Լ� ����
	public static void main(String[] args) {
	System.out.println("[log] SMemberScr Ŭ���� >>> main �Լ� ����");
	
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
		
		// ȸ������ �Է�
		System.out.println("ȸ�������� �Է��ϼ���.\n"
				+ "(�̸�/��й�ȣ 4�ڸ� ����/������� 8�ڸ�/��ȭ��ȣ/�̸���/�����ȣ/�ּ�)\n"
				+ ">>> ");
		
		String sMemData = scan.nextLine();
		System.out.println("�Էµ����� Ȯ�� sMemData : " + sMemData);
		
		// insert �Լ� ȣ��
		smsc.sMemInsert(sMemData);
		
	}// end of if(ȸ�����)
	
	// 4. ��üȸ�� ��ȸ(select)
	if(strNum.equals("4")){
		System.out.println("if�� 4.��üȸ�� ��ȸ");
		
		// ��üȸ�� ��ȸ �Լ� ȣ��
		
	}// end of if(��üȸ�� ��ȸ)
	
	System.out.println("[log] SMemberScr Ŭ���� >>> main �Լ� ��");
	}// end of main

}// end of class SMemberSCr
