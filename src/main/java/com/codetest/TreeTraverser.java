package com.codetest;

import java.util.ArrayList;
import java.util.List;

public class TreeTraverser {

    // Please do not change this interface
    public static interface Node {
        int getValue();

        List<Node> getChildren();
    }

    public static List<Node> traverseTreeInWidth(Node root) {
        List<Node> passedList = new ArrayList<Node>();
        List<Node> nextList = new ArrayList<Node>();

        if (root != null) {
            passedList.add(root);
            nextList.addAll(root.getChildren());

            while (!nextList.isEmpty()) {
                Node nextNode = nextList.get(0);

                // Add nextNode to passed list
                passedList.add(nextNode);

                // Add children to nextList
                List<Node> nextNodeChildren = nextNode.getChildren();
                if (!nextNodeChildren.isEmpty()) {
                    nextList.addAll(nextNodeChildren);
                }

                // Remove nextNode from list nextList
                nextList.remove(nextNode);
            }
        }

        return passedList;
    }
}
