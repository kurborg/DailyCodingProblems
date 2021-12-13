def recursiveBinarySearch(list, target): 
    if len(list) == 0:
        return -1
    else:
        midpoint = (len(list))// 2

        """Time complexity is O(log n) because we are dividing the list by 2 through each recursive call"""
        """Space Complexity is O(log n) because we are creating a new array in each recursive call"""
        if list[midpoint] == target:
            return True
        elif list[midpoint] < target:
            return recursiveBinarySearch(list[midpoint + 1:], target)
        else:
            return recursiveBinarySearch(list[:midpoint], target)

def verify(result):
    if result is True:
        print("Target found in list")
    else:
        print("Target not found in list")

arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

result = recursiveBinarySearch(arr, 5)
verify(result)