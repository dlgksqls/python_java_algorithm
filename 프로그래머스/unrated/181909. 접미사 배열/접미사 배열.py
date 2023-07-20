def solution(my_string):
    answer = []
    for i in range(len(my_string)):
        word = ''
        word = word + my_string[i:]
        answer.append(word)
        answer.sort()
            
    return answer