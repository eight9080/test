package com.example.alg.graphpck.buildorder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {

    private List<Project> nodes = new LinkedList<>();
    private Map<String, Project> map = new HashMap<>();

    public Project createNode(String project) {
       return map.computeIfAbsent(project, (k) -> {
            final Project newProject = new Project(k);
            nodes.add(newProject);
            return newProject;
        });
    }

    private Project getProject(String name){
        return createNode(name);
    }


    public void addEdge(String start, String end) {
        final Project startPrj = getProject(start);
        final Project endPrj = getProject(end);
        startPrj.addNeighbour(endPrj);
    }

    public List<Project> getNodes() {
        return nodes;
    }
}
