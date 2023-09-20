def solution(answers):
    answer = []
    
    first = [1,2,3,4,5]
    second = [2,1,2,3,2,4,2,5]
    third = [3,3,1,1,2,2,4,4,5,5]
    
    result = [0 for i in range(3)]
    
    for i in range(len(answers)):
        if answers[i] == first[i%len(first)]:
            result[0] += 1
        if answers[i] == second[i%len(second)]:
            result[1] += 1
        if answers[i] == third[i%len(third)]:
            result[2] += 1
    
    for j in range(len(result)):
        if max(result) == result[j]:
            answer.append(j+1)
    
    return answer