package BaseBall;

import java.util.ArrayList;
import java.util.Random;

public class playControl {
	jdbcDao dao = new jdbcDao();
	Random ran = new Random();
	
	//로직
	//0) 회원가입 로그인을 dao에서 했네
	//1. 선수 추출 IG_102 //진행중
	//2. 사용자 점수 변경 (IG_104) //정현
	//3. 선수 추가 추출 (IG_105) //정현
	
	//1-1)선수 뽑기 DB에 저장된 타자 5명을 랜덤으로 추출.
	//dao에 있음
	//ig_100 ,103,105
	
	//1-2)상대 타자 랜덤 추출 ig_103
	//a) dao에서 select로 받아오게되면? 타자가 다 오게되니까 배열에 담아.
	//b) usercontrol에서 dao에서 담은배열에서 랜덤으로 한개를 추출한 데이터를 리턴으로 보내.
	
	
	
	//	select * from bbplayer where pl_name = ? and pl_position = ? and pl_capa = ? and rownum <= 5 and pl_position = '타자' order by DBMS_random.value
	
	public ArrayList<playerVO> select2() {
		ArrayList<playerVO> list = dao.select2();
		ArrayList<playerVO> resultlist = new ArrayList<playerVO>();		
		
		int num = ran.nextInt(list.size());
		playerVO vo = list.get(num);
		resultlist.add(vo);
		
		return resultlist;
	}
	
	
	
}	
