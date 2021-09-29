package BaseBall;

import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		jdbcDao dao = new jdbcDao();

		Scanner sc = new Scanner(System.in);
		// 1.로그인, 회원가입, 종료
		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] 로그인 [2] 회원가입 [3] 종료");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("===로그인===");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.println("PW입력: ");
				String pw = sc.next();
				
				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);
				
				if(info != null) {
					System.out.println("로그인 성공 :-) ");
				}else {
					System.out.println("로그인 실패 :-) ");
				}
				
			
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
			}else if(choice == 3) {
				System.out.println("프로그램을 종료합니다 ^3^");
				sc.close();
				toggle = false;
				break;
			}
		}

		// 2. 로그인이 될 때 선수 랜덤, 게임시작
		// 3. 게임플레이 및 결과
		// 4. 선수 추가 등록

	}

}
