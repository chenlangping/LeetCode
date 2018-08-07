package com.easy.countAndSay;

public class Solution {
    public String countAndSay(int n) {
        if(n<=0) {
            return "";
        }
        if (n ==1 ) {
            return "1";
        }
        if (n==2) {
            return "11";
        }else {
            //递归实现
            String str = countAndSay(n-1);
            StringBuilder stringBuilder = new StringBuilder();
            char [] a = str.toCharArray();
            int count = 1 ;
            for(int i = 0 ; i < a.length-1;i++){
                if(a[i] == a[i+1] ){
                    count++;
                }else {
                    stringBuilder.append(count).append(a[i]);
                    count = 1;
                }
            }
            stringBuilder.append(count).append(a[a.length -1]);
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(8));
    }
}

