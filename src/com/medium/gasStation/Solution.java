package com.medium.gasStation;

/**
 * @author chenlangping
 * @date 2019-05-23
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int[] res = new int[gas.length];
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            res[i] = gas[i] - cost[i];
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }

        int result = 0;
        int curSum = 0;
        for (int i = 0; i < gas.length; i++) {
            if (res[i] == 0) {
                continue;
            }
            if (curSum == 0 && res[i] > 0) {
                curSum = res[i];
                result = i;
            } else if (curSum == 0 && res[i] < 0) {
                result = -1;
            } else if (curSum < 0 && res[i] > 0) {
                curSum = res[i];
                result = i;
            } else if (curSum < 0 && res[i] < 0) {
                curSum = 0;
                result = -1;
            } else if (curSum > 0 && res[i] > 0) {
                curSum += res[i];
            } else {
                if (curSum + res[i] >= 0) {
                    curSum += res[i];
                } else {
                    curSum = 0;
                    result = -1;
                }
            }
        }

        return result;

    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0) {
            return -1;
        }

        int start = 0;
        int accumulate = 0;
        for (int i = 0; i < gas.length; i++) {
            int curGain = gas[i] - cost[i];
            if (accumulate + curGain < 0) {
                start = i + 1;
                accumulate = 0;
            } else {
                accumulate += curGain;
            }
        }

        return start;
    }


}
