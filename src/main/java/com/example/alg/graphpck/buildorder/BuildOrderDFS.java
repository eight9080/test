package com.example.alg.graphpck.buildorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class BuildOrderDFS {

    public List<Project> findBuildOrder(String[] projects, String[][] dependencies){

        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    //DFS
    private List<Project> orderProjects(List<Project> projects){
        ArrayDeque<Project> stack = new ArrayDeque<>();
        for (Project project :projects) {
            if(project.getState()==Project.State.BLANK){
                if(!doDFS(project, stack)){
                    return null;
                }
            }
        }
        return new ArrayList<>(stack);

    }

    private boolean doDFS(Project project, ArrayDeque<Project> stack) {
        if(project.getState()==Project.State.PARTIAL){
            return false;
        }
        if(project.getState() == Project.State.COMPLETE){
            return true;
        }
        project.setState(Project.State.PARTIAL);
        final List<Project> children = project.getChildren();
        for(Project child: children){
            if(!doDFS(child, stack)){
                return false;
            }
        }
        project.setState(Project.State.COMPLETE);
        stack.push(project);
        return true;
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        final Graph graph = new Graph();
        stream(projects).forEach(graph::createNode);

        stream(dependencies).forEach(dep -> graph.addEdge(dep[0], dep[1]));

        return graph;
    }


}
