package day20220629;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//public class RemoveLinkedListElements {
//    public static void main(String[] args) {
//        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(1))));
//        System.out.println(new RemoveLinkedListElements().removeElements(list1, 1));
//    }
//
//    public ListNode removeElements(ListNode list, int val) {
//        ListNode temp = list;
//        while (temp != null) {
//            if (temp.val == val) {
//                temp = temp.next;
//            }
//            temp = temp.next;
//        }
//        return list;
//    }
//}
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