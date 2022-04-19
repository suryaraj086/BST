package bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import bst.Node;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class BST {
	int k = 0;

	public int[] sortedArrayToBST(int[] nums) {
		int[] bst = new int[nums.length];
		makeATree(0, nums.length - 1, nums, bst);
		return bst;
	}

	public void makeATree(int low, int high, int[] nums, int[] bst) {
		if (low > high)
			return;

		int mid = (high + low) / 2;
		bst[k] = nums[mid];
		k++;
		makeATree(low, mid - 1, nums, bst);
		makeATree(mid + 1, high, nums, bst);
	}

	public int minDiffInBST(TreeNode root) {
		ArrayList<Integer> ls = new ArrayList<>();
		helper(root, ls);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < ls.size(); i++) {
			int temp = ls.get(i) - ls.get(i - 1);
			min = Math.min(Math.abs(temp), min);
		}
		return min;
	}

	public void helper(TreeNode root, ArrayList list) {
		if (root == null) {
			return;
		}
		helper(root.left, list);
		list.add(root.val);
		helper(root.right, list);
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null || root.val == val)
			return root;

		if (root.val < val)
			return searchBST(root.right, val);

		return searchBST(root.left, val);
	}

	int min = 0;

	int sum(Node root, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		sum(root, k, list);
		Collections.sort(list);
		for (int i = 0; i < k; i++) {
			min = min + list.get(i);
		}
		return min;
	}

	void sum(Node root, int k, List<Integer> list) {
		if (root == null) {
			return;
		} else {
			list.add(root.data);
		}
		sum(root.left, k, list);
		sum(root.right, k, list);
		return;

	}

	Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}

		if (root.data < key) {
			root.right = insert(root.right, key);
		}
		if (root.data > key) {
			root.left = insert(root.left, key);
		}
		return root;
	}

	public static void main(String[] args) {
		BST bObj = new BST();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the length");
		int len = scan.nextInt();
		System.out.println("Enter the elements");
		int temp=scan.nextInt();
		Node root = new Node(temp);
		for (int i = 0; i < len-1; i++) {
		    temp = scan.nextInt();
			bObj.insert(root, temp);
		}
		Node.print(root);
	}

}
