/**
 * ���α׷� ������ ���� ���ø����̼� Ŭ���� ���� 
 */

class AccountExample {
	public static void main(String[] args)	{
		System.out.println("������� ���ø����̼� ���۵�");
		// I. ���� ���� �ʱ�ȭ ���� 
		// I-1. Ŭ�����κ��� ��ü(�ν��Ͻ�) ����
		/*
		Account account; 
		account = new Account(); // .class ������ ����Ǿ� �޸𸮿� �ö�(4byte�� �ּҰ� ����)
		*/
		

		// I-2. �ν��Ͻ��� �Ӽ��� ��� ��� 
		/*
		account.accountNum = "1111-2222-3333";
		account.accountOwner = "�����";
		account.restMoney = 100000;
		account.passwd = 1234; 
		*/
		
		// II. ������ �ʱ�ȭ ���ÿ� - ������ Ȱ�� 
		Account account;
		account = new Account("1111-2222-3333", "�����", 100000, 1234); 
		


		// ��й�ȣ üũ 
		int passwd = 1234;
		boolean result = account.checkPasswd(passwd);
		if(result){
			// �Ա� 
			long money = 100000;
			long restMoney = account.deposit(money);
			System.out.println("�Ա� �� �ܾ�: " + restMoney);
			
			// ��� 
			money = 20000;
			restMoney = account.withdraw(money);
			System.out.println("��� �� �ܾ�: " + restMoney);
		}else{
			System.out.println("��й�ȣ�� Ȯ�����ּ���.");
		}
		

		// �� �ٸ� ���� ���� 
		Account account2 = new Account();
		// �ν��Ͻ� ������ ��� JVM�� ���� �ڵ� �ʱ�ȭ��.
		account2.setAccountNum("1111-3333-4444");
		System.out.println(account2.getAccountNum()); 
		System.out.println(account2.getAccountOwner()); //null
		System.out.println(account2.getRestMoney()); //0
		System.out.println(account2.getPasswd()); //0
		

		// ȫ�浿 ���� ����
		Account account3; 
		account3 = new Account("2222-3333-4444","ȫ�浿");
		
		//Account.BANKNAME = "Hana Bank";
		System.out.println(Account.BANKNAME);
		
		System.out.println(Account.sum(30, 20));

		//System.out.println(account.accountNum);
		System.out.println("������� ���ø����̼� �����");
	}
}