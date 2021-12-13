"""
In python the values aren't actually stored at the index, a 
pointer to the data is stored instead as the array doesn't know
the type of variable stored so it's inconsistent memory whereas
a pointer is constant memory

For Array:

Insert
Time Complexity: O(N) Linear Time because we have to shift all the elements 1
Space Complexity: O(1) Ammortized Constant Space Complexity because we only increase space at some points 

Append 
Time Complexity:  O(1) Constant Time because we are simply adding to the end of an array
Space Complexity: O(1) Ammortized Constant Space Complexity because we only increase space at some points 

Delete
Time Complexity: O(N) Linear time because we need to shift all the existing elements

"""

new_list = [1, 2, 3]

result = new_list[0]

if 1 in new_list: print(True)

for n in new_list:
    if n == 1:
        print(True)
    break