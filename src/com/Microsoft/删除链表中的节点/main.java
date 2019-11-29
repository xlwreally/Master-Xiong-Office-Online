package com.Microsoft.删除链表中的节点;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/11/29 20:58
 */
public class main {
    public class ListNode {
        int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

        public void deleteNode(ListNode node) {
                node.val=node.next.val;
                node.next=node.next.next;
        }
}
