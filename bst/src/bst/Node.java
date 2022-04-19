package bst;

public class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	static void print(Node root) {
		if (root == null)
			return;

		print(root.left);
		System.out.print(root.data + " ");

		print(root.right);
	}

}
