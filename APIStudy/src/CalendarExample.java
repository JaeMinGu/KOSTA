import java.util.Calendar;

public class CalendarExample {

	// 근무일수 계산 메소드
	public static int getWorks(String year, String month, String date) {
		Calendar cal;
		cal = Calendar.getInstance();

		
		int yearToInt = Integer.parseInt(year);
		int monthToInt = Integer.parseInt(month) - 1;
		int dateToInt = Integer.parseInt(date);

		cal.set(yearToInt, monthToInt, dateToInt);
		long cal2 = cal.getTimeInMillis();

		long cal3 = Calendar.getInstance().getTimeInMillis();

		long workTime = cal3 - cal2;
		System.out.println(workTime);

		return (int) (workTime / (1000 * 60 * 60 * 24));
	}

	public static void main(String[] args) {
//		Calendar today = new Calendar();
//		Calendar today = new GregorianCalendar(); 
//		today = new GregorianCalendar(); 

		Calendar today = Calendar.getInstance(); // facotry method : 내가 직접 생성x, factory에 요청만o
		today = Calendar.getInstance();
		today = Calendar.getInstance();
		today = Calendar.getInstance();
		today = Calendar.getInstance(); // 모두 똑같은 객체, 값만 변경

		today.set(Calendar.YEAR, 1987);

		System.out.println(today);

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DATE);
		int day = today.get(Calendar.DAY_OF_WEEK);

		System.out.println(year);
		System.out.println(month + 1);
		System.out.println(date);

		System.out.println(year + "-" + (month + 1) + "-" + date);

		System.out.println(day);
		switch (day) {
		case Calendar.SUNDAY:
			System.out.println("일요일");
			break;
		case Calendar.MONDAY:
			System.out.println("월요일");
			break;
		case Calendar.TUESDAY:
			System.out.println("화요일");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("수요일");
			break;
		case Calendar.THURSDAY:
			System.out.println("목요일");
			break;
		case Calendar.FRIDAY:
			System.out.println("금요일");
			break;
		case Calendar.SATURDAY:
			System.out.println("토요일");
			break;
		}

		// 근무일수 구하기
		int value = getWorks("1987", "3", "1");
		System.out.println(value);

	}

}
