package com.example.alg.graphpck.buildorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {

    enum State{
        COMPLETE,
        PARTIAL,
        BLANK
    }

    private String name;
    private int dependencies;
    private State state = State.BLANK;
    private List<Project> children = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();

    public Project(String name) {
        this.name = name;
    }


    public void addNeighbour(Project project) {

        map.computeIfAbsent(project.name, p -> {
            children.add(project);
            project.incrementDependencies();
            return project;
        });

    }

    private void incrementDependencies() {
        dependencies++;
    }

    public boolean noDependencies() {
        return dependencies == 0;
    }

    public List<Project> getChildren() {
        return children;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
