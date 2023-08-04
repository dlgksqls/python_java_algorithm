def solution(t, p):
    answer = 0
    
    for i in range(len(t)):
        num = ''
        for j in range(len(p)):
            if i+j == len(t):
                break
            num += t[i+j]
        if i+j == len(t):
            break
        if int(num) <= int(p):
            answer+=1
    return answer