def solution(sizes):
    answer = 1
    min_num = []
    max_num = []
    
    for i in range(len(sizes)):
        min_num.append(min(sizes[i]))
        max_num.append(max(sizes[i]))
    
    answer = max(min_num) * max(max_num)
    return answer