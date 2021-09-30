package BaseBall;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		jdbcDao dao = new jdbcDao();
		playControl play = new playControl();

		// 1.로그인, 회원가입, 종료 [메인]
		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] 로그인 [2] 회원가입 [3] 종료 >> ");
			int choice = sc.nextInt();
			System.out.println(play.select2());
			if (choice == 1) {
				System.out.println("===로그인===");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.println("PW입력: ");
				String pw = sc.next();
				

				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);

				if (info != null) {
					System.out.println("로그인 성공 :-) ");

					System.out.println("[1] 선수뽑기 [2] 게임시작 >> "); // 저장된 정보를 읽고 버튼 구성
					int dom = sc.nextInt(); 

					if (dom == 1) { // 로그인 후 "선수 뽑기" 버튼으로 랜덤 5명 타자 정보 불러오기(이름, 능력치)
									// 버튼 다시 출력해서 게임 시작! //IG_100,101 =>DAO.SELECT

						ArrayList<playerVO> list = new ArrayList<>();
						list = play.select2();
						
						System.out.println(list.get(0).getName());
						System.out.println(list.get(0).getPosition());
						System.out.println(list.get(0).getCapa());
						// playerVO vo2 = new playerVO(name, capa, position);

						
						//1 다시 선수뽑기로 돌아가야함
						
					}

				} else {
					System.out.println("로그인 실패 :-) ");
				}
				// 2. 로그인성공-> 선수 뽑기, 게임시작 버튼 구성
			} else if (choice == 2) {
				System.out.println("===회원가입===");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.print("PW입력: ");
				String pw = sc.next();

				userVO vo = new userVO(id, pw);
				int cnt = dao.register(vo);

				if (cnt > 0) {
					System.out.println("회원가입 성공^_^");
				} else {
					System.out.println("회원가입 실패^_^");
				}
			} else if (choice == 3) {
				System.out.println("프로그램을 종료합니다 ^3^");
				sc.close();
				toggle = false;
				break;
			}
		}

		// 3. 게임플레이 및 결과
		//-> 게임시작누르고 타자 선택
		//IG_102 선수선택
		//System.out.println("===vs===");
		// IG_103 상대 투수 랜덤추출
		//slect2();
		
		
		// while(스트라이크 3회 미만 or 점수 10점 미만) {
		//IG_104 호출
		//	[ IG_104 안에 (타자-투수) 계산 -> 결과에 따라 return 0,1,2를 해서 사용자 점수 누적 (비교!)] 
		// 	스트라이크 회수 세기
		// 	RETURN 값 점수에 받기 }
		
		// 승리해서 WHILE문 탈출하면 -> 승수 카운트++; 
		// 카운트 2에 도달하면 ( 선수 뽑기 1회씩 증가 (누적) + 카운트 다시 0으로 )
		
		// 선수 다시 추출 IG_105
		
		//게임반복?
		
		
		
		//
		
		
		
		
		
		//
		
		
		
		// 4. 선수 추가 등록

	}

}
