def generateParenthesis(n):
    # Dynamic Problem where you have conditionals
    # in a tree whether you can add new ( or add new )
    # If open < n then can add a new (
    # If closed < open then can add a new )
    # If open == closed == n then return

    stack = [] # use 1 global stack for recursive calls
    res = []

    # function is nested within function so can inherit all values and 
    # don't need to pass values in
    def recursiveGenerate(openN, closedN):

        print(stack)
        if openN == closedN == n:
            res.append("".join(stack))
            return

        if openN < n:
            stack.append("(")
            recursiveGenerate(openN+1, closedN)
            stack.pop() # Using global stack so have to clean up after each recursive call
        
        if closedN < openN:
            stack.append(")")
            recursiveGenerate(openN, closedN+1)
            stack.pop() # Using global stack so have to clean up after each recursive call
    
    recursiveGenerate(0,0)
    return res

res = generateParenthesis(3)
print(res)
print(len(res))