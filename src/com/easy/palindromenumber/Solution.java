package com.easy.palindromenumber;

public class Solution {
    public boolean isPalindrome(int x) {
        try{
            if(x==0){
                return true;
            }else if(x<0){
                return false;
            }else {
                String num = String.valueOf(x);
                String mnum = new StringBuffer(num).reverse().toString();
                if (num.equals(mnum)){
                    return true;
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            return false;
        }

    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int x = 10;
        System.out.print(solution.isPalindrome(x));
    }
}
