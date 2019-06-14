package com.medium.advantageShuffle;

import java.util.*;

/**
 * @author chenlangping
 * @date 2019-06-14
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {28, 47, 45, 8, 2, 10, 25, 35, 43, 37, 33, 30, 33, 20, 33, 42, 43, 36, 34, 3, 16, 23, 15, 10, 19, 42, 13, 47, 0, 21, 36, 38, 0, 5, 3, 28, 4, 20, 14, 5, 19, 22, 29, 17, 3, 16, 35, 0, 26, 0};
        int[] B = {144, 10, 27, 4, 27, 40, 46, 40, 45, 0, 41, 2, 44, 50, 36, 30, 37, 4, 44, 4, 12, 13, 35, 20, 19, 25, 38, 42, 43, 14, 2, 4, 5, 38, 4, 38, 0, 35, 12, 32, 38, 33, 3, 1, 19, 46, 23, 13, 24, 41};
        System.out.println(Arrays.toString(solution.advantageCount(A, B)));
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        int[] sortedB = B.clone();
        Arrays.sort(sortedA);
        Arrays.sort(sortedB);

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<Integer> remain = new ArrayList<>();

        int i = 0;
        for (int j = 0; j < sortedB.length && i < sortedA.length; i++) {
            if (sortedB[j] < sortedA[i]) {
                if (map.containsKey(sortedB[j])) {
                    map.get(sortedB[j]).add(sortedA[i]);
                } else {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(sortedA[i]);
                    map.put(sortedB[j], tmp);
                }
                j++;
            } else {
                remain.add(sortedA[i]);
            }
        }

        int[] res = new int[sortedA.length];

        for (int k = 0; k < sortedB.length; k++) {
            if (map.containsKey(B[k]) && map.get(B[k]).size() > 0) {
                res[k] = map.get(B[k]).get(0);
                map.get(B[k]).remove(0);
            } else {
                res[k] = remain.get(0);
                remain.remove(0);
            }
        }

        return res;
    }
}
