package BaseBall;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		jdbcDao dao = new jdbcDao();

		// 1.�α���, ȸ������, ���� [����]
		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] �α��� [2] ȸ������ [3] ���� >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("===�α���===");
				System.out.print("ID�Է�: ");
				String id = sc.next();
				System.out.println("PW�Է�: ");
				String pw = sc.next();

				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);

				if (info != null) {
					System.out.println("�α��� ���� :-) ");

					System.out.println("[1] �����̱� [2] ���ӽ��� >> "); // ����� ������ �а� ��ư ����
					int dom = sc.nextInt(); 

					if (dom == 1) { // �α��� �� "���� �̱�" ��ư���� ���� 5�� Ÿ�� ���� �ҷ�����(�̸�, �ɷ�ġ)
									// ��ư �ٽ� ����ؼ� ���� ����! //IG_100,101 =>DAO.SELECT

						ArrayList<playerVO> list = new ArrayList<>();

						// playerVO vo2 = new playerVO(name, capa, position);

						list = dao.select();
						int index = ran.nextInt();

						for (int i = 0; i < 5; i++) {
							ArrayList<playerVO> list2 = new ArrayList<>();
							list2.add(list.get(index));
						}
						//1 �ٽ� �����̱�� ���ư�����
						
					}

				} else {
					System.out.println("�α��� ���� :-) ");
				}
				// 2. �α��μ���-> ���� �̱�, ���ӽ��� ��ư ����
			} else if (choice == 2) {
				System.out.println("===ȸ������===");
				System.out.print("ID�Է�: ");
				String id = sc.next();
				System.out.print("PW�Է�: ");
				String pw = sc.next();

				userVO vo = new userVO(id, pw);
				int cnt = dao.register(vo);

				if (cnt > 0) {
					System.out.println("ȸ������ ����^_^");
				} else {
					System.out.println("ȸ������ ����^_^");
				}
			} else if (choice == 3) {
				System.out.println("���α׷��� �����մϴ� ^3^");
				sc.close();
				toggle = false;
				break;
			}
		}

		// 3. �����÷��� �� ���
		//-> ���ӽ��۴����� Ÿ�� ����
		//IG_102 ��������
		//System.out.println("===vs===");
		// IG_103 ��� ���� ��������
		//slect2();
		
		
		// while(��Ʈ����ũ 3ȸ �̸� or ���� 10�� �̸�) {
		//IG_104 ȣ��
		//	[ IG_104 �ȿ� (Ÿ��-����) ��� -> ����� ���� return 0,1,2�� �ؼ� ����� ���� ���� (��!)] 
		// 	��Ʈ����ũ ȸ�� ����
		// 	RETURN �� ������ �ޱ� }
		
		// �¸��ؼ� WHILE�� Ż���ϸ� -> �¼� ī��Ʈ++; 
		// ī��Ʈ 2�� �����ϸ� ( ���� �̱� 1ȸ�� ���� (����) + ī��Ʈ �ٽ� 0���� )
		
		// ���� �ٽ� ���� IG_105
		
		//���ӹݺ�?
		
		
		
		//
		
		
		
		
		
		//
		
		
		
		// 4. ���� �߰� ���

	}

}
