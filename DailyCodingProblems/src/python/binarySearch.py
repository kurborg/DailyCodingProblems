def binarySearch(list, target):
    first = 0
    last = len(list) - 1 
    
    while first <= last:
        midpoint = (first + last) //2
        if list[midpoint] == target:
            return midpoint
        elif list[midpoint] < target:
            first = midpoint + 1
        else:
            last = midpoint -1
    
    return -1

def verify(index):
    if index != -1:
        print("Target found at index: ", index)
    else:
        print("Target not found in list")

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

result = binarySearch(arr, 7)
verify(result)
