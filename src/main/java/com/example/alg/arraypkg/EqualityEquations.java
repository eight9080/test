package com.example.alg.arraypkg;


import java.util.*;

/**
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b". Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
 * <p>
 * Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
 * Example 2:
 * <p>
 * Input: ["b==a","a==b"]
 * Output: true
 * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
 * Example 3:
 * <p>
 * Input: ["a==b","b==c","a==c"]
 * Output: true
 * Example 4:
 * <p>
 * Input: ["a==b","b!=c","c==a"]
 * Output: false
 * Example 5:
 * <p>
 * Input: ["c==c","b==d","x!=z"]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] and equations[i][3] are lowercase letters
 * equations[i][1] is either '=' or '!'
 * equations[i][2] is '='
 */
public class EqualityEquations {

    boolean equationsPossible(String[] equations) {

        UnionFind u1 = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                u1.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int g1 = u1.find(equation.charAt(0) - 'a');
                int g2 = u1.find(equation.charAt(3) - 'a');
                if (g1 == g2) {
                    return false;
                }
            }
        }

        return true;
    }
}

class UnionFind{
    private int[] parents;
    private int circles;

    UnionFind(int n){
        parents = new int[n]; // create parent for each node
        for(int i=0; i<n; i++){
            parents[i] = i; // mark parent of each node as node itself
        }
        circles = n;
    }

    public int find(int x){
        if(parents[x] == x){
            return x;
        }
        // recur to find parent of this node
        return find(parents[x]);
    }

    void union(int a, int b){
        int groupA = find(a);
        int groupB = find(b);

        if(groupA != groupB){
            parents[groupA] = groupB; // connect as we want to put them in the same circle
            circles--; // decrease the group count or the circle count
        }
    }
}
