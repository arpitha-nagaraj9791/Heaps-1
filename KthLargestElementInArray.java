/* 
Time Complexity: O(n log k) 
   - Insert n elements into a min-heap of size k
   - Each add/poll operation costs O(log k)
   - Total: O(n log k)

Space Complexity: O(k) 
   - Heap can grow up to size k

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// 1. Use a min-heap of size k.
// 2. Iterate over all numbers in nums, add each to the heap.
// 3. If heap size exceeds k, poll the smallest element (maintain only k largest elements).
// 4. After processing, the top of the min-heap is the kth largest element.


import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> a - b);

        for(int i = 0; i < nums.length; i++){
            minHeap.add(nums[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
