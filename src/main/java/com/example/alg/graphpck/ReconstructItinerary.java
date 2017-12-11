package com.example.alg.graphpck;

import java.util.*;

public class ReconstructItinerary {
    /**
     * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

     Note:
     If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     All airports are represented by three capital letters (IATA code).
     You may assume all tickets form at least one valid itinerary.
     Example 1:
     tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
     Example 2:
     tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
     Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
     */

    public List<String> findItinerary(String[][] tickets) {
        if(tickets==null || tickets.length==0)
            return Collections.emptyList();

        Map<String, PriorityQueue<String >> fromToDestiantion = new HashMap<>();

        for(int i=0; i< tickets.length; i++){

            final String from = tickets[i][0];
            final String to = tickets[i][1];

            fromToDestiantion.putIfAbsent(from, new PriorityQueue<>());
            fromToDestiantion.get(from).add(to);

        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", fromToDestiantion, itinerary);

        return itinerary;
    }

    private void dfs(String from, Map<String, PriorityQueue<String >> fromToDestiantion, LinkedList<String> itinerary){

        final PriorityQueue<String> destinations = fromToDestiantion.get(from);
        while (destinations!=null && !destinations.isEmpty()){
            dfs(destinations.poll(), fromToDestiantion, itinerary);
        }

        itinerary.addFirst(from);

    }
}
