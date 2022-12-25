package year2022.month12.day17;

import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNthNode {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stk = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stk.push(tmp);
            tmp = tmp.next;
        }
        ListNode deletedNode = null;
        for (int i = 1; i <= n; ++i) {
            deletedNode = stk.pop();
        }
        if (stk.isEmpty()) {
            ListNode res = new ListNode();
            res.next = deletedNode.next;
            return res.next;
        } else {
            ListNode preNode = stk.pop();
            preNode.next = deletedNode.next;
            return head;
        }
    }
}