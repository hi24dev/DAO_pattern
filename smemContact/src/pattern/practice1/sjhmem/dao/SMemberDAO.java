package pattern.practice1.sjhmem.dao;

import java.util.ArrayList;

import pattern.practice1.sjhmem.vo.SMemberVO;

public interface SMemberDAO {

	// 4. 전체조회
	public ArrayList<SMemberVO> sMemSelect();

}// end of interface SMemberDAO
