package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class playControl {
	ArrayList<playerVO> list = new ArrayList<playerVO>();
	jdbcDao dao = new jdbcDao();
	Random ran = new Random();
	ArrayList<playerVO> resultList = new ArrayList<playerVO>();

	public ArrayList<playerVO> select() { // 5�� Ÿ�� ����

		// ��ü ���� ����Ʈ
		list = dao.select();
		// �ǵ����� ���� ����Ʈ

		for (int i = 0; i < 5; i++) {
			int cho = ran.nextInt(list.size());

			playerVO vo = list.get(cho);
			resultList.add(vo);
			list.remove(cho); // �������� ���� ���� �ε����� ����
			for (int j = 0; j < i; j++) {
				if (resultList.get(j) == resultList.get(i)) {
					i--;
					break;
				}
			}
		}
		return resultList;
	}

	public ArrayList<playerVO> select2() { // ���� 1�� ����
		ArrayList<playerVO> pitList = dao.select2();
		ArrayList<playerVO> pitresultlist = new ArrayList<playerVO>();

		int num = ran.nextInt(pitList.size());
		playerVO vo = pitList.get(num);
		pitresultlist.add(vo);

		return pitresultlist;
	}

	public playerVO select3() { // Ÿ�� 1�� ���� (�ߺ� 5�� ���� ��)
		ArrayList<playerVO> hitList = dao.select3(); // 
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < resultList.size(); j++) {
				if (resultList.get(j) == list.get(i)) {
					// ���� remove
					list.remove(i);
				}
			}
		}

		int num1 = ran.nextInt(list.size());
		playerVO vo = list.get(num1);
		hitList.add(vo);
		// ���� 1��
		return vo;
	}

}
