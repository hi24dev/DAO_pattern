package pattern.practice1.sjhmem.dao;

import java.util.ArrayList;

import pattern.practice1.sjhmem.vo.SMemberVO;

public interface SMemberDAO {

	// 1. ȸ�����
	public boolean sMemInsert(SMemberVO smvo);
	// 2. ��й�ȣ ����
	public boolean sMemUpdate(SMemberVO smvo);
	// 3. ȸ��Ż��
	public boolean sMemDelete(SMemberVO smvo);
	// 4. ��ü��ȸ
	public ArrayList<SMemberVO> sMemSelect();
	// 5. ȸ����ȣ��ȸ
	public ArrayList<SMemberVO> sMemSearch(SMemberVO smvo);
	// 6. �̸���ȸ
	public ArrayList<SMemberVO> sMemLikeSearch(SMemberVO smvo);
}// end of interface SMemberDAO
