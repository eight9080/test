package com.example.alg.arraypkg;

public class GasStation {


    /**
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

     You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
     from station i to its next station (i+1). You begin the journey
     with an empty tank at one of the gas stations.

     Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

     To solve this problem, we need to understand and use the following 2 facts:
     1) if the sum of gas >= the sum of cost, then the circle can be completed.
     2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.

     Proof of fact 2:

     If gas[A] < cost[A], then A can not even reach B.
     So to reach C from A, gas[A] must >= cost[A].
     Given that A can not reach C, we have gas[A] + gas[B] < cost[A] + cost[B],
     and gas[A] >= cost[A],
     Therefore, gas[B] < cost[B], i.e., B can not reach C.

     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int leftOver = gas[i]-cost[i];

            if(tank>=0){
                tank+=leftOver;
            }else{
                tank = leftOver;
                start = i;
            }
            total+=leftOver;
        }

        if (total >= 0) {
            return start;
        }

        return -1;
    }
}
