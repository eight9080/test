package com.example.alg.graphpck;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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


    /**
     * There are a total of n courses you have to take, labeled from 0 to n - 1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

     There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

     For example:

     2, [[1,0]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

     4, [[1,0],[2,0],[3,1],[3,2]]
     There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites==null){
            return new int[]{};
        }
        if(numCourses==0 && prerequisites.length==0){
            return new int[]{};
        }

        if(prerequisites.length==0){
            return IntStream.range(0, numCourses).toArray();
        }

        //no prerequisites of each course
        int[] preCounter = new int[numCourses];
        for(int i = 0; i< prerequisites.length; i++){
            preCounter[prerequisites[i][0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i<numCourses; i++){
            if(preCounter[i]==0){
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int indexResult = 0;

        int numNoPre = queue.size();

        while ((!queue.isEmpty())){
            final Integer coursePreReq = queue.remove();
            result[indexResult++]=coursePreReq;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == coursePreReq) {
                    final int course = prerequisite[0];
                    preCounter[course]--;
                    if (preCounter[course] == 0) {
                        queue.add(course);
                        numNoPre++;
                    }
                }
            }

        }

        if(numNoPre==numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}
