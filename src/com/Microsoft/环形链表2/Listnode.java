package com.Microsoft.环形链表2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/11/24 10:22
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
      }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        LinkedList<ListNode> stack=new LinkedList<ListNode>();
        if(head==null)return null;
        while (head.next!=null){
            for (ListNode li:stack
            ) {
                if(li==head)return li;
            }

            stack.offer(head);
            head=head.next;
        }

        return null;
    }

    }
  }