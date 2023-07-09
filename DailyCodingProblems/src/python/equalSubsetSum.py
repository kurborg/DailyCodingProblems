'''
Equal subset sum partition

Problem statement: Given a set of positive numbers, 
find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
'''

def equalSubsetSum(inputSet):
    # O(2**n) time complexity
    # O(2**n) space complexity   
    dp = {} # = (sum, index) = True|False
    targetSum = 0
    for n in inputSet:
        targetSum += n
    targetSum = targetSum / 2
    print(targetSum)

    def dfs(sum, index, dp):
        if sum == targetSum and index >= len(inputSet):
            return True
        elif (sum, index) in dp:
            return dp[(sum, index)]
        elif index >= len(inputSet):
            return False
        dp[(sum, index)] = dfs(sum+inputSet[index], index+1, dp) or dfs(sum, index+1, dp)
        return dp[(sum, index)]

    return dfs(0, 0, dp)

def equalSubsetUsingSet(inputSet):
        # If the number is a floating decimal then just immediately return False
        if sum(inputSet) % 2:
            return False
        # Create a new dp set and add 0 since 0 is the first choice
        dp = set()
        dp.add(0)
        # Find the target sum we want to achieve
        target = sum(inputSet) // 2
        # Loop through entire input set and add it to initial dp set of {0}
        # Then continue to loop through adding every value in input set to every value from previous iterations
        # This is creating every single possible combination of sums in from the input set
        # Create a base case where if the target is in the dp list then return True
        # Also have to add num itself to copy of dp set since we are replacing the old dp set every iteration
        for i in range(len(inputSet) - 1, -1, -1):
            nextDP = set()
            for num in dp:
                if num == target:
                    return True
                nextDP.add(num + inputSet[i])
                nextDP.add(num)
            dp = nextDP
        return True if target in dp else False


inputSet = [1, 5, 11, 5]
inputSet2 = [1, 2, 3, 5]
# print(equalSubsetSum(inputSet))
# print(equalSubsetSum(inputSet2))

print(equalSubsetUsingSet(inputSet))
print(equalSubsetUsingSet(inputSet2))