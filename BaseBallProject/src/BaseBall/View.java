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
		
		ArrayList<playerVO> list = new ArrayList<playerVO>();
		ArrayList<playerVO> list2 = new ArrayList<playerVO>();
		
		int Strike = 0;
		int Hit = 1;
		int Home = 2;
		int count = 0; // ����Ƚ��.
		
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

				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);

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
				
				userVO vo = new userVO(id, pw);
				int cnt = dao.register(vo);

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
					if( count > 0){
						playerVO vo = play.select3();
						System.out.println(vo.getName() + "  ||  " + vo.getCapa());
					}else {
						list = play.select();
					System.out.println(" ");
					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i).getName()+" ");
						System.out.print(" || ");
						System.out.print(list.get(i).getPosition()+" ");
						System.out.print(" || ");
						System.out.print(list.get(i).getCapa()+" ");
						System.out.println();
						
					}choose--;// ++ �� �̰����� !!!
					System.out.println();
					}
						
					
				} 
				
				
				// ��ư �ٽ� ����ؼ� ���� ����!
			}

			if (dom == 2) { // ���� ��� �����ֱ� - ������ �߿� ���� ���� ��� - ���� ����
				
				System.out.println("==== ���ӽ��� ====");
				// ��ư �ٽ� ����ؼ� ���� ����! //IG_100,101 =>DAO.SELECT
				// ig_102 ��� �������� (���� ���)
				System.out.println();
				for(int i=0; i<list.size(); i++) {
					System.out.print(list.get(i).getName()+" ");
					System.out.print(" || ");
					System.out.print(list.get(i).getCapa()+" ");
					System.out.println();
				}
				System.out.println();
				System.out.print("�������� : ");
				// �����ϰ� ����ڰ� ���� ���� ���.
				int listIndex = sc.nextInt();
				//for�� �߰�
				int real = 1;
				System.out.println("[  Ÿ��  ]");
				for(int i=0; i<list.size(); i++) {
					if (listIndex == i+1) {
						System.out.print(list.get(i).getName()+" ");
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
				
				// ig_103 select2

				// ���� -----ig_ 104 ����
//						while(true) {
//							if(Strike < 4 ) { // ��Ʈ����ũ�� 3ȸ �̸��̸� " ��������" ������
//								
//							}else if() { // Ÿ�� - ������ 10 ���ϸ� ��Ʈ����Ʈ 1��
//								
//							}else if() { // Ÿ�� - ������ 50 ���ϸ� ��Ÿ 1��
//								
//							}else if() { // Ÿ�� - ������ 50 �ʰ��� Ȩ�� 2��
//								
//							}else if() { // ���ھ 10�ʰ��� �¸�
//								
//								break;
//							}
//						}

				count++; // ����Ƚ��, 2���̾ ���� ���, 2���̸� ��
				System.out.println(count + "����.");
				System.out.print("[1] ��� ���, [2] ���� >> ");
				int answer = sc.nextInt();
				if (answer ==1) {
					//�����̱� ������ �ѹ��� �����°ɷ� 105
					choose++;
					count++;
				}
				else if (answer == 2) {
					System.out.println("===== The End =====");
					break;
				}

			}

			// ���� ���
			// ���ּ���!~ ����~

			// ȸ�� �����Ҳ�

			// 3. �����÷��� �� ���
			// -> ���ӽ��۴����� Ÿ�� ����
			// IG_102 ��������
			// System.out.println("===vs===");
			// IG_103 ��� ���� ��������
			// slect2();

			// while(��Ʈ����ũ 3ȸ �̸� or ���� 10�� �̸�) {
			// IG_104 ȣ��
			// [ IG_104 �ȿ� (Ÿ��-����) ��� -> ����� ���� return 0,1,2�� �ؼ� ����� ���� ���� (��!)]
			// ��Ʈ����ũ ȸ�� ����
			// RETURN �� ������ �ޱ� }

			// �¸��ؼ� WHILE�� Ż���ϸ� -> �¼� ī��Ʈ++;
			// ī��Ʈ 2 �� �����ϸ� ( ���� �̱� 1ȸ�� ���� (����) + ī��Ʈ �ٽ� 0���� )
			// �̱� Ƚ�� 0�� ��� ���ϰԸ����

			// ���� �ٽ� ���� IG_105 _count ++;

			// ���ӹݺ�?

			//

			//

			// 4. ���� �߰� ���

		}
	}
}
