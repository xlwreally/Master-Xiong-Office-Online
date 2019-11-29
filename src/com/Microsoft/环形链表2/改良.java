package com.Microsoft.环形链表2;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/11/29 18:55
 */
public class 改良 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode p = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                p2 = head;
                while (p != p2) {
                    p = p.next;
                    p2 = p2.next;
                }
                return p2;
            }

        }
        return null;
    }
}
