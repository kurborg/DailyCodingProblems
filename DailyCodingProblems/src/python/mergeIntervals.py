
def mergeIntervals(arr):
    res = []
    for i in arr:
        if not res or res[-1][1] <= i[0]:
            res.append(i)
        else:
            res[-1][1] = max(res[-1][1], i[1])

    return res

intervals = [[1,3],[2,6],[8,10],[15,18]]
print(mergeIntervals(intervals))