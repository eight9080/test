package com.example.alg.triepkg;

import java.util.HashMap;
import java.util.Objects;

public class TrieNode {
     char c;
     HashMap<Character, TrieNode> children = new HashMap<>();
     boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c){
        this.c = c;
    }

    public TrieNode(char c, boolean isLeaf) {
        this.c = c;
        this.isLeaf = isLeaf;
    }

    public char c() {
        return c;
    }

    public void c(char c) {
        this.c = c;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void leaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void child(Character c, TrieNode n){
        children.put(c, n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrieNode trieNode = (TrieNode) o;
        return c == trieNode.c &&
                isLeaf == trieNode.isLeaf &&
                Objects.equals(children, trieNode.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, children, isLeaf);
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "c=" + c +
                ", children=" + children +
                ", isLeaf=" + isLeaf +
                '}';
    }
}
