def solution(food):
    answer_1 = ''
    answer_2 = []
    
    for i in range(1,len(food)):
        for j in range(food[i] // 2):
            answer_1 += str(i)
            
    answer_2 = list(answer_1)
    answer_1 += str(0)
    answer_2.sort(reverse = True)
    answer_2 = ''.join(answer_2)
    
    answer_1 += answer_2
    
    return answer_1