
import heapq


def kthLargestElement(stream, k):
    minHeap = []

    for num in stream:
        heapq.heappush(minHeap, num)
        
    while len(minHeap) > k:
        heapq.heappop(minHeap)
    
    return minHeap[0]

print(kthLargestElement([1,2,3,4,5,6,7,8,9,10], 5))