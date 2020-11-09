package pattern.practice1.sjhmem;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Equals;

import pattern.practice1.sjhmem.dao.SMemberDAO;
import pattern.practice1.sjhmem.dao.SMemberDAOImpl;
import pattern.practice1.sjhmem.vo.SMemberVO;

public class SMemberScr {


	
	// 1. 회원등록(insert)
	public boolean sMemInsert(String sMemData){
		System.out.println("[log] sMemInsert 함수 시작, sMemData : " + sMemData);
		
		boolean insertBool = false;
		String sData = sMemData;
		String[] sDataArray = sData.split("/");
		System.out.println("sDataArray 길이 : " + sDataArray.length);
		
		// 데이터 분기 후 vo에 넣기
		String sname = sDataArray[0];
		String spw = sDataArray[1];
		String sbirth = sDataArray[2];
		String shp = sDataArray[3];
		String smail = sDataArray[4];
		String spost = sDataArray[5];
		String saddr = sDataArray[6];

		System.out.println("데이터 확인 sname:" + sname
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
		
		// dao연결
		SMemberDAO smdao = new SMemberDAOImpl();
		insertBool = smdao.sMemInsert(smvo);
		System.out.println("insertBool : " + insertBool);
		
		return insertBool;
	}// end of sMemInsert(){}
	
	// 2. 비밀번호 수정(update)
	public boolean sMemUpdate(String sno, String spw){
		System.out.println("[log] SMemberScr.sMemUpdate() >>>"
											+ " 데이터확인 sno,spw : " + sno + "," + spw);
		boolean updateBool = false;
		
		// vo에 담기
		SMemberVO smvo = new SMemberVO();
		smvo.setSno(sno);
		smvo.setSpw(spw);
		
		// dao연결
		SMemberDAO smdao = new SMemberDAOImpl();
		updateBool = smdao.sMemUpdate(smvo);
		System.out.println("[log] SMemberScr.sMemUpdate >>> updateBool : "  + updateBool);
		return updateBool;
	}// end of sMemUpdate
	
	// 3. 회원탈퇴(delete)
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
	
	// 4. 전체회원 조회(select)
	public ArrayList<SMemberVO> sMemSelect(){
		System.out.println("[log] SMemberScr 클래스 >>> sMemSelect() 전체회원 조회 함수 호출");
		
		ArrayList<SMemberVO> arraySmemSelect = null;
		
		SMemberDAO smdao = new SMemberDAOImpl();
		
		arraySmemSelect = smdao.sMemSelect();
		System.out.println("arraySmemSelect.size() : " + arraySmemSelect.size());
		
		return arraySmemSelect;
	}// end of sMemSelect(){}
	
	// 5. 회원번호로 조회(search)
	public ArrayList<SMemberVO> sMemSearch(String sno){
		System.out.println("[log] SMemberScr.sMemSearch() 함수 호출"
												+ "\n데이터확인 sno : " + sno);
		ArrayList<SMemberVO> arraySmemSearch = null;
		
		SMemberVO smvo = new SMemberVO();
		smvo.setSno(sno);
		SMemberDAO smdao = new SMemberDAOImpl();
		arraySmemSearch = smdao.sMemSearch(smvo);
		System.out.println("[log] SMemberScr >>>\n"
						+ "데이터확인 arraySmemSearch.size() : " + arraySmemSearch.size());
		
		return arraySmemSearch;
	}// end of sMemSearch
	
	// 6. 이름으로 검색(like)
	public ArrayList<SMemberVO> sMemLikeSearch(String sname){
		System.out.println("[log] SMemberScr.sMemLikeSearch 함수 시작! >>>\n"
													+ "데이터확인 sname : " + sname);
		SMemberDAO smdao = new SMemberDAOImpl();
		ArrayList<SMemberVO> arraySmemLikeSearch = null;
		SMemberVO smvo = new SMemberVO();
		smvo.setSname(sname);
		
		arraySmemLikeSearch = smdao.sMemLikeSearch(smvo);
		
		return arraySmemLikeSearch;
	}// end of sMemLikeSearch
	
	// 출력 함수(printOut)
	public void sMemPrintOut(ArrayList<SMemberVO> aListMember){
		System.out.println("SMemberScr 프린트 함수 호출!\n"
						+ "데이터확인 aListMember.size() : " + aListMember.size());
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
		SMemberVO smvo = null;
		
		if(aListMember.size()>0){
			for(int i=0;i<aListMember.size();i++){
				smvo = new SMemberVO();
				smvo = aListMember.get(i);
				sno = smvo.getSno();
				sname = smvo.getSname();
				spw = smvo.getSpw();
				sbirth = smvo.getSbirth();
				shp = smvo.getShp();
				smail = smvo.getSmail();
				spost = smvo.getSpost();
				saddr = smvo.getSaddr();
				sinsertdate = smvo.getSinsertdate();
				supdatedate = smvo.getSupdatedate();
				sdeleteyn = smvo.getSdeleteyn();
				System.out.println(i+1 + ". " + sno + "/" + sname + "/" + spw + "/"
								+ sbirth + "/" + shp + "/" + smail + "/" + spost + "/"
								+ saddr + "/" + sinsertdate + "/" + supdatedate + "/"
								+ sdeleteyn);
			}// end of for
		}else{
			System.out.println("조회할 회원이 없습니다.");
		}// end of if-else	
		
	}// end of sMemPrintOut()
	
	// main 함수 시작
	public static void main(String[] args) {
		System.out.println("[log] SMemberScr 클래스 >>> main 함수 시작");
		
		// 변수
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
		
		// 클래스 인스턴스
		SMemberScr smsc = new SMemberScr();
		Scanner scan = new Scanner(System.in);
		
		// 데이터 입력멘트 출력
		System.out.println("실행할 기능의 번호를 입력해주세요.\n"
				+ "1.회원 등록\n"
				+ "2.비밀번호 수정\n"
				+ "3.회원 탈퇴\n"
				+ "4.전체 회원 조회\n"
				+ "5.회원번호로 조회\n"
				+ "6.이름으로 검색(like)\n"
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
			boolean insertBool = false;
			insertBool = smsc.sMemInsert(sMemData);
			System.out.println("insertBool 1 : " + insertBool);
			
			if(insertBool){
				System.out.println("회원등록이 완료되었습니다.");
			}else{
				System.out.println("회원등록에 실패하였습니다. 다시 시도하시거나 관리자에게 문의하십시오.");
			}// end of if
			
		}// end of if(회원등록)
		
		// 2. 비밀번호 수정(update)
		if(strNum.equals("2")){
			System.out.println("if문 2.비밀번호 수정");
			
			System.out.println("회원번호를 입력해주세요. >>> ");
			sno = scan.nextLine();
			
			System.out.println("수정할 비밀번호를 입력해주세요. >>> ");
			spw = scan.nextLine();
			
			System.out.println("입력데이터 확인 >>> sno,spw : " + sno + "," + spw);
			
			boolean updateBool = smsc.sMemUpdate(sno, spw);
			
			if(updateBool){
				System.out.println("비밀번호가 수정 되었습니다.");
			}else{
				System.out.println("비밀번호 수정에 실패하였습니다. 다시 시도하시거나 관리자에게 문의하십시오.");
			}// end of if
			
		}// end of if(update)
		
		// 3. 회원 삭제(delete)
		if(strNum.equals("3")){
			System.out.println("if문 3.회원탈퇴");

			System.out.println("탈퇴할 회원의 회원번호를 입력해주세요. >>> ");
			sno = scan.nextLine();
			
			boolean deleteBool = smsc.sMemDelete(sno);
			
			if(deleteBool){
				System.out.println("회원탈퇴가 완료되었습니다.");
			}else{
				System.out.println("회원탈퇴에 실패하였습니다. 다시 시도하거나 관리자에게 문의하십니오.");
			}// end of if else
		
		}// end of if(delete)
		
		// 4. 전체회원 조회(select)
		if(strNum.equals("4")){
			System.out.println("if문 4.전체회원 조회");
			
			ArrayList<SMemberVO> arraySmemSelect = null;
			SMemberVO svo = null;
			
			// 전체회원 조회 함수 호출
			arraySmemSelect = smsc.sMemSelect();

			// 데이터 출력
			smsc.sMemPrintOut(arraySmemSelect);
			
		}// end of if(전체회원 조회)
		
		// 5.회원번호로 검색(search)
		if(strNum.equals("5")){
			System.out.println("if문 5.회원번호로 검색");
			
			System.out.println("검색할 회원번호를 입력해주세요. >>> ");
			sno = scan.nextLine();
			
			ArrayList<SMemberVO> arraySmemSearch = smsc.sMemSearch(sno);
			
			// 데이터 출력
			smsc.sMemPrintOut(arraySmemSearch);
					
		}// end of if(5)
		
		// 6.이름으로 검색(like)
		if(strNum.equals("6")){
			System.out.println("if문 6.이름으로 검색");
			
			System.out.println("검색할 회원의 이름을 입력해주세요. >>> ");
			sname = scan.nextLine();
			ArrayList<SMemberVO> arraySmemLikeSearch = smsc.sMemLikeSearch(sname);
			
			// 데이터출력
			smsc.sMemPrintOut(arraySmemLikeSearch);
			
		}// end of if(6)
		
		System.out.println("[log] SMemberScr 클래스 >>> main 함수 끝");
	}// end of main

}// end of class SMemberSCr
