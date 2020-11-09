package pattern.practice1.sjhmem.dao;

import java.util.ArrayList;

import pattern.practice1.sjhmem.vo.SMemberVO;

public interface SMemberDAO {

	// 1. 회원등록
	public boolean sMemInsert(SMemberVO smvo);
	// 2. 비밀번호 수정
	public boolean sMemUpdate(SMemberVO smvo);
	// 3. 회원탈퇴
	public boolean sMemDelete(SMemberVO smvo);
	// 4. 전체조회
	public ArrayList<SMemberVO> sMemSelect();
	// 5. 회원번호조회
	public ArrayList<SMemberVO> sMemSearch(SMemberVO smvo);
	// 6. 이름조회
	public ArrayList<SMemberVO> sMemLikeSearch(SMemberVO smvo);
}// end of interface SMemberDAO
