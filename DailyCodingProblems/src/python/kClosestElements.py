'''
Find ‘k’ closest numbers

Problem Statement: Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
'''
def kClosestElements(arr, k, x):
    closestNums = []
    for num in arr:
        diff = abs(num - x)
        closestNums.append((diff, num))
    closestNums.sort()

    return [num for diff, num in closestNums[:k]]

print(kClosestElements([1,2,3,4,5,6], 3, 2))