def solution(my_string):
    answer = []
    k = 0
    for i in range(52):
        answer.append(0)
        
    for i in range(len(my_string)):
        if my_string[i].isupper():
            k = 65
        else:
            k = 71
        answer[ord(my_string[i])-k] += 1
        
    return answer