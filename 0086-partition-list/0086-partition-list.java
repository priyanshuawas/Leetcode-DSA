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
    public ListNode partition(ListNode head, int x) {
        ListNode firstHead=new ListNode(0);
        ListNode firstTail=firstHead;
        ListNode secondHead=new ListNode(0);
        ListNode secondTail=secondHead;
        ListNode curr=head;

        while(curr!=null){
            if(curr.val<x){
                firstTail.next=curr;
                firstTail=curr;
            }
            else{
                secondTail.next=curr;
                secondTail=curr;
            }
            curr=curr.next;
        }
        firstTail.next=secondHead.next;
        secondTail.next=null;
        return firstHead.next;
    }
}