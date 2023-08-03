def solution(s):
    answer = True
    is_p = 0
    is_y = 0
    
    for i in range(len(s)):
        if s[i] == 'p' or s[i] == 'P':
            is_p += 1
        elif s[i] == 'y' or s[i] == 'Y':
            is_y += 1
    if is_p == is_y:
        return True
    elif is_p != is_y:
        return False

    return True