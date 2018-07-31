package com.example.alg.graphpck.buildorder;

import java.util.ArrayDeque;
import java.util.List;

import static java.util.Arrays.stream;

public class BuildOrder {

//    //DFS
//    public ArrayDeque<Project> orderProjects(List<Project> projects){
//        ArrayDeque<Project> stack = new ArrayDeque<>();
//
//
//    }

    public Project[] findBuildOrder(String[] projects, String[][] dependencies){

        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    private Project[] orderProjects(List<Project> nodes) {
        Project[] result = new Project[nodes.size()];

        Integer endOfList = addNonDependent(result, nodes, 0);

        int toBeProcessed = 0;
        while (toBeProcessed< result.length){
            final Project current = result[toBeProcessed];

            if(current==null){
                return null;
            }

            current.getChildren()
                    .forEach(Project::decrementDependencies);
            endOfList = addNonDependent(result, current.getChildren(), endOfList);
            toBeProcessed++;
        }
        return result;
    }

    private Integer addNonDependent(Project[] result, List<Project> nodes, int offset) {
        Integer noOffset = offset;
        for(Project project: nodes){
            if(project.noDependencies()){
                result[noOffset]=project;
                noOffset++;
            }
        }
       return noOffset;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        final Graph graph = new Graph();
        stream(projects).forEach(graph::createNode);

        stream(dependencies).forEach(dep -> graph.addEdge(dep[0], dep[1]));

        return graph;
    }

}
