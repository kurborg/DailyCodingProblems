def longestSubstringKChars(inputStr, k):
    ans = 0
    left = right = 0
    chars = {}
    res = []

    while right < len(inputStr):
        chars[inputStr[right]] = chars.get(inputStr[right], 0) + 1

        if len(chars) <= k:
            ans = max(ans, right - left + 1)
            res = inputStr[left:right+1]
        else:
            while len(chars) > k:
                leftChar = inputStr[left]
                if chars[leftChar] == 1:
                    chars.pop(leftChar)
                else:
                    chars[leftChar] -= 1
                left +=1
        right += 1
    
    return ans, res

word = "kolkata"
print(longestSubstringKChars(word, 3))