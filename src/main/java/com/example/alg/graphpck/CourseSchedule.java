package com.example.alg.graphpck;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule {
    /**
     * Detect Cycle graph
     * There are a total of n courses you have to take, labeled from 0 to n - 1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

     For example:

     2, [[1,0]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

     2, [[1,0],[0,1]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

         if(prerequisites==null){
             return false;
         }
         if(numCourses==0 && prerequisites.length==0){
             return true;
         }

         int[] completed = new int[numCourses];


         //map course -> list waiting to be finish
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int[] a: prerequisites){
            if(map.containsKey(a[1])){
                map.get(a[1]).add(a[0]);
            }else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(a[0]);
                map.put(a[1], l);
            }
        }

        for(int i=0; i<numCourses; i++){
            if(!canFinishDFS(map, completed, i))
                return false;
        }

        return true;

    }

    private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] completed, int i) {
        if(completed[i]==-1)
            return false;
        if(completed[i]==1)
            return true;

        completed[i]=-1;

        if(map.containsKey(i)){
            final ArrayList<Integer> courses = map.get(i);
            for(int j : courses){
                if(!canFinishDFS(map, completed, j)){
                    return false;
                }
            }
        }


        completed[i]=1;
        return true;
    }
}
