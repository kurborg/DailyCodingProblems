'''
Find the kth largest element in a number stream

Problem Statement: Design a class to efficiently find the Kth largest element in a stream of numbers. The class should have the following two things:​

The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.

The class should expose a function add(int num) which will store the given number and return the Kth largest number.
'''
import heapq


def kthLargestElement(stream, k):
    minHeap = []

    for num in stream:
        heapq.heappush(minHeap, num)
        
    while len(minHeap) > k:
        heapq.heappop(minHeap)
    
    return minHeap[0]

print(kthLargestElement([1,2,3,4,5,6,7,8,9,10], 5))