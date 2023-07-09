

def stringNumberValid(str):
    if str is None:
        return False
    
    for c in str:
        if (c < '0' or c > '9') and c != '.':
            return False
        
    return True


print(stringNumberValid("asdfbdsf"))
print(stringNumberValid("12393"))
print(stringNumberValid("12e393"))
print(stringNumberValid("12.93"))
