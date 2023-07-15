def solution(l, r):
    answer = []
    
    for i in range(l,r+1):
        s = str(i)
        bol = True
        
        for char in s:
            if char not in ['0','5']:
                bol = False
                break
        if bol:
            answer.append(i)
            
    if len(answer) == 0:
        answer.append(-1)
        
    return answer

result = solution(5,555)
print(result)