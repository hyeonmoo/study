package org.greenart.kang;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HSReq_Week {
	@RequestMapping("/HSR_Week")
	public static void main(HttpServletRequest req) {
		String year = req.getParameter("year");
		String month = req.getParameter("month");
		String date = req.getParameter("date");
		
		int yyyy=Integer.parseInt(year);
		int MM=Integer.parseInt(month);
		int dd=Integer.parseInt(date);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy,MM-1,dd);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char week=" 일월화수목금토".charAt(dayOfWeek);
		
		System.out.printf("%4s년 %2s월 %2s일은 %s요일",year,month,date,week);
	}
}
