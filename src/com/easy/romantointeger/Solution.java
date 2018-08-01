package com.easy.romantointeger;

/**
 * 思路：首先判断是不是4 9 这类的特定组合；不是就可以直接加；
 * 需要注意b是否越界的问题
 */

public class Solution {
    public int romanToInt(String s) {
        int length = s.length();
        int sum = 0;
        for(int i = 0;i<length;i++){
            char a = s.charAt(i);
            if(i<length-1){
                char b = s.charAt(i+1);
                if (a=='I'&&b=='V'){
                    sum+=4;
                    i++;
                    continue;
                }else if (a=='I'&&b=='X'){
                    sum+=9;
                    i++;
                    continue;
                }else if (a=='X'&&b=='L'){
                    sum+=40;
                    i++;
                    continue;
                }else if (a=='X'&&b=='C'){
                    sum+=90;
                    i++;
                    continue;
                }else if (a=='C'&&b=='D'){
                    sum+=400;
                    i++;
                    continue;
                }else if (a=='C'&&b=='M'){
                    sum+=900;
                    i++;
                    continue;
                }
            }

            if (a=='I'){
                sum+=1;
            }
            if (a=='V'){
                sum+=5;
            }
            if (a=='X'){
                sum+=10;
            }
            if (a=='L'){
                sum+=50;
            }
            if (a=='C'){
                sum+=100;
            }
            if (a=='D'){
                sum+=500;
            }
            if (a=='M'){
                sum+=1000;
            }
        }

        return sum;
    }

    /*
    public static void main(String args[]){
        Solution solution = new Solution();
        //String s = "LVIII";
        //String s = "III";
        //String s = "IV";
        //String s = "IX";
        //String s = "MCMXCIV";
        int result = solution.romanToInt(s);
        System.out.print(result);
    }

    */
}
