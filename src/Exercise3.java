public class Exercise3 {
    static class ListNode {
        int item;
        ListNode next;
    }

    static ListNode reversedList(ListNode list) {
        ListNode reversedList = null;
        while (list != null) {
            ListNode newNode = new ListNode();
            newNode.item = list.item;
            newNode.next = reversedList;
            reversedList = newNode;
            list = list.next;
        }
        return reversedList;
    }

    static void printNodes(ListNode start) {
        ListNode runner;
        runner = start;
        while (runner != null) {
            System.out.print(runner.item + " ");
            runner = runner.next;
        }
    }

    public static void main(String[] args) {
        int numberOfNodes = 0;
        ListNode startList = null;
        while (numberOfNodes != 10) {
            ListNode node = new ListNode();
            node.item = (int) (Math.random() * 100 + 1);
            node.next = startList;
            startList = node;
            numberOfNodes++;
        }
        System.out.println("List: ");
        printNodes(startList);

        System.out.println();
        ListNode listReversed;
        listReversed = reversedList(startList);
        System.out.println("Reversed List: ");
        printNodes(listReversed);

    }


}
