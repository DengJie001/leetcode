package day20220703;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 104.二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode level2left = new TreeNode(2, null, null);
        TreeNode level2right = new TreeNode(3, null, null);
        TreeNode level3left = new TreeNode(4, null, null);
        TreeNode level3right = new TreeNode(5, null, null);
        level2left.left = level3left;
        level2left.right = level3right;
        root.left = level2left;
        root.right = level2right;
        System.out.println(new MaximumDepthOfBinaryTree().maxDepthBFS(root));
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --size;
            }
            ++res;
        }
        return res;
    }
}
