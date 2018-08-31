import java.util.Comparator;

public class NumberCompare implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) { // 앞의 값이 크면 양수, 같으면 =, 뒤의 값이 크면 음수 리턴
		return o2.getAccountNum().compareTo(o1.getAccountNum());
	}
	
	
	

}
