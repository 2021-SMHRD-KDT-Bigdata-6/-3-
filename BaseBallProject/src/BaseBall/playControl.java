package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class playControl {
	jdbcDao dao = new jdbcDao();
	Random ran = new Random();
	
	//����
	//0) ȸ������ �α����� dao���� �߳�
	//1. ���� ���� IG_102 //������
	//2. ����� ���� ���� (IG_104) //����
	//3. ���� �߰� ���� (IG_105) //����
	
	//1-1)���� �̱� DB�� ����� Ÿ�� 5���� �������� ����.
	//dao�� ����
	//ig_100 ,103,105
	
	//1-2)��� Ÿ�� ���� ���� ig_103
	//a) dao���� select�� �޾ƿ��ԵǸ�? Ÿ�ڰ� �� ���ԵǴϱ� �迭�� ���.
	//b) usercontrol���� dao���� �����迭���� �������� �Ѱ��� ������ �����͸� �������� ����.
	
	
	
	//	select * from bbplayer where pl_name = ? and pl_position = ? and pl_capa = ? and rownum <= 5 and pl_position = 'Ÿ��' order by DBMS_random.value
	
	public ArrayList<playerVO> select2() {
		ArrayList<playerVO> list = dao.select2();
		ArrayList<playerVO> resultlist = new ArrayList<playerVO>();		
		
		int num = ran.nextInt(list.size());
		playerVO vo = list.get(num);
		resultlist.add(vo);
		
		return resultlist;
	}
	
	
	
}	
