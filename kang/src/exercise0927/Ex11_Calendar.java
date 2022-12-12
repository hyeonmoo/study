package exercise0927;

import java.util.Calendar;

public class Ex11_Calendar {

	public static void main(String[] args) throws Exception{
		int run=0;
		System.out.println("현재시각");
		while(run<60) {
			Calendar cal = Calendar.getInstance();
			
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int week = cal.get(Calendar.DAY_OF_WEEK);
			
			String strWeek=null;
			switch(week) {
			case Calendar.MONDAY: strWeek="월"; break;
			case Calendar.TUESDAY: strWeek="화"; break;
			case Calendar.WEDNESDAY: strWeek="수"; break;
			case Calendar.THURSDAY: strWeek="목"; break;
			case Calendar.FRIDAY: strWeek="금"; break;
			case Calendar.SATURDAY: strWeek="토"; break;
			case Calendar.SUNDAY: strWeek="일"; break;
			}
			
			int hour=cal.get(Calendar.HOUR);
			int minute=cal.get(Calendar.MINUTE);
			int second=cal.get(Calendar.SECOND);
			run++;
			System.out.printf("%4d년 %2d월 %2d일 %s요일 %2d시 %2d분 %2d초\n",year,month,day,strWeek,hour,minute,second);
			Thread.sleep(1000);
		}
	}

}
