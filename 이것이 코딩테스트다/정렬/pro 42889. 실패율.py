def solution(N, stages):
    answer = []
    length = len(stages)
    
    for i in range(1, N+1):
        count = stages.count(i)
        
        if length == 0:
            fail = 0
        else:
            fail = count / length
            
        answer.append((i, fail))
        length -= count
        
    # answer = sorted(answer, key = lambda x: x[1], reverse=True)
    answer.sort(key = lambda x: -x[1])
    answer = [i[0] for i in answer]
    
    return answer

print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))