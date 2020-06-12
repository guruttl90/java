package com.java.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CollectionTest {
	
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();		
		hm.put("one", "Value1");
		hm.put("five", "Value5");
		List<String> al = new ArrayList<String>(hm.keySet());
		Collections.sort(al);
		for(String s: al) {
			System.out.println("\n"+hm.get(s));
		}
	}

}
