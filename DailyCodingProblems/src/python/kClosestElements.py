
def kClosestElements(arr, k, x):
    closestNums = []
    for num in arr:
        diff = abs(num - x)
        closestNums.append((diff, num))
    closestNums.sort()

    return [num for diff, num in closestNums[:k]]

print(kClosestElements([1,2,3,4,5,6], 3, 2))