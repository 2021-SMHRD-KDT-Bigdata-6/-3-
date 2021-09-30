package BaseBall;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		jdbcDao dao = new jdbcDao();

		
		int Strike = 0;
		int Hit = 1;
		int Home = 2; 
		int count = 0; // 연승횟수.
		
		// 1.로그인, 회원가입, 종료 [메인]
		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] 로그인 [2] 회원가입 [3] 종료 >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("===로그인===");
				System.out.print("ID입력: ");
				String id = sc.next();
				System.out.print("PW입력: ");
				String pw = sc.next();

				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);

				if (info != null) {
					System.out.println("로그인 성공 :-) ");
					break;
					
				}else {
					System.out.println("로그인 실패 :-<");
				}
			}else if(choice==2){
			
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
			}
			else if(choice==3){
				
					System.out.println("프로그램을 종료합니다 ^3^");
					sc.close();
					toggle = false;
					break;
				}
			
			
		}
					
		
					while (toggle)	{
					System.out.print("[1] 선수뽑기 [2] 게임시작 >> "); // 저장된 정보를 읽고 버튼 구성
					int dom = sc.nextInt();

					if (dom == 1) { // 로그인 후 "선수 뽑기" 버튼으로 랜덤 5명 타자 정보 불러오기(이름, 능력치)

									// 버튼 다시 출력해서 게임 시작!
						ArrayList<playerVO> mm = new ArrayList<>(); //ig_102 완료
						
					}
					//사용자의 뽑기 횟수 출력
					int choose = 0;
					System.out.print("=== 뽑기 횟수 : " + choose); 
					
					
					System.out.print("[1] 선수뽑기 [2] 게임시작 >> "); // 저장된 정보를 읽고 버튼 구성
					int dom2 = sc.nextInt();

					//사용자의 뽑기 횟수가 0일 경우 선수 못뽑게!
//					if(choose ==0&&dom2==1) {
//						
//					}
					
					
					
					
					if (dom2 == 2) { // 선수 목록 보여주기 - 선수들 중에 투수 랜덤 선택하기 - 게임 시작
						System.out.println("===게임시작===");
									// 버튼 다시 출력해서 게임 시작! //IG_100,101 =>DAO.SELECT
						// ig_102 결과 가져오기 (선수 목록)
						
						// 선택하고 사용자가 뽑은 선수 출력.
						int listIndex = sc.nextInt();
						
						if(listIndex==1) {
							//list.getName(0)? 뭔진몰라
							//list.getName(0)? 뭔진몰라
						}else if(listIndex==2) {
							//list.getName(1)? 뭔진몰라
							//list.getName(1)? 뭔진몰라
						}else if(listIndex==3) {
							//list.getName(2)? 뭔진몰라
							//list.getName(2)? 뭔진몰라
						}else if(listIndex==4) {
							//list.getName(3)? 뭔진몰라
							//list.getName(3)? 뭔진몰라
						}else if(listIndex==5) {
							//list.getName(4)? 뭔진몰라
							//list.getName(4)? 뭔진몰라
						}
						
						//상대 투수 랜덤으로 1명 불러오기
						//ig_103 select2
						
 						
						//게임 -----ig_ 104 정현
						while(true) {
							if(Strike < 4 ) { // 스트라이크가 3회 미만이면 " 선수선택" 페이지
								
							}else if() { // 타자 - 투수가 10 이하면 스트라이트 1번
								
							}else if() { // 타자 - 투수가 50 이하면 안타 1점
								
							}else if() { // 타자 - 투수가 50 초과면 홈런 2점
								
							}else if() { // 스코어가 10초과면 승리
								
								break;
							}
						}
						
						count++; // 연승횟수, 2승이어도 문답 출력, 2승이면 승
						 System.out.println(count+"연승.");
					     System.out.println("[1] 경기 계속, [2] 종료 >> ");
					     int answer = sc.nextInt();
					    
					     if(answer==2) {
					   
					     break;
					     }
					     
					}
					     

				    	
					    // 게임 결과
						// 내주세요!~ 누적~ 
					    	
						
						
						

					
					
					
					
					
					
					
					
					
					//회의 참고할꺼

	// 3. 게임플레이 및 결과
	// -> 게임시작누르고 타자 선택
	// IG_102 선수선택
	// System.out.println("===vs===");
	// IG_103 상대 투수 랜덤추출
	// slect2();

	// while(스트라이크 3회 미만 or 점수 10점 미만) {
	// IG_104 호출
	// [ IG_104 안에 (타자-투수) 계산 -> 결과에 따라 return 0,1,2를 해서 사용자 점수 누적 (비교!)]
	// 스트라이크 회수 세기
	// RETURN 값 점수에 받기 }

	// 승리해서 WHILE문 탈출하면 -> 승수 카운트++;
	// 카운트 2 에 도달하면 ( 선수 뽑기 1회씩 증가 (누적) + 카운트 다시 0으로 )
	// 뽑기 횟수 0일 경우 못하게만들기

	// 선수 다시 추출 IG_105

	// 게임반복?

	//

	//

	// 4. 선수 추가 등록


}
	}
}
