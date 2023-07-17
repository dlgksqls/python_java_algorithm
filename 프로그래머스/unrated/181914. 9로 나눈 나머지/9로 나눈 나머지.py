def solution(number):
    answer = 0
    sum = 0
    for i in range(len(number)):
        sum = sum + int(number[i])
    answer = sum % 9
    return answer