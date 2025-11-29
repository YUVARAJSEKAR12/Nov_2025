package com.app.testone;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v140.systeminfo.SystemInfo;

public class PractiseProgram {
	
	    public static void main(String[] args) {
//	        String input = "AIITE Academy is Great";
//	        String[] words = input.split(" ");
//	        StringBuilder sb = new StringBuilder();
//
//	        for (int i = words.length - 1; i >= 0; i--) {
//	            sb.append(words[i]).append(" ");
//	        }
//	        System.out.println(sb.toString().trim());
	    	
//	    	String str = "automation";
//	        Map<Character, Integer> map = new LinkedHashMap();
//
//	        for (char c : str.toCharArray()) {
//	            map.put(c, map.getOrDefault(c, 0) + 1);
//	        }
//
//	        for (Map.Entry<Character, Integer> e : map.entrySet()) {
//	            if (e.getValue()==1) {
//	                System.out.println(e.getKey());
//	               break;
//	            }
//	        }
	    
//	    	Integer[] a = {1,2,3,4,5};
//	    	Integer[] b = {3,4,6,7};
//
//	        Set<Integer> set = new HashSet<Integer>();
//	        Set<Integer> result = new HashSet<>();
//	        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(a));
//	        Set<Integer> result1 = new HashSet<>(Arrays.asList(b));
//	        set.retainAll(result1);
//	        System.out.println(set);
//	        for (int i : a) set.add(i);
//	        for (int j : b) if (set.contains(j)) result.add(j);
//	        System.out.println(result); 
	    	
//	    	String s = "automation";
//	        Map<Character, Integer> map = new HashMap();
//
//	        for (char c : s.toCharArray()) {
//	            map.put(c, map.getOrDefault(c, 0) + 1);
//	        }
//
//	       for(Map.Entry<Character, Integer> e : map.entrySet()){
//	    	   if(e.getValue()>1) {
//	    		   System.out.println(e.getKey() +" = "+ e.getValue());
//	    	   }
//	       }
	  //      map.entrySet().stream().filter(e -> e.getValue()>1).forEach(System.out::println);
//	    	
//	    	String s = "a1b2c3"; 
//
////	        // Reverse only letters
//	        LinkedList<Character> reversed = s.chars()
//	                .mapToObj(c -> (char) c)
//	                .filter(Character::isLetter)
//	                .collect(Collectors.toCollection(LinkedList::new));
//	        Collections.reverse(reversed);
//	        System.out.println(reversed);
////
////	        // Rebuild using stream
//	        String result = s.chars()
//	                .mapToObj(c -> (char)c)
//	                .map(ch -> Character.isLetter(ch) ? reversed.removeFirst() : ch)
//	                .map(String::valueOf)
//	                .collect(Collectors.joining());
//
//	        System.out.println(result);
	    	
	    	
//	    	String s1 = "listen";
//	    	String s2 = "silent";
//	    	System.out.println();
//	    	Arrays.sort(s1.toLowerCase().toCharArray());
//	    	Arrays.sort(s2.toLowerCase().toCharArray());
//	    	
//	    	if(s1.equals(s2)) {
//	    		System.out.println("given string is anagram");
//	    	}else {
//	    		System.out.println("not a anagram");
//	    	}
//	    	
//	    	String[] words = {"rat", "tar","art","dog"};
//
//	     
//	                Map<String, List<String>> result = Arrays.stream(words)
//	                        .collect(Collectors.groupingBy(
//	                         w -> {
//	                        	 char[] c = w.toString().toCharArray();
//	                        	 Arrays.sort(c);
//	                        	 return new String(c);
//	                         }));
//	                
//	                        System.out.println(result);
//	    	 int[] arr = {1,2,3,5,6,7};
//	         int n = 7;
//
//	         int sum = n*(n+1)/2;
//	         int arraySum = 0;
//
//	         for (int x : arr) 
//	         arraySum += x;
//
//	         System.out.println("Missing = " + (sum - arraySum));
//	    	
//	    	 String s1 = "Automation testing using Java is powerful";
//	         String[] words = s1.split(" ");
//
//	         String longest = "";
//	         for (String w : words)
//	             if (w.length() > longest.length()) 
//	    		   longest = w;
//
//	         System.out.println(longest);
//	    	
//	    	 int[] arr = {10,20,5,40,40,30};
//
//	         int secondLargest =
//	                 Arrays.stream(arr)
//	                       .boxed()
//	                       .sorted(Comparator.reverseOrder())  // sort descending
//	                       .skip(2)                             // skip largest
//	                       .findFirst()
//	                       .orElse(Integer.MIN_VALUE);
//
//	         System.out.println("Second largest = " + secondLargest);
//	    	
	    	
//	    	 int[] arr = {1,0,2,0,3,0,0};
//	    	//{1,2,3,0,0,0,0}
//
//	         int[] result =
//	                 IntStream.concat(
//	                         Arrays.stream(arr).filter(x -> x != 0),
//	                         Arrays.stream(arr).filter(x -> x == 0)
//	                         
//	                 ).toArray();
//
//	         System.out.println(Arrays.toString(result));
	    	
//	    	int[] arr = {2,7,11,15,7,2,5,4};
//	        int target = 11;
//
//	        Set<Integer> seen = new HashSet<>();
//	        Set<String> printed = new HashSet<>();
//
//	        for (int x : arr) {
//	            int diff = target - x;
//
//	            if (seen.contains(diff)) {
//
//	                // always store smaller-first to avoid duplicates
//	                int a = Math.min(x, diff);
//	                int b = Math.max(x, diff);
//
//	                String key = a + "-" +b;
//
//	                if (!printed.contains(key)) {
//	                    System.out.println(a + ", " + b);
//	                    printed.add(key);
//	                }
//	            }
//	            seen.add(x);
//	        }
	    	
	    	String s1 = "AiiTE@2025!! Students##";
	        String cleaned = s1.replaceAll("[^A-Z0-9 ]", "");
	        System.out.println(cleaned);
	    	
//	    	Stream.of("chrome", "edge", "firefox").parallel().forEach(browser -> {
//	    	    WebDriver driver = BrowserFactory.getDriver(browser);
//	    	    driver.get("https://google.com");
//	    	    driver.quit();
//	    	});
	    	
//	    	Integer[] a = {1,2,3,4,5};
//	    	Integer[] b = {3,4,6,7};
//
//	        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(a));
//	        Set<Integer> result = new HashSet<>(Arrays.asList(b));
//	        set.retainAll(result);
//	        System.out.println(set);
	    	
//	    	String s = "automation java";
//	        Map<Character, Integer> map = new HashMap<>();
//
//	        for (char c : s.toCharArray()) {
//	            map.put(c, map.getOrDefault(c, 0) + 1);
//	        }
//
//	        map.entrySet().stream()
//	            .filter(e -> e.getValue() > 1)
//	            .forEach(System.out::println);
	        
	    }  
	        
}   


