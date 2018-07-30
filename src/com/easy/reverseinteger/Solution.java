package com.easy.reverseinteger;

public class Solution {
    public int reverse(int x) {
        try{
            if(x==0){
                return 0;
            }else if(x<0){
                //如果是负数
                x=(-1)*x;
                String num = String.valueOf(x);
                String mnum = new StringBuffer(num).reverse().toString();
                int result = Integer.parseInt(mnum);
                return (-1)*result;
            }else {
                //排除0和负数，只剩下正数
                String num = String.valueOf(x);
                String mnum = new StringBuffer(num).reverse().toString();
                return Integer.parseInt(mnum);
            }
        }catch (Exception e){
            return 0;
        }

    }

    /*
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 123;
        System.out.println(solution.reverse(x));
    }
    */
}
