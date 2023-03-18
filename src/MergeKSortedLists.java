import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {

    public static void main(String[] args) {
//        ListNode listNode = new Solution().mergeKLists(head, 2);
//        System.out.println(listNode);
    }

    static class SolutionRecursive {
        public ListNode merge(ListNode left, ListNode right) {

            ListNode dummy = new ListNode();
            ListNode res = dummy;

            while (left != null && right != null) {
                if (left.val < right.val) {
                    res.next = left;
                    res = res.next;
                    left = left.next;
                } else {
                    res.next = right;
                    res = res.next;
                    right = right.next;
                }
            }

            res.next = left != null ? left : right;

            return dummy.next;

        }

        public ListNode helper(ListNode[] lists, int left, int right) {
            if (left == right) return lists[left];

            int mid = (left + right) / 2;
            ListNode l = helper(lists, left, mid);
            ListNode r = helper(lists, mid + 1, right);

            return merge(l, r);
        }

        public ListNode mergeKLists(ListNode[] lists) {

            if (lists.length == 0) return null;

            return helper(lists, 0, lists.length - 1);

        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }

            ListNode head = new ListNode();
            ListNode temp = head;

            List<Integer> values = new ArrayList<>();
            for (ListNode listNode : lists) {
                while (listNode != null) {
                    values.add(listNode.val);
                    listNode = listNode.next;
                }
            }

            Collections.sort(values);
            for (Integer value : values) {
                temp.next = new ListNode(value);
                temp = temp.next;
            }

            return head.next;
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
