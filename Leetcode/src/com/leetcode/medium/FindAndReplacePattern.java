package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
	 public List<String> findAndReplacePattern(String[] words, String pattern) {
	        List<String> result = new ArrayList<String>();
	        if(pattern==null || pattern.length()==0) return result;
	        
	        int plen = pattern.length();
	        char[] pchars = pattern.toCharArray();
	       
	        for(String word : words){
	            Map<Character,Character> pattChars = new HashMap<Character,Character>();
	            Map<Character,Character> revChars = new HashMap<Character,Character>();
	            int wlen = word.length();
	            if(plen==wlen){
	                int i=0;
	                for(;i<pchars.length;i++){
	                    Character pchar = pchars[i];
	                    Character wchar = word.charAt(i);
	                    if(revChars.containsKey(wchar)){
	                        if(revChars.get(wchar) != pchar){
	                            break;
	                        }
	                    }
	                    if(pattChars.containsKey(pchar)){
	                        Character mchar = pattChars.get(pchar);
	                        if(mchar!=wchar){
	                            break;
	                        }
	                    }
	                    else{
	                        pattChars.put(pchar,wchar);
	                        revChars.put(wchar, pchar);
	                    }
	                }
	                if(i==pchars.length)
	                result.add(word);
	            }
	        }
	        return result;
	    }
}
