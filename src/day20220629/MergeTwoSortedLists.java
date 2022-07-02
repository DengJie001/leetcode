package day20220629;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//public class MergeTwoSortedLists {
//
//    public static void main(String[] args) {
//        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
//        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        System.out.println(new MergeTwoSortedLists().mergeTwoList(list1, list2));
//    }
//
//    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
//        ListNode res = new ListNode();
//        ListNode temp = res;
//        while (list1 != null && list2 != null) {
//            if (list1.val > list2.val) {
//                temp.next = list2;
//                list2 = list2.next;
//            } else {
//                temp.next = list1;
//                list1 = list1.next;
//            }
//            temp = temp.next;
//        }
//        if (list1 != null) {
//            temp.next = list1;
//        }
//        if (list2 != null) {
//            temp.next = list2;
//        }
//        return res.next;
//    }
//
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