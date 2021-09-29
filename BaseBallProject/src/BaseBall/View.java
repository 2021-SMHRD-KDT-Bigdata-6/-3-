package BaseBall;

import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		jdbcDao dao = new jdbcDao();

		Scanner sc = new Scanner(System.in);
		// 1.�α���, ȸ������, ����
		boolean toggle = true;
		while (toggle) {
			System.out.print("[1] �α��� [2] ȸ������ [3] ����");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("===�α���===");
				System.out.print("ID�Է�: ");
				String id = sc.next();
				System.out.println("PW�Է�: ");
				String pw = sc.next();
				
				userVO vo = new userVO(id, pw);
				userVO info = dao.login(vo);
				
				if(info != null) {
					System.out.println("�α��� ���� :-) ");
				}else {
					System.out.println("�α��� ���� :-) ");
				}
				
			
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
			}else if(choice == 3) {
				System.out.println("���α׷��� �����մϴ� ^3^");
				sc.close();
				toggle = false;
				break;
			}
		}

		// 2. �α����� �� �� ���� ����, ���ӽ���
		// 3. �����÷��� �� ���
		// 4. ���� �߰� ���

	}

}
