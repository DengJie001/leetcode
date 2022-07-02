package day20220630;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//public class ReverseLinkedList {
//    public static void main(String[] args) {
//
//    }
//
//    public ListNode reverse(ListNode head) {
////        if (head == null || head.next == null) {
////            return head;
////        }
//        ListNode curr = head;
//        ListNode prev = null;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }
//}
//
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//
//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
//    }
//}