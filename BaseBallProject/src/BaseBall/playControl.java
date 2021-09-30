package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class playControl {
	ArrayList<playerVO> list = new ArrayList<playerVO>();
	jdbcDao dao = new jdbcDao();
	Random ran = new Random();
	ArrayList<playerVO> resultList = new ArrayList<playerVO>();

	public ArrayList<playerVO> select() { // 5명 타자 추출

		// 전체 선수 리스트
		list = dao.select();
		// 되돌려줄 선수 리스트

		for (int i = 0; i < 5; i++) {
			int cho = ran.nextInt(list.size());

			playerVO vo = list.get(cho);
			resultList.add(vo);
			list.remove(cho); // 랜덤으로 뽑힌 선수 인덱스를 제거
			for (int j = 0; j < i; j++) {
				if (resultList.get(j) == resultList.get(i)) {
					i--;
					break;
				}
			}
		}
		return resultList;
	}

	public ArrayList<playerVO> select2() { // 투수 1명 추출
		ArrayList<playerVO> pitList = dao.select2();
		ArrayList<playerVO> pitresultlist = new ArrayList<playerVO>();

		int num = ran.nextInt(pitList.size());
		playerVO vo = pitList.get(num);
		pitresultlist.add(vo);

		return pitresultlist;
	}

	public playerVO select3() { // 타자 1명 추출 (중복 5명 제거 후)
		ArrayList<playerVO> hitList = dao.select3(); // 
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < resultList.size(); j++) {
				if (resultList.get(j) == list.get(i)) {
					// 제거 remove
					list.remove(i);
				}
			}
		}

		int num1 = ran.nextInt(list.size());
		playerVO vo = list.get(num1);
		hitList.add(vo);
		// 추출 1명
		return vo;
	}

}
