package cn.knightzz.linked;

/**
 * @author 王天赐
 * @title: RemoveLinkedListElements
 * @projectName leetcode-could
 * @description: https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/10/27 19:01
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {

            if (head == null) {
                return head;
            }

            ListNode dummyNode = new ListNode(-1, head); // 虚拟头结点

            ListNode pre = dummyNode; // 前一个节点, 用来指向被删除的下一个节点
            ListNode cur = head;

            while (cur != null) {
                // 如果当前指向的节点值为 val
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    // pre 向前移动
                    pre = cur;
                }
                cur = cur.next;

            }
            return dummyNode.next;
        }
    }

    class ListNode {
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
