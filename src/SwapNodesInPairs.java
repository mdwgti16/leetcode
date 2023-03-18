public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        ListNode listNode = new Solution().swapPairs(head);
        System.out.println(listNode);
    }

    static class SolutionRecursive {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode preHead = swapPairs(head.next.next);
            ListNode curNext = head.next;
            head.next.next = head;
            head.next = preHead;
            return curNext;
        }
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode res = new ListNode();
            ListNode temp = res;

            while (head != null) {
                if (head.next == null) {
                    temp.next = head;
                    break;
                }

                ListNode t1 = head.next.next;
                temp.next = head.next;
                temp.next.next = head;
                head.next = null;
                temp = temp.next.next;
                head = t1;
            }

            return res.next;
        }
    }

    static class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode res = new ListNode();
            ListNode temp = res;

            while (head != null) {
                if (head.next == null) {
                    temp.next = head;
                    break;
                }

                ListNode t1 = head.next.next;
                head.next.next = null;
                temp.next = head.next;
                head.next = null;
                temp.next.next = head;
                temp = temp.next.next;
                head = t1;
            }

            return res.next;
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
