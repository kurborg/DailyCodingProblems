"""
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
"""

# This is O(n) time complexity
def searchRange(self, nums, target):
        # Have to record both if num then also first starting position
        for i,n in enumerate(nums):
            if n == target:
                starting = ending = i
                i+=1
                while i < len(nums) and nums[i] == target:
                    ending += 1
                    i += 1
                return [starting,ending]
        
        return [-1,-1]

# This is O(log n) time complexity
def searchRangeLog(self, nums, target):
        # Have to record both if num then also first starting position
        
        # for i,n in enumerate(nums):
        #     if n == target:
        #         starting = ending = i
        #         i+=1
        #         while i < len(nums) and nums[i] == target:
        #             ending += 1
        #             i += 1
        #         return [starting,ending]
        
        # return [-1,-1]

        def search(x):
            lo, hi = 0, len(nums)           
            while lo < hi:
                mid = (lo + hi) // 2
                if nums[mid] < x:
                    lo = mid+1
                else:
                    hi = mid                    
            return lo
        
        # Test nums =[5,7,7,8,8,8,10] target =8 Output =[3,5]
        lo = search(target) # returns 3
        print(lo)
        hi = search(target+1)-1 # returns 6 - 1 = 5 
        print(hi)
        
        if lo <= hi:
            return [lo, hi]
                
        return [-1, -1]