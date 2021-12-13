def linearSearch(list, target):
    """ 
    returns the index position of the target if found, else returns None
    """
    for i in range(0, len(list)):
        if list[i] == target:
            return i
    return -1

def verify(index):
    if index != -1:
        print("Target found at index: ", index)
    else:
        print("Target not found in list")

arr = [10, 33, 80, 30, 60, 50, 110, 100, 130, 170]

result = linearSearch(arr, 60)
verify(result)