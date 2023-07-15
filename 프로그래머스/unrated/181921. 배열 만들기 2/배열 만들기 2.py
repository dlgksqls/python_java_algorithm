def solution(l, r):
    answer = []
    
    for i in range(l,r+1):
        bol = True
        s = str(i)

        for char in s:
            if char in ['0','5']:
                continue
            else:
                bol = False
                break
                
        if bol:        
            answer.append(i)
            
    if len(answer) == 0:
        answer.append(-1)
        
    return answer

