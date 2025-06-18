package DataStructs.NeetCode.MergeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNodeMerge{
    int val;
    ListNodeMerge next;

    public ListNodeMerge(int val){
        this.val = val;
        next = null;
    }
}
public class MergeKSortedLinkList {
    public static void main(String[] args){
        ListNodeMerge l1Head = new ListNodeMerge(1);
        l1Head.next = new ListNodeMerge(2);
        l1Head.next.next = new ListNodeMerge(4);

        ListNodeMerge l2Head = new ListNodeMerge(1);
        l2Head.next = new ListNodeMerge(3);
        l2Head.next.next = new ListNodeMerge(5);

        ListNodeMerge l3Head = new ListNodeMerge(3);
        l3Head.next = new ListNodeMerge(6);

        ListNodeMerge[] list = {l1Head,l2Head,l3Head};
        printListNodeMerge(l1Head);
        printListNodeMerge(l2Head);
        printListNodeMerge(l3Head);
        ListNodeMerge sortedLinkList = getSortedLinkListBruteForce(list);
        printListNodeMerge(sortedLinkList);
    }

    private static void printListNodeMerge(ListNodeMerge list) {
        while(list!=null){
            System.out.print(list.val+" ");
            list = list.next;
        }
        System.out.println();
    }

    //Brute Force method of finding merge and sort . Time complexity : O(n log n) Space complexity : O  (n)
    private static ListNodeMerge getSortedLinkListBruteForce(ListNodeMerge[] list) {
        List<Integer> nodes = new ArrayList<>();
        for(ListNodeMerge lst:list) {
            while (lst != null) {
                nodes.add(lst.val);
                lst = lst.next;
            }
        }
        Collections.sort(nodes);
        ListNodeMerge res = new ListNodeMerge(0);
        ListNodeMerge cur = res;
        for (int node : nodes) {
            cur.next = new ListNodeMerge(node);
            cur = cur.next;
        }
        return res.next;
    }

    //
}
