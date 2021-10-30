@SuppressWarnings("DuplicatedCode")
public class Exercise5 {

    private static class TreeNode {
        double item;
        TreeNode left;
        TreeNode right;

        TreeNode(double number) {
            item = number;
        }
    }
    private static TreeNode root;

    private static void treeInsert(double newItem) {
        if (root == null) {
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;
        runner = root;
        while (true) {
            if (newItem < runner.item) {
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;
                } else
                    runner = runner.left;
            } else {
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;
                } else
                    runner = runner.right;
            }
        }
    }

    static int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    static int sumOfLeaveDepths(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        return sumOfLeaveDepths(node.left, depth + 1) + sumOfLeaveDepths(node.right, depth + 1);
    }

    public static void main(String[] args) {
        int numberOfNodes = 0;
        while (numberOfNodes < 1023) {
            double newNumber = Math.random();
            treeInsert(newNumber);
            numberOfNodes++;
        }
        System.out.println("Number of leaves: " + countLeaves(root));
        System.out.println("Average leaf depth: " + sumOfLeaveDepths(root, 0) / countLeaves(root));
    }
}
