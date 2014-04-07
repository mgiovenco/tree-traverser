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
		List<Node> passedNodesList = new ArrayList<Node>();

		if (root != null) {
			passedNodesList.add(root);

			/*
			 * Note: Must use non-enhanced for loop otherwise get
			 * ConcurrentModificationException
			 */
			for (int i = 0; i < passedNodesList.size(); i++) {
				List<Node> childNodesList = passedNodesList.get(i).getChildren();
				
				if (childNodesList != null && !childNodesList.isEmpty()) {
					for (Node childNode : childNodesList) {
						passedNodesList.add(childNode);
					}
				}
			}
		}

		return passedNodesList;
	}
}
