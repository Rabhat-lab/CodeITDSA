package DataStructs.NeetCode.DoublyLinkedList;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next.
 * val is the value of the current node,
 * and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute
 * prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * 1. MyLinkedList() Initializes the MyLinkedList object.
 * 2. int get(int index) Get the value of the indexth node in the linked list.
 * 3. If the index is invalid, return -1.
 * 4. void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * 5. After the insertion, the new node will be the first node of the linked list.
 * 6. void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * 7. void addAtIndex(int index, int val) Add a node of value val before the indexth node in
 *    the linked list. If index equals the length of the linked list, the node will be appended
 *    to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * 8. void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 * Algorithm :
 * * Initialize: Suppose we call MyLinkedList() constructor.
 * The linked list is now initialized. It has a dummy node and the count (self.cnt) is set to 0.
 * Currently, the list looks like this: dummy -> null.
 *
 * * addAtHead(1): We want to add a value 1 at the head of the list.
 * The method addAtHead(1) is invoked, which internally calls addAtIndex(0, 1).
 * Since the index is 0, the new node with value 1 is inserted right after the dummy node.
 * Now the list looks like this: dummy -> 1 -> null.
 * The count (self.cnt) is incremented to 1.
 *
 * * addAtTail(3): Now, we add a value 3 at the tail of the list.
 * Calling addAtTail(3) will invoke addAtIndex(self.cnt, 3).
 * The new node with value 3 is inserted after the node with value 1.
 * The list now looks like this: dummy -> 1 -> 3 -> null.
 * The count (self.cnt) is incremented to 2.
 *
 * addAtIndex(1, 2): Next, we insert a value 2 at index 1.
 * The addAtIndex(1, 2) method will traverse the list and insert the new node
 * with value 2 between the nodes 1 and 3.
 * The list is now: dummy -> 1 -> 2 -> 3 -> null.
 * The count (self.cnt) is updated to 3.
 *
 * deleteAtIndex(1): Now, let's delete the node at index 1.
 * Invoking deleteAtIndex(1) method locates the node just before the target node (the node with value 1) and updates its next reference to the node after the target node (the node with value 3).
 * The node with value 2 is now removed from the list.
 * The list becomes: dummy -> 1 -> 3 -> null.
 * The count (self.cnt) is decremented to 2.
 *
 */
class LinkListNode {
    int val;

    LinkListNode next;

    public LinkListNode(int val) {
        this.val = val;
        this.next = null;
    }
    public LinkListNode(int val,LinkListNode next) {
        this.val = val;
        this.next = next;
    }

}
class MyLinkList{
    LinkListNode dummyHead = new LinkListNode(0);
    int size; //number of elements in the linkedlist
    public int getIndexVal(int index){
        if(index <0 || index >= size){
            return -1;
        }
        LinkListNode curr = dummyHead;
        while(index-- >0){
            curr = curr.next;
        }
        return curr.val;
    }
    public void addAtHead(int val){
        addAtIndex(0,val);
    }
    public void addAtTail(int val){
        addAtIndex(size,val);
    }
    public void addAtIndex(int index,int val){
        //if index greater than size , node not to be inserted
        if(index>size){
            return;
        }
        LinkListNode curr = dummyHead;
        while(index-- >0){
            curr = curr.next;
        }
        curr.next = new LinkListNode(val,curr.next);
        size++; // increase the size
    }
    public void deleteAtIndex(int index){
        if(index<0 || index>=size){
            return;
        }
        LinkListNode curr = dummyHead;
        while(index-- >0){
            curr=curr.next;
        }
        LinkListNode toDelete = curr.next;
        curr.next = toDelete.next;
        toDelete.next = null;
        size--;
    }


}
public class DesignLinkedList {

}
