package exercise.chapter15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Q09 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
//		Set<Map.Entry<String, Integer>> sm = map.entrySet();
//		for(Map.Entry<String, Integer> m:sm) {
//			if(maxScore<m.getValue()) {
//				name = m.getKey();
//				maxScore = m.getValue();
//			}
//			totalScore += m.getValue();
//		}
		
		Set<Map.Entry<String, Integer>> sm = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = sm.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			if(maxScore<entry.getValue()) {
				maxScore = entry.getValue();
				name = entry.getKey();
			}
			totalScore+=entry.getValue();
		}
		
		
		
		System.out.printf("평균점수: %d\n", totalScore/map.size());
		System.out.printf("최고점수: %d\n", maxScore);
		System.out.printf("최고점수를 받은 아이디: %s\n", name);

	}

}
