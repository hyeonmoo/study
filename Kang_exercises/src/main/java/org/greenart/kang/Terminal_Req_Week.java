package org.greenart.kang;

import java.util.Calendar;

public class Terminal_Req_Week {

	public static void main(String[] args) {
		String year = args[0];
		String month = args[1];
		String day = args[2];
		
		int yyyy=Integer.parseInt(year);
		int MM=Integer.parseInt(month);
		int dd=Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy,MM-1,dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char week=" 일월화수목금토".charAt(dayOfWeek);
		
		System.out.printf("%4s년 %2s월 %2s일은 %s요일",year,month,day,week);
	}

}
