package DataStructs.NeetCode.SinglyLinkedList;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
 * The new list should be made up of nodes from list1 and list2.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,5]
 * Output: [1,1,2,3,4,5]
 *
 * Input: list1 = [], list2 = [1,2]
 * Output: [1,2]
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * ALgorithm :
 * 1. A dummy node is created; this node does not hold any meaningful value but serves
 * as the starting point of the merged linked list.
 * 2. A curr pointer is initialized to point at the dummy node.
 * 3. This pointer moves along the new list as nodes are added.
 * 4. A while loop continues as long as there are elements in both list1 and list2.
 * 5. Inside the loop, a comparison is made:
 *     1. If the value of the current node in list1 is less than or equal to the value of
 *        the current node in list2, the next pointer of curr is linked to the current node of list1,
 *        and list1 is advanced to its next node.
 *     2. Otherwise, curr next is linked to the current node of list2, and list2 is advanced
 *        to its next node.
 *     3. After each iteration, curr is moved to its next node, effectively growing the merged list.
 *     4. If one of the lists is exhausted before the other, the loop ends. Since one of the lists
 *       (either list1 or list2) will be None, the or operator in Python ensures that curr.next will be
 *       linked to the remaining non-empty list.
 *     5. Finally, the head of the merged list, which is immediately after the dummy node,
 *        is returned (dummy.next), thus omitting the dummy node which was just a placeholder.
 *
 */
class LinkNode {
    int val;
    LinkNode next;
    public LinkNode(){

    }
    public LinkNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class MergeTwoSortedLinkedList {
    public static void main(String[] args){
        LinkNode head1 = new LinkNode(1);
        head1.next = new LinkNode(2);
        head1.next.next = new LinkNode(3);
        System.out.println("List 1 :");
        printList(head1);
        LinkNode head2 = new LinkNode(1);
        head2.next = new LinkNode(3);
        head2.next.next = new LinkNode(5);
        System.out.println("List 2 :");
        printList(head2);

        LinkNode mergeList = getMergeList(head1,head2);
        System.out.println("Merged List :");
        printList(mergeList);
    }
    private static void printList(LinkNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    private static LinkNode getMergeList(LinkNode head1,LinkNode head2){
        LinkNode dummyHead = new LinkNode();
        LinkNode curr = dummyHead;
        while(head1 != null && head2 !=null){
            if(head1.val <= head2.val){
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        //if either of the Linkedlist ends and elements become empty , just append the other elements
        curr.next = (head1==null)?head2:head1;
        return dummyHead.next;
    }
}
