package WebSitePractices.NeetCode.SinglyLinkedList;

import java.util.List;

/**
 * Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.
 * Input: head = [0,1,2,3]
 * Output: [3,2,1,0]
 *
 * Input: head = []
 * Output: []
 *
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class ReverseLinkedList {
    public static void main (String[] args){
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        System.out.println("Original List: ");
        printList(head);
        head = reverseList(head);
        System.out.println("reversed list ");
        printList(head);
    }
    private static void printList(ListNode head){
        while(head !=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next ;
        while(current !=null){
            next = current.next;
            current.next = prev;
            prev = current;

            current = next;
        }
        return prev;
    }
}
