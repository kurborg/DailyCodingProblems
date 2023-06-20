def longestSubStringNoRepeatingChars(inputStr):
    hashSet = set()
    left = right = 0
    res = 0

    # for right in range(len(inputStr)):
    #     print(right)
    #     if inputStr[right] in hashSet: 
    #         hashSet.remove(inputStr[left]) 
    #         left += 1
    #     hashSet.add(inputStr[right])
    #     res = max(res, right - left + 1)

    while right < len(inputStr):
        # print(right)
        if inputStr[right] in hashSet: 
            hashSet.remove(inputStr[right]) 
            left += 1
        hashSet.add(inputStr[right])
        res = max(res, right - left + 1)
        right += 1

    return res

str = "abcabcbb"

print(longestSubStringNoRepeatingChars(str))