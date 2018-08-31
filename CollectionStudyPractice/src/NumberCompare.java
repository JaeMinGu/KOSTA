import java.util.Comparator;

public class NumberCompare implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) {
		return Integer.parseInt(o1.getAccountNum())-Integer.parseInt(o2.getAccountNum());
		//양수 o1>o2
		//음수 o1<o2
	}

}
