package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class playControl {
	ArrayList<playerVO> list = new ArrayList<playerVO>();
	jdbcDao dao = new jdbcDao();
	Random ran = new Random();
	// ����
	// 0) ȸ������ �α����� dao���� �߳�
	// 1. ���� ���� IG_102 //������
	// 2. ����� ���� ���� (IG_104) //����
	// 3. ���� �߰� ���� (IG_105) //����

	// 1-1)���� �̱� DB�� ����� Ÿ�� 5���� �������� ����.
	// dao�� ����
	// ig_100 ,103,105

	public ArrayList<playerVO> select() { //5�� Ÿ�� ����
		// ��ü ���� ����Ʈ
		list = dao.select();
		// �ǵ����� ���� ����Ʈ
		ArrayList<playerVO> resultList = new ArrayList<playerVO>();
		for (int i = 0; i < 5; i++) {
			int cho = ran.nextInt(list.size());
			
			playerVO vo = list.get(cho);
			resultList.add(vo);
			list.remove(cho); // �������� ���� ���� �ε����� ����
			for (int j = 0; j < i; j++) {
				if(resultList.get(j)==resultList.get(i)) {
					i--;
				break;	
				}
			}
		}
		return resultList;
	}

	public ArrayList<playerVO> select2() { // ���� 1�� ����
		ArrayList<playerVO> pitList = dao.select2();
		ArrayList<playerVO> resultlist = new ArrayList<playerVO>();

		int num = ran.nextInt(pitList.size());
		playerVO vo = pitList.get(num);
		resultlist.add(vo);

		return resultlist;
	}

}
