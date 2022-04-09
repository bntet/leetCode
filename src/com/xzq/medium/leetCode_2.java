package com.xzq.medium;

/**
 * 两数相加
 */
public class leetCode_2 {
    public static void main(String[] args) {
        //  2 -> 4 -> 3  :  342
        //  5 -> 6 -> 4  : +465
        //                  807
        //  7 -> 0 -> 8
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode listNode = addTwoNumbers(l1, l2);

        System.out.println(listNode.toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;      //设置满10进1位
        while (l1 != null || l2 != null){

            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            int sum = n1 + n2 + carry;
            carry = sum / 10;      //取余多少
            int mo = sum % 10;      //取模多少

            if(head == null){
                //将第一个相加的数赋值
                head = tail = new ListNode(mo);
            }else{
                //让上个值指向当前值
                tail.next = new ListNode(mo);
                tail = tail.next;
            }

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return head;
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
