package com.codetest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.codetest.TreeTraverser.Node;

public class TreeTraverserTest {

	private class TestNode implements TreeTraverser.Node {
		
		private int value;
		private List<TreeTraverser.Node> children;
		
		public TestNode(int value)
		{
			this.value = value;
			children = new ArrayList<TreeTraverser.Node>();
		}
		
		public int getValue() {
			return value;
		}

		public List<Node> getChildren() {
			
			return children;
		}
		
		public void addChild(TestNode newChild)
		{
			children.add(newChild);
		}
		
	}
	
	@Test
	public void testNullRoot() {
		TestNode testNode0 = null;
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		
		assertEquals("Should have handled null root", expectedNodeList,  passedNodesList);
	}
	
	@Test
	public void testRootWithNoChildren() {
		TestNode testNode0 = new TestNode(0);
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		expectedNodeList.add(testNode0);
		
		assertEquals("Should have handled root with no children ", expectedNodeList,  passedNodesList);
	}
	
	@Test
	public void testRootWithOneChild() {
		TestNode testNode0 = new TestNode(0);
		TestNode testNodeChild1 = new TestNode(1);
		testNode0.addChild(testNodeChild1);
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		expectedNodeList.add(testNode0);
		expectedNodeList.add(testNodeChild1);

		assertEquals("Should have handle root with one child", expectedNodeList,  passedNodesList);
	}
	
	@Test
	public void testRootWithTwoChild() {
		TestNode testNode0 = new TestNode(0);
		TestNode testNodeChild1 = new TestNode(1);
		TestNode testNodeChild2 = new TestNode(2);
		testNode0.addChild(testNodeChild1);
		testNode0.addChild(testNodeChild2);
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		expectedNodeList.add(testNode0);
		expectedNodeList.add(testNodeChild1);
		expectedNodeList.add(testNodeChild2);
		assertEquals("Should have handle root with two child", expectedNodeList,  passedNodesList);
	}
	
	@Test
	public void testRootWithThreeChild() {
		TestNode testNode0 = new TestNode(0);
		TestNode testNodeChild1 = new TestNode(1);
		TestNode testNodeChild2 = new TestNode(2);
		TestNode testNodeChild3 = new TestNode(3);
		testNode0.addChild(testNodeChild1);
		testNode0.addChild(testNodeChild2);
		testNode0.addChild(testNodeChild3);
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		expectedNodeList.add(testNode0);
		expectedNodeList.add(testNodeChild1);
		expectedNodeList.add(testNodeChild2);
		expectedNodeList.add(testNodeChild3);
		
		assertEquals("Should have handle root with two child", expectedNodeList,  passedNodesList);
	}

	@Test
	public void testRootWithOneChildAndOneGrandChild() {
		TestNode testNode0 = new TestNode(0);
		TestNode testNodeChild1 = new TestNode(1);
		TestNode testNodeGrandChild3 = new TestNode(3);
		testNode0.addChild(testNodeChild1);
		testNodeChild1.addChild(testNodeGrandChild3);
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		expectedNodeList.add(testNode0);
		expectedNodeList.add(testNodeChild1);
		expectedNodeList.add(testNodeGrandChild3);
		
		assertEquals("Should have handle root with two child", expectedNodeList,  passedNodesList);
	}
	
	@Test
	public void testRootWithTwoChildAndTwoGrandChild() {
		TestNode testNode0 = new TestNode(0);
		TestNode testNodeChild1 = new TestNode(1);
		TestNode testNodeChild2 = new TestNode(2);
		TestNode testNodeGrandChild3 = new TestNode(3);
		TestNode testNodeGrandChild5 = new TestNode(5);
		testNode0.addChild(testNodeChild1);
		testNode0.addChild(testNodeChild2);
		testNodeChild1.addChild(testNodeGrandChild3);
		testNodeChild2.addChild(testNodeGrandChild5);
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		expectedNodeList.add(testNode0);
		expectedNodeList.add(testNodeChild1);
		expectedNodeList.add(testNodeChild2);
		expectedNodeList.add(testNodeGrandChild3);
		expectedNodeList.add(testNodeGrandChild5);
		
		assertEquals("Should have handle root with two child", expectedNodeList,  passedNodesList);
	}
	
	@Test
	public void testRootWithTwoChildAndTwoGrandChildAndOneGreatGrandChild() {
		TestNode testNode0 = new TestNode(0);
		TestNode testNodeChild1 = new TestNode(1);
		TestNode testNodeChild2 = new TestNode(2);
		TestNode testNodeGrandChild3 = new TestNode(3);
		TestNode testNodeGrandChild5 = new TestNode(5);
		TestNode testNodeGreatGrandChild14 = new TestNode(14);
		testNode0.addChild(testNodeChild1);
		testNode0.addChild(testNodeChild2);
		testNodeChild1.addChild(testNodeGrandChild3);
		testNodeChild2.addChild(testNodeGrandChild5);
		testNodeGrandChild5.addChild(testNodeGreatGrandChild14);
		List<Node> passedNodesList = TreeTraverser.traverseTreeInWidth(testNode0);
		List<Node> expectedNodeList = new ArrayList<Node>();
		expectedNodeList.add(testNode0);
		expectedNodeList.add(testNodeChild1);
		expectedNodeList.add(testNodeChild2);
		expectedNodeList.add(testNodeGrandChild3);
		expectedNodeList.add(testNodeGrandChild5);
		expectedNodeList.add(testNodeGreatGrandChild14);
		
		assertEquals("Should have handle root with two child", expectedNodeList,  passedNodesList);
	}
	
}
