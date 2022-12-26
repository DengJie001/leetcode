package year2022.month12.day26;

/**
 * 21.合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        new MergeTwoSortedLists().mergeTwoLists(list1, list2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.val = list1.val;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                tmp.val = list2.val;
                list2 = list2.next;
            } else {
                tmp.val = list1.val;
                list1 = list1.next;
            }
            if (list1 == null) {
                tmp.next = list2;
            } else if (list2 == null) {
                tmp.next = list1;
            } else {
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }
        return res;
    }
}

class ListNode {
    int val;

    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}