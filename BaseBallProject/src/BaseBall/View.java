package BaseBall;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		jdbcDao dao = new jdbcDao();

		// 1.�α���, ȸ������, ����
		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] �α��� [2] ȸ������ [3] ���� >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("===�α���===");
				System.out.print("ID�Է�: ");
				String id = sc.next();
				System.out.print("PW�Է�: ");
				String pw = sc.next();

				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);

				if (info != null) {
					System.out.println("�α��� ���� :-) ");

					System.out.print("[1] �����̱� [2] ���ӽ��� >> "); // ����� ������ �а� ��ư ����
					int dom = sc.nextInt();

					if (dom == 1) { // �α��� �� "���� �̱�" ��ư���� ���� 5�� Ÿ�� ���� �ҷ�����(�̸�, �ɷ�ġ)
									// ��ư �ٽ� ����ؼ� ���� ����!
						ArrayList<playerVO> mm = new ArrayList<>();
						
					}

					System.out.print("[1] �����̱� [2] ���ӽ��� >> "); // ����� ������ �а� ��ư ����
					int dom2 = sc.nextInt();

					if (dom2 == 2) { // ���� ��� �����ֱ� - ������ �߿� ���� ���� �����ϱ� - ���� ����
						System.out.println("===���ӽ���===");
						
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
		// 4. ���� �߰� ���

	}

}
