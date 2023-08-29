def solution(numbers):
    answer = []
    numbers.sort()
    
    for i in range(len(numbers)):
        for j in range(i+1,len(numbers)):
            sum = numbers[i] + numbers[j]
            if sum in answer:
                pass
            else:
                answer.append(sum) 
            answer.sort()
    return answer