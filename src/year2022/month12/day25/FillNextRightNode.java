package year2022.month12.day25;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/?envType=study-plan&id=suan-fa-ru-men&plan=algorithms&plan_progress=yu2b416
 */
public class FillNextRightNode {
    public static void main(String[] args) {
        Node n7 = new Node(7, null, null, null);
        Node n6 = new Node(6, null, null, null);
        Node n5 = new Node(5, null, null, null);
        Node n4 = new Node(4, null, null, null);
        Node n3 = new Node(3, n6, n7, null);
        Node n2 = new Node(2, n4, n5, null);
        Node n1 = new Node(1, n2, n3, null);
        System.out.println(new FillNextRightNode().connect(n1));
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Node> queue1 = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node curNode = queue.poll();
                queue1.offer(curNode);
                if (queue.isEmpty()) {
                    curNode.next = null;
                } else {
                    curNode.next = queue.peek();
                }
            }
            while (!queue1.isEmpty()) {
                Node node = queue1.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}

class Node {
    int val;

    Node left;

    Node right;

    Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
