def solution(my_string, s, e):
    answer = ''
    j = 0 
    my_string = list(my_string)
    for i in range(s,e):
        if i != (i+(e-j))//2+1:
            my_string[i], my_string[e-j] = my_string[e-j], my_string[i]
            j += 1
        else:
            break
    answer = answer + ''.join(my_string)
    return answer