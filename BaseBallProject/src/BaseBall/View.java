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
		userVO uvo = new userVO();
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		ArrayList<playerVO> list2 = new ArrayList<playerVO>();

		// 1.로그인, 회원가입, 종료 [메인]
		System.out.println(" ====== 히어로 야구게임 ====== ");

		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] 로그인 [2] 회원가입 [3] 종료 >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println(" === 로그인 === ");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.print("PW입력: ");
				String pw = sc.next();

//				userVO vo = new userVO(id, pw);
				uvo.setId(id);
				uvo.setPw(pw);
				userVO info = dao.login(uvo);

				if (info != null) {
					System.out.println("로그인 성공 :-) ");
					break;

				} else {
					System.out.println("로그인 실패 :-<");
				}
			} else if (choice == 2) {
				System.out.println(" === 회원가입 === ");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.print("PW입력: ");
				String pw = sc.next();
				uvo.setId(id);
				uvo.setPw(pw);
				int cnt = dao.register(uvo);

				if (cnt > 0) {
					System.out.println("= 회원가입 성공^_^ =");

				} else {
					System.out.println("= 회원가입 실패^_^ =");
				}
			} else if (choice == 3) {
				System.out.println("= 프로그램을 종료합니다 ^3^ =");
				sc.close();
				toggle = false;
				break;
			}
		}
		int choose = 1;
		while (toggle) {
			int ingameStrike = 0;
			int ingameScore = 0;

			System.out.print("[1] 선수뽑기 [2] 게임시작 >> "); // 저장된 정보를 읽고 버튼 구성
			int dom = sc.nextInt();
			System.out.println();

			System.out.println("==== 뽑기 횟수 : " + choose + " ====");

//			if (choose == 0) {
//				System.out.println("기회없다");
			if (dom == 1) { // 로그인 후 "선수 뽑기" 버튼으로 랜덤 5명 타자 정보 불러오기(이름, 능력치)
				if (choose == 0) {
					System.out.println("....뽑기 횟수가 없습니다! T-T");
				} else {
					if (uvo.getStreakCount() > 0) {
						playerVO vo = play.select3();
						list.add(vo);
						System.out.println(vo.getName() + "  ||  " + vo.getCapa());
					} else {
						list = play.select();
						System.out.println(" ");
						for (int i = 0; i < list.size(); i++) {
							System.out.print(list.get(i).getName() + " ");
							System.out.print(" || ");
							System.out.print(list.get(i).getPosition() + " ");
							System.out.print(" || ");
							System.out.print(list.get(i).getCapa() + " ");
							System.out.println();
						}
					}
					choose--;// ++ 는 이겼을때 !!!
					System.out.println();
				}
			}
			else if (dom == 2) { // 선수 목록 보여주기 - 선수들 중에 투수 랜덤 출력 - 게임 시작
				do {
					System.out.println("==== 게임시작 ====");

					System.out.println();

					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i).getName() + " ");
						System.out.print(" || ");
						System.out.print(list.get(i).getCapa() + " ");
						System.out.println();
					}
					System.out.println();
					System.out.print("선수선택 : ");
					int listIndex = sc.nextInt();
					int real = 1;
					System.out.println("[  타자  ]");
					for (int i = 0; i < list.size(); i++) {
						if (listIndex == i + 1) {
							System.out.print(list.get(i).getName() + " ");
							System.out.print(" || ");
							System.out.println(list.get(i).getCapa());
						}

					}

					// 상대 투수 랜덤으로 1명 불러오기함
					System.out.println("     VS  ");
					list2 = play.select2();
					System.out.println("[  투수  ]");
					System.out.print(list2.get(0).getName());
					System.out.print(" || ");
					System.out.println(list2.get(0).getCapa());

					int diff = list.get(listIndex - 1).getCapa() - list2.get(0).getCapa();
					if (diff <= 10) {
						System.out.println("!! 스트라이크 !!");
						ingameStrike++;
					} else if (diff > 10 && diff <= 50) {
						System.out.println("!! 안타 !!");
						ingameScore++;
					} else if (diff >= 50) {
						System.out.println("!! 홈런 !!");
						ingameScore += 2;
					}
					System.out.println("***전광판*** >> " + ingameStrike + "스트라이크 // " + ingameScore + "점 \n");
				} while (ingameStrike < 3 && ingameScore < 10);

				if (ingameScore >= 10) {
					uvo.setStreakCount(uvo.getStreakCount() + 1);
					System.out.println(uvo.getStreakCount() + "연승!!"); // 중간에 패가 낄 경우에 대한 code 구현하기
				} else if (ingameStrike == 3) {
					System.out.println("GAME OUT!!!");
				}

				int l = uvo.getStreakCount();
				if (l % 2 == 0 && l != 0) {
					choose++;
				}

				System.out.println();
				System.out.print("[1] 경기 계속, [2] 종료 >> ");
				int answer = sc.nextInt();
				if (answer == 1) {
					// 선수뽑기 로직이 한번만 뽑히는걸로 105
//					choose++;
				} else if (answer == 2) {
					System.out.println("===== The End =====");
					break;
				}
				System.out.println(" =============== ");
			}

		}
	}
}
