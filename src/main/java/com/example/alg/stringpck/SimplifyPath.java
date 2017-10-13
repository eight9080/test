package com.example.alg.stringpck;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    /**
     * Given an absolute path for a file (Unix-style), simplify it.

     For example,

     path = "/home/", => "/home"
     path = "/a/./b/../../c/", => "/c"
     path = "/../", => "/"
     path = "/home//foo/", => "/home/foo"
     */
    public String simplifyPath(String path) {
        Deque<String> pathQueue = new ArrayDeque<>();
        final String[] parts = path.split("/");
        for (String part: parts) {
            if("".equals(part)){
                continue;
            }
            if("..".equals(part)) {
                if(!pathQueue.isEmpty()) {
                    pathQueue.pop();
                }
            }else if(!".".equals(part)){
                pathQueue.push(part);
            }
        }

        if(pathQueue.isEmpty()) return "/";

        final StringBuilder resultPath = new StringBuilder();

        while (!pathQueue.isEmpty()){
            resultPath.append("/").append(pathQueue.pollLast());
        }

        return resultPath.toString();
    }
}
