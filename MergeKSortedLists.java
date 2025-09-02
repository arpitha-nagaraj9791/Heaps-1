/* 
Time Complexity: O(n log k) 
   - n = total number of nodes across all lists
   - Each poll/add operation on heap (size k) costs O(log k)
   - Every node is pushed/popped once → O(n log k)

Space Complexity: O(k) 
   - Heap holds at most one node from each list at a time

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// 1. Initialize a min-heap ordered by node value. Push the head of each non-empty list.
// 2. While heap is not empty:
//    - Poll the smallest node and append it to the merged list.
//    - If polled node has a next, push it into the heap.
// 3. Continue until all nodes are processed. Dummy head simplifies pointer handling.


import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        PriorityQueue<ListNode> minHeap = createMinHeap(lists);

        while(!minHeap.isEmpty()){
            ListNode node = minHeap.poll();
            ptr.next = node;
            ptr = ptr.next;

            if(node.next != null){
                minHeap.add(node.next);
            }
        }
        return dummy.next;
    }

    private PriorityQueue<ListNode> createMinHeap(ListNode[] lists){
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2)-> n1.val - n2.val);

        for(ListNode list : lists){
            if(list != null){
                minHeap.add(list);
            }
        }
        return minHeap;
    }
}
