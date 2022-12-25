package year2022.month12.day17;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *  
 *
 * 提示：
 *
 * 给定链表的结点数介于 1 和 100 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListMiddleNode {
    public static void main(String[] args) {

    }

    /**
     * 常规解法
     * 遍历一次 找到中间节点的下标
     */
    public ListNode middleNode1(ListNode head) {
        ListNode tmp = head;
        int listLength = 0;
        while (tmp != null) {
            ++listLength;
            tmp = tmp.next;
        }
        int idx = 1;
        while (idx <= listLength / 2 && head != null) {
            ++idx;
            head = head.next;
        }
        return head;
    }

    /**
     * 快慢指针
     * 慢指针每次移动一个节点 快指针一次移动两个节点
     * 当快指针溢出边界时 慢指针一定在链表中点
     * 1 2 3 4 5 6
     * slow -> 1 fast -> 1
     * slow -> 2 fast -> 3
     * slow -> 3 fast -> 5
     * slow -> 4 fast ->
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}