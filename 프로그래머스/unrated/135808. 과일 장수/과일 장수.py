def solution(k, m, score):
    answer = 0
    count = 0
    result = []
    result_answer = []
    
    score.sort(reverse = True)
    
    for i in range(len(score)):
        if count == m-1:
            result.append(score[i])
            result_answer.append(result)
            result = []
            count = 0
        elif count < m-1:
            result.append(score[i])
            count += 1
    
    for j in range(len(result_answer)):
        answer += min(result_answer[j]) * m
        
    return answer