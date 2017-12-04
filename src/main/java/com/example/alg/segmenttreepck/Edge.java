package com.example.alg.segmenttreepck;

import java.util.Objects;

public class Edge {

    int x;
    int height; //y
    boolean isStart;

    public Edge(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return x == edge.x &&
                height == edge.height &&
                isStart == edge.isStart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, height, isStart);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "x=" + x +
                ", height=" + height +
                ", isStart=" + isStart +
                '}';
    }
}
