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
		int count = 0; // ����Ƚ��.
		
		// 1.�α���, ȸ������, ���� [����]
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
					break;
					
				}else {
					System.out.println("�α��� ���� :-<");
				}
			}else if(choice==2){
			
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
			}
			else if(choice==3){
				
					System.out.println("���α׷��� �����մϴ� ^3^");
					sc.close();
					toggle = false;
					break;
				}
			
			
		}
					
		
					while (toggle)	{
					System.out.print("[1] �����̱� [2] ���ӽ��� >> "); // ����� ������ �а� ��ư ����
					int dom = sc.nextInt();

					if (dom == 1) { // �α��� �� "���� �̱�" ��ư���� ���� 5�� Ÿ�� ���� �ҷ�����(�̸�, �ɷ�ġ)

									// ��ư �ٽ� ����ؼ� ���� ����!
						ArrayList<playerVO> mm = new ArrayList<>(); //ig_102 �Ϸ�
						
					}
					//������� �̱� Ƚ�� ���
					int choose = 0;
					System.out.print("=== �̱� Ƚ�� : " + choose); 
					
					
					System.out.print("[1] �����̱� [2] ���ӽ��� >> "); // ����� ������ �а� ��ư ����
					int dom2 = sc.nextInt();

					//������� �̱� Ƚ���� 0�� ��� ���� ���̰�!
//					if(choose ==0&&dom2==1) {
//						
//					}
					
					
					
					
					if (dom2 == 2) { // ���� ��� �����ֱ� - ������ �߿� ���� ���� �����ϱ� - ���� ����
						System.out.println("===���ӽ���===");
									// ��ư �ٽ� ����ؼ� ���� ����! //IG_100,101 =>DAO.SELECT
						// ig_102 ��� �������� (���� ���)
						
						// �����ϰ� ����ڰ� ���� ���� ���.
						int listIndex = sc.nextInt();
						
						if(listIndex==1) {
							//list.getName(0)? ��������
							//list.getName(0)? ��������
						}else if(listIndex==2) {
							//list.getName(1)? ��������
							//list.getName(1)? ��������
						}else if(listIndex==3) {
							//list.getName(2)? ��������
							//list.getName(2)? ��������
						}else if(listIndex==4) {
							//list.getName(3)? ��������
							//list.getName(3)? ��������
						}else if(listIndex==5) {
							//list.getName(4)? ��������
							//list.getName(4)? ��������
						}
						
						//��� ���� �������� 1�� �ҷ�����
						//ig_103 select2
						
 						
						//���� -----ig_ 104 ����
						while(true) {
							if(Strike < 4 ) { // ��Ʈ����ũ�� 3ȸ �̸��̸� " ��������" ������
								
							}else if() { // Ÿ�� - ������ 10 ���ϸ� ��Ʈ����Ʈ 1��
								
							}else if() { // Ÿ�� - ������ 50 ���ϸ� ��Ÿ 1��
								
							}else if() { // Ÿ�� - ������ 50 �ʰ��� Ȩ�� 2��
								
							}else if() { // ���ھ 10�ʰ��� �¸�
								
								break;
							}
						}
						
						count++; // ����Ƚ��, 2���̾ ���� ���, 2���̸� ��
						 System.out.println(count+"����.");
					     System.out.println("[1] ��� ���, [2] ���� >> ");
					     int answer = sc.nextInt();
					    
					     if(answer==2) {
					   
					     break;
					     }
					     
					}
					     

				    	
					    // ���� ���
						// ���ּ���!~ ����~ 
					    	
						
						
						

					
					
					
					
					
					
					
					
					
					//ȸ�� �����Ҳ�

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

	// ���� �ٽ� ���� IG_105

	// ���ӹݺ�?

	//

	//

	// 4. ���� �߰� ���


}
	}
}
