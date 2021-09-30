package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class playControl {
	ArrayList<playerVO> list = new ArrayList<playerVO>();
	jdbcDao dao = new jdbcDao();
	Random ran = new Random();
	// 로직
	// 0) 회원가입 로그인을 dao에서 했네
	// 1. 선수 추출 IG_102 //진행중
	// 2. 사용자 점수 변경 (IG_104) //정현
	// 3. 선수 추가 추출 (IG_105) //정현

	// 1-1)선수 뽑기 DB에 저장된 타자 5명을 랜덤으로 추출.
	// dao에 있음
	// ig_100 ,103,105

	public ArrayList<playerVO> select() { //5명 타자 추출
		// 전체 선수 리스트
		list = dao.select();
		// 되돌려줄 선수 리스트
		ArrayList<playerVO> resultList = new ArrayList<playerVO>();
		for (int i = 0; i < 5; i++) {
			int cho = ran.nextInt(list.size());
			
			playerVO vo = list.get(cho);
			resultList.add(vo);
			list.remove(cho); // 랜덤으로 뽑힌 선수 인덱스를 제거
			for (int j = 0; j < i; j++) {
				if(resultList.get(j)==resultList.get(i)) {
					i--;
				break;	
				}
			}
		}
		return resultList;
	}

	public ArrayList<playerVO> select2() { // 투수 1명 추출
		ArrayList<playerVO> pitList = dao.select2();
		ArrayList<playerVO> resultlist = new ArrayList<playerVO>();

		int num = ran.nextInt(pitList.size());
		playerVO vo = pitList.get(num);
		resultlist.add(vo);

		return resultlist;
	}

}
