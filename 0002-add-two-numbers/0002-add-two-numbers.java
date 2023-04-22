/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int c=0;
        while(l1!=null || l2!=null){
            int x=(l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;
            int sum=c+x+y;
            c=sum/10;
            tail.next=new ListNode(sum%10);
            tail=tail.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(c>0){
            tail.next=new ListNode(c);
        }
        return dummy.next;
    }
}