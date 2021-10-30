import textio.TextIO;

public class Exercise2 {

    private static String readNextWord() {
        char ch = TextIO.peek(); // Look at next character in input.
        while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
            TextIO.getAnyChar();  // Read the character.
            ch = TextIO.peek();   // Look at the next character.
        }
        if (ch == TextIO.EOF) // Encountered end-of-file
            return null;
        String word = "";  // This will be the word that is read.
        while (true) {
            word += TextIO.getAnyChar();  // Append the letter onto word.
            ch = TextIO.peek();  // Look at next character.
            if ( ch == '\'' ) {
                TextIO.getAnyChar();   // Read the apostrophe.
                ch = TextIO.peek();    // Look at char that follows apostrophe.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // Look at next char.
                }
                else
                    break;
            }
            if ( ! Character.isLetter(ch) ) {
                break;
            }
        }
        return word;  // Return the word that has been read.
    }

    public static void main(String[] args) {
        try {
            if (TextIO.readUserSelectedFile() == false) {
                System.out.println("No input file selected.  Exiting.");
                System.exit(1);
            }

            String word;
            word = readNextWord();
            while (word != null) {
                word = word.toLowerCase();
                if (!treeContains(root, word)) {
                    treeInsert(word);
                }
                word = readNextWord();
            }
            System.out.println("Number of different words in the file: " + countNodes(root));
        } catch (IllegalArgumentException e) {
            System.out.println("Encountered error: " + e);
        }
        System.out.println("Word List:");
        treeList(root);
    }


    private static class TreeNode {
        String item;
        TreeNode left;
        TreeNode right;

        TreeNode(String str) {
            item = str;
        }
    }
    private static TreeNode root;

    private static void treeInsert(String newItem) {
        if (root == null) {
            // The tree is empty.  Set root to point to a new node containing
            // the new item.  This becomes the only node in the tree.
            root = new TreeNode(newItem);
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {
                // Since the new item is less than the item in runner,
                // it belongs in the left subtree of runner.  If there
                // is an open space at runner.left, add a new node there.
                // Otherwise, advance runner down one level to the left.
                if (runner.left == null) {
                    runner.left = new TreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.left;
            } else {
                // Since the new item is greater than or equal to the item in
                // runner it belongs in the right subtree of runner.  If there
                // is an open space at runner.right, add a new node there.
                // Otherwise, advance runner down one level to the right.
                if (runner.right == null) {
                    runner.right = new TreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else
                    runner = runner.right;
            }
        }
    }

    static boolean treeContains(TreeNode root, String item) {
        if (root == null) {
            return false;
        } else if (item.equals(root.item)) {
            return true;
        } else if (item.compareTo(root.item) < 0) {
            return treeContains(root.left, item);
        } else {
            return treeContains(root.right, item);
        }
    }

    private static void treeList(TreeNode node) {
        if (node != null) {
            treeList(node.left);
            System.out.println("  " + node.item);
            treeList(node.right);
        }
    }

    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    }

}
