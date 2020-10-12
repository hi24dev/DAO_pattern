package pattern.practice1.sjhmem;

import java.util.Scanner;

public class SMemberScr {

	// 변수
	String sName = "";
	String sPw = "";
	String sBirth = "";
	String sHp = "";
	String sMail = "";
	String sPost = "";
	String sAddr = "";
	
	// 1. insert 함수
	public void sMemInsert(String sMemData){
		System.out.println("[log] sMemInsert 함수 시작, sMemData : " + sMemData);
		
		String sData = sMemData;
		String[] sDataArray = sData.split("/");
		System.out.println("sDataArray 길이 : " + sDataArray.length);
		
		// 데이터 분기 후 vo에 넣기
		sName = sDataArray[0];
		sPw = sDataArray[1];
		sBirth = sDataArray[2];
		sHp = sDataArray[3];
		sMail = sDataArray[4];
		sPost = sDataArray[5];
		sAddr = sDataArray[6];

		System.out.println("데이터 확인 sName:" + sName
						+ "/sPw:" + sPw
						+ "/sBirth:" + sBirth
						+ "/sHp:" + sHp
						+ "/sMail:" + sMail
						+ "/sPost:" + sPost
						+ "/sAddr:" + sAddr);
		
	}// end of sMemInsert(){}
	
	// 4. 전체회원 조회
	public static String sMemSelect(){
		
		
		return "";
	}// end of sMemSelect(){}
	
	
	// main 함수 시작
	public static void main(String[] args) {
	System.out.println("[log] SMemberScr 클래스 >>> main 함수 시작");
	
	// 클래스 인스턴스
	SMemberScr smsc = new SMemberScr();
	Scanner scan = new Scanner(System.in);
	
	// 데이터 입력멘트 출력
	System.out.println("실행할 기능의 번호를 입력해주세요.\n"
			+ "1.회원 등록\n"
			+ "2.비밀번호 수정\n"
			+ "3.회원 삭제\n"
			+ "4.전체 회원 조회\n"
			+ "5.회원번호 검색\n"
			+ "6.이름 검색(like검색)\n"
			+ ">>> ");
	
	String strNum = scan.nextLine();
	System.out.println("입력데이터 확인 strNum : " + strNum);
	
	// 1.회원등록(insert)
	if(strNum.equals("1")){
		System.out.println("if문 1.회원등록");
		
		// 회원정보 입력
		System.out.println("회원정보를 입력하세요.\n"
				+ "(이름/비밀번호 4자리 숫자/생년월일 8자리/전화번호/이메일/우편번호/주소)\n"
				+ ">>> ");
		
		String sMemData = scan.nextLine();
		System.out.println("입력데이터 확인 sMemData : " + sMemData);
		
		// insert 함수 호출
		smsc.sMemInsert(sMemData);
		
	}// end of if(회원등록)
	
	// 4. 전체회원 조회(select)
	if(strNum.equals("4")){
		System.out.println("if문 4.전체회원 조회");
		
		// 전체회원 조회 함수 호출
		
	}// end of if(전체회원 조회)
	
	System.out.println("[log] SMemberScr 클래스 >>> main 함수 끝");
	}// end of main

}// end of class SMemberSCr
