package JavaPgms.Sorting;

public class LLMergeSort {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }

        // Split the list into two halves
        ListNode middle = findMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null; // Split the list

        // Recursively sort both halves
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(secondHalf);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Helper function to find the middle of the list
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted lists
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }

    // Helper function to print the linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LLMergeSort solution = new LLMergeSort();

        // Example usage
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        solution.printList(head);

        ListNode sorted = solution.mergeSort(head);

        System.out.println("Sorted List:");
        solution.printList(sorted);
    }
}
