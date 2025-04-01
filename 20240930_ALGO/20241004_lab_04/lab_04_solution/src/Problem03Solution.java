public class Problem03Solution {
    public class ListNode {
      int val;     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode prev, current, next;

        prev = null;
        current = head;
        next = current.next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;


    }
}
