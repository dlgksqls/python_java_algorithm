def solution(num_list, n):
    answer = []
    i = 0
    while True:
        if i+1 >= n:
            answer.append(num_list[i])
        i += 1
            
        if i == len(num_list):
            break
    return answer