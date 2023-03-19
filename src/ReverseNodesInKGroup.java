public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = new SolutionRecursive().reverseKGroup(head, 2);
        System.out.println(listNode);
    }

    static class SolutionRecursive {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode temp = head;
            ListNode prev = null;
            ListNode nextnode = temp;
            int i = 0;

            if (!checkSize(head, k)) {
                return head;
            }

            while (i < k && temp != null) {
                nextnode = temp.next;
                temp.next = prev;
                prev = temp;
                temp = nextnode;
                i++;
            }

            if (nextnode != null) {
                head.next = reverseKGroup(nextnode, k);
            }

            return prev;
        }

        private boolean checkSize(ListNode head, int k) {
            int count = 1;
            ListNode temp = head;
            while (temp.next != null && count < k) {
                count++;
                temp = temp.next;
            }

            return k == count;
        }
    }

    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode();
            ListNode temp = dummy;

            ListNode nextGroup = head;
            ListNode curGroup = head;
            while (true) {
                int i = k;
                for (; i > 0 && nextGroup != null; i--) {
                    nextGroup = nextGroup.next;
                }

                if (i > 0) {
                    break;
                }

                for (int j = k - 1; j > 0; j--) {
                    ListNode res = curGroup;

                    for (int l = j; l > 0; l--) {
                        res = res.next;
                    }

                    temp.next = res;
                    temp = temp.next;
                }

                temp.next = curGroup;
                curGroup.next = nextGroup;
                temp = temp.next;
                curGroup = nextGroup;
            }

            return dummy.next;
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
