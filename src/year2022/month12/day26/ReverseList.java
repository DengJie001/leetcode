package year2022.month12.day26;

import java.util.List;
import java.util.Stack;

/**
 * 206.反转链表
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stk = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stk.push(tmp);
            tmp = tmp.next;
        }
        ListNode res = stk.peek();
        while (!stk.isEmpty()) {
            ListNode node = stk.pop();
            node.next = stk.peek();
            if (stk.size() == 1) {
                stk.pop().next = null;
            }
        }
        return res;
    }
}
