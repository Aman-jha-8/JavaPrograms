package JavaPgms.Sorting;

class LLInsertionSort {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Already sorted or empty list
        }

        ListNode sorted = null; // Head of the sorted list

        while (head != null) {
            ListNode current = head;
            head = head.next; // Move to the next node in the original list

            // Insert 'current' into the sorted list
            if (sorted == null || current.val < sorted.val) {
                current.next = sorted;
                sorted = current;
            } else {
                ListNode temp = sorted;
                while (temp.next != null && temp.next.val < current.val) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
        }

        return sorted;
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
        LLInsertionSort solution = new LLInsertionSort();

        // Example usage
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        solution.printList(head);

        ListNode sorted = solution.insertionSort(head);

        System.out.println("Sorted List:");
        solution.printList(sorted);
    }
}

