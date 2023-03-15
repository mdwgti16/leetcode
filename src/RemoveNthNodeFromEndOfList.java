import java.util.LinkedList;
import java.util.Queue;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new Solution().removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();

            ListNode slow = dummy;
            ListNode fast = dummy;
            slow.next = head;
            for (int i = 1; i <= n; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }

    static class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode result = new ListNode();
            result.next = new ListNode();
            ListNode next = result.next;

            Queue<Integer> queue = new LinkedList<>();
            while (true) {
                queue.add(head.val);

                if (head.next == null) {
                    break;
                }

                head = head.next;
            }

            int size = queue.size();
            if (size == 1) {
                return null;
            }

            for (int j = 0; j < size; j++) {
                if (j == size - n) {
                    queue.poll();
                    continue;
                }

                next.val = queue.poll();

                if (j < size - 1 && (n != 1 || j != size - 2)) {
                    next.next = new ListNode();
                    next = next.next;
                }
            }

            return result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
