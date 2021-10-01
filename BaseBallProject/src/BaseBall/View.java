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

		// 1.�α���, ȸ������, ���� [����]
		System.out.println(" ====== ����� �߱����� ====== ");

		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] �α��� [2] ȸ������ [3] ���� >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println(" === �α��� === ");
				System.out.print("ID�Է�: ");
				String id = sc.next();
				System.out.print("PW�Է�: ");
				String pw = sc.next();

//				userVO vo = new userVO(id, pw);
				uvo.setId(id);
				uvo.setPw(pw);
				userVO info = dao.login(uvo);

				if (info != null) {
					System.out.println("�α��� ���� :-) ");
					break;

				} else {
					System.out.println("�α��� ���� :-<");
				}
			} else if (choice == 2) {
				System.out.println(" === ȸ������ === ");
				System.out.print("ID�Է�: ");
				String id = sc.next();
				System.out.print("PW�Է�: ");
				String pw = sc.next();
				uvo.setId(id);
				uvo.setPw(pw);
				int cnt = dao.register(uvo);

				if (cnt > 0) {
					System.out.println("= ȸ������ ����^_^ =");

				} else {
					System.out.println("= ȸ������ ����^_^ =");
				}
			} else if (choice == 3) {
				System.out.println("= ���α׷��� �����մϴ� ^3^ =");
				sc.close();
				toggle = false;
				break;
			}
		}
		int choose = 1;
		while (toggle) {
			int ingameStrike = 0;
			int ingameScore = 0;

			System.out.print("[1] �����̱� [2] ���ӽ��� >> "); // ����� ������ �а� ��ư ����
			int dom = sc.nextInt();
			System.out.println();

			System.out.println("==== �̱� Ƚ�� : " + choose + " ====");

//			if (choose == 0) {
//				System.out.println("��ȸ����");
			if (dom == 1) { // �α��� �� "���� �̱�" ��ư���� ���� 5�� Ÿ�� ���� �ҷ�����(�̸�, �ɷ�ġ)
				if (choose == 0) {
					System.out.println("....�̱� Ƚ���� �����ϴ�! T-T");
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
					choose--;// ++ �� �̰����� !!!
					System.out.println();
				}
			}
			else if (dom == 2) { // ���� ��� �����ֱ� - ������ �߿� ���� ���� ��� - ���� ����
				do {
					System.out.println("==== ���ӽ��� ====");

					System.out.println();

					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i).getName() + " ");
						System.out.print(" || ");
						System.out.print(list.get(i).getCapa() + " ");
						System.out.println();
					}
					System.out.println();
					System.out.print("�������� : ");
					int listIndex = sc.nextInt();
					int real = 1;
					System.out.println("[  Ÿ��  ]");
					for (int i = 0; i < list.size(); i++) {
						if (listIndex == i + 1) {
							System.out.print(list.get(i).getName() + " ");
							System.out.print(" || ");
							System.out.println(list.get(i).getCapa());
						}

					}

					// ��� ���� �������� 1�� �ҷ�������
					System.out.println("     VS  ");
					list2 = play.select2();
					System.out.println("[  ����  ]");
					System.out.print(list2.get(0).getName());
					System.out.print(" || ");
					System.out.println(list2.get(0).getCapa());

					int diff = list.get(listIndex - 1).getCapa() - list2.get(0).getCapa();
					if (diff <= 10) {
						System.out.println("!! ��Ʈ����ũ !!");
						ingameStrike++;
					} else if (diff > 10 && diff <= 50) {
						System.out.println("!! ��Ÿ !!");
						ingameScore++;
					} else if (diff >= 50) {
						System.out.println("!! Ȩ�� !!");
						ingameScore += 2;
					}
					System.out.println("***������*** >> " + ingameStrike + "��Ʈ����ũ // " + ingameScore + "�� \n");
				} while (ingameStrike < 3 && ingameScore < 10);

				if (ingameScore >= 10) {
					uvo.setStreakCount(uvo.getStreakCount() + 1);
					System.out.println(uvo.getStreakCount() + "����!!"); // �߰��� �а� �� ��쿡 ���� code �����ϱ�
				} else if (ingameStrike == 3) {
					System.out.println("GAME OUT!!!");
				}

				int l = uvo.getStreakCount();
				if (l % 2 == 0 && l != 0) {
					choose++;
				}

				System.out.println();
				System.out.print("[1] ��� ���, [2] ���� >> ");
				int answer = sc.nextInt();
				if (answer == 1) {
					// �����̱� ������ �ѹ��� �����°ɷ� 105
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
