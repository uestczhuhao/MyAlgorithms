package LeetCode;

/**
 * Created by zhuhao on 17-5-18.
 *
 * There are N gas stations along a circular route,
 * where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and
 * it costscost[i]of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel
 * around the circuit once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 */
public class CanCompleteCircuit {
    /**
     * 从A到C如果达到不了，则从A和C中间的任何一个点出发，都到达不了C
     * 从A到C的储油量大于等于消耗量，则可以到达
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum=0,costSum=0;
        for(int i=0;i<gas.length;i++)
            gasSum+=gas[i];
        for(int i=0;i<cost.length;i++)
            costSum+=cost[i];
        if(gasSum < costSum)
            return -1;
        if(gas.length==1){
            if (gas[0] >= cost[0])
                return 0;
            else return -1;
        }
        if (gas.length == 2) {
            if (gas[0] < cost[0])
                return 1;
            else return 0;
        }

        int N=gas.length;
        int i=0;
        while (i < N){
            int j=i+1;
            gasSum=0;
            costSum=0;
            while (j != i ){

                if (j != 0){
                    gasSum += gas[j-1];
                    costSum += cost[j-1];
                } else {
                    gasSum += gas[N-1];
                    costSum += cost[N-1];
                }
                if (gasSum<costSum) break;
                j++;
                if(j == N) j=0;
            }
//            j--;
//            if (i==1) {
//                System.out.println (gasSum+" "+costSum);
//            }
//            System.out.println ("i = " + i);
//            System.out.println ("j = " + j);
            if (i == j) return j;
            if (i > j) break;
            i=j;
        }

        return -1;
    }
}
