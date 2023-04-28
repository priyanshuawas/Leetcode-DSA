class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size =0;
        while(temp != null){
            temp= temp.next;
            size++;
        }
        if(n==size){
            head=head.next; 
            return head;
        }
        ListNode prev=head;
        int i=1;
        while(i<(size- n)){         
            prev=prev.next;
            i++;    
        }
        prev.next = prev.next.next;
        return head;
        
    }
}