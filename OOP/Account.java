
/**
 * �ϻ��Ȱ�� ��ü�� �߻�ȭ�ϱ� ���� �𵨸� Ŭ���� ���� 
 * e.g.������� ��ü 
 * c.f.���ø����̼� Ŭ����(�׽�Ʈ�� �ϱ� ���� main �޼ҵ�_��Ʈ������Ʈ�� ������ �ִ� Ŭ����)
 */
public class Account { //class�� public �̰ų� default�̰ų� �� �����ۿ� ���� 
	
	// static �ʱ�ȭ ����(Ư���� ������ ���ɾ� ����) 
	static{
		System.out.println("�ʱ�ȭ ���� �����Դϴ�.1");
		System.out.println("�ʱ�ȭ ���� �����Դϴ�.2");
	}


	// Ŭ����(static) ���� 
	public static final String BANKNAME = "�ϳ�����"; 

	
	
	// �ν��Ͻ� ���� ���� 
	private String accountNum; 
	private String accountOwner; 
	private int passwd; 
	private long restMoney; 

	// ������
	public Account(){
		this(null, null);
	}

	public Account(String accountNum, String accountOwner){
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;  
		this(accountNum, accountOwner, 0, 0);
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner; 
		this.passwd = passwd; 
		this.restMoney = restMoney; 
	}

	// setter/getter �޼ҵ� 
	public void setAccountNum(String accountNum){
		this.accountNum = accountNum; 
	}

	public String getAccountNum(){
		return accountNum; 
	}
	
	public void setAccountOwner(String accountOwner){
		this.accountOwner = accountOwner;
	}

	public String getAccountOwner(){
		return accountOwner; 
	}

	public void setPasswd(int passwd){
		this.passwd = passwd;
	}

	public int getPasswd(){
		return passwd; 
	}

	public void setRestMoney(long restMoney){
		this.restMoney = restMoney; 
	}



	// �ν��Ͻ� �޼ҵ�  
	public long deposit(long money){
		restMoney += money;
		return restMoney; 
	}

	public long withdraw(long money){
		restMoney -= money; 
		return restMoney; 
	}

	public long getRestMoney(){
		return restMoney;
	}

	public boolean checkPasswd(int passwd){
		return (this.passwd == passwd);
	}
	

	// Ŭ����(static) �޼ҵ� 
	public static int sum(int a, int b){
		return a + b; 
	}



}