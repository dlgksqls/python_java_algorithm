import math

def solution(number, limit, power):
    answer = 1
    answer_list = []
    sosu = 0
    num_list = []
    answer_list.append(answer)
    
    for i in range(2,number+1):
        num_list.append(i)
    
    for i in num_list:
        sosu = 0
        for j in range(1,int(math.sqrt(i)+1)):
            if i % j == 0:
                sosu += 1
                if j ** 2 != i:
                    sosu += 1

        if sosu > limit:
            answer += power
        else:
            answer += sosu
            
    return answer