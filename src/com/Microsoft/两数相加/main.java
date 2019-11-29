package com.Microsoft.两数相加;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/11/29 18:58
 */
public class main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r=null ;
        int tmp=0;
        tmp=l1.val+l2.val+tmp;
        if(tmp>=10){
            r = new ListNode(tmp-10);
            tmp=1;
        }else {
            r = new ListNode(tmp);
            tmp=0;
        }
        ListNode res=r;
        while (l1.next!=null&&l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            tmp=l1.val+l2.val+tmp;
            if(tmp>=10){
                r.next = new ListNode(tmp-10);
                tmp=1;
            }else {
                r.next = new ListNode(tmp);
                tmp=0;
            }
            r=r.next;

        }
        while (l1.next!=null){
            l1=l1.next;
            tmp=tmp+l1.val;
            if(tmp>=10){
                r.next = new ListNode(tmp-10);
                tmp=1;
            }else {
                r.next = new ListNode(tmp);
                tmp=0;
            }
            r=r.next;
        }
        while (l2.next!=null){
            l2=l2.next;
            tmp=tmp+l2.val;
            if(tmp>=10){
                r.next = new ListNode(tmp-10);
                tmp=1;
            }else {
                r.next = new ListNode(tmp);
                tmp=0;
            }
            r=r.next;
        }
        if(tmp==1){
            r.next = new ListNode(1);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(9);
//        l1.next=new ListNode(1);
        l2.next=new ListNode(9);
        System.out.println(addTwoNumbers(l1,l2).val);
    }
}
