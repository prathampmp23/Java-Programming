package com.cts.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashmapCodes {

	public static void main(String[] args) {
//		No duplicate key but duplicate values 
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "RAM");
		map.put(1, "Pratham");
		map.put(2, "Suhas");
		map.put(3, "Aman");
//		map.put(null, null);
//		map.put(4, null);
//		map.put(null, "ee");
		
		System.out.println(map);
		
//		Entry - > Inner interface inside Map interface class
		for(Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
			
//			Using iterator 
			Set<Integer> set = map.keySet();
			Iterator<Integer> itr = set.iterator();
			while(itr.hasNext()) {
				int key = itr.next();
				String value = map.get(key);
				System.out.println(key + " " + value);
			}
		}
	}

}
