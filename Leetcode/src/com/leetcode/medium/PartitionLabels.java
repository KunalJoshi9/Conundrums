package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionLabels {
	 public class Bound implements Comparable<Bound> {
	        public int lower;
	        public int upper;
	        public Bound(int lower, int upper){
	            this.lower=lower;
	            this.upper=upper;
	        }
	        
	        @Override
	        public int compareTo(Bound b){
	            return this.lower-b.lower;
	        }
	    }
	    
	    public List<Integer> partitionLabels(String S) {
	        List<Integer> result = new ArrayList<Integer>();
	        Bound[] bounds = new Bound[26];
	        for(int i=0;i<S.length();i++){
	            char c = S.charAt(i);
	            int pos = c - 'a';
	            if(bounds[pos]==null){
	                Bound b = new Bound(i,i);
	                bounds[pos]=b;
	            }else{
	                Bound b = bounds[pos];
	                b.upper = i;
	            }
	        }
	        List<Bound> boundsList = new ArrayList<Bound>();
	        for(int i=0;i<bounds.length;i++){
	            if(bounds[i]!=null){
	                boundsList.add(bounds[i]);
	            }
	        }
	        Collections.sort(boundsList);
	        int st = boundsList.get(0).lower;
	        int ed = boundsList.get(0).upper;
	        for(int i=1;i<boundsList.size();i++){
	            int l = boundsList.get(i).lower;
	            int u = boundsList.get(i).upper;
	            if(l>ed){
	               int range = ed-st+1;
	                result.add(range);
	                st=l;
	                ed=u;
	                continue;
	            }
	            if(l<st){
	                st = l;
	            }
	            if(u>ed){
	                ed = u;
	            }
	        }
	        result.add(ed-st+1);
	        return result;
	    }
	    
	    /* Shorter Version */
	    public List<Integer> partitionLabelsShort(String S) {
	        int[] last = new int[26];
	        for (int i = 0; i < S.length(); ++i)
	            last[S.charAt(i) - 'a'] = i;
	        
	        int st = 0,ed = 0;
	        List<Integer> ans = new ArrayList<>();
	        for (int i = 0; i < S.length(); ++i) {
	            ed = Math.max(ed, last[S.charAt(i) - 'a']);
	            if (i == ed) {// When we are at the end of a partition
	                ans.add(i - st + 1);
	                st = i + 1;
	            }
	        }
	        return ans;
	    }
}
