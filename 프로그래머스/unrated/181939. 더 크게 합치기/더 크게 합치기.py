def solution(a, b):
    answer = 0
    result_1 = str(a)+str(b)
    result_2 = str(b)+str(a)
    result_1 = int(result_1)
    result_2 = int(result_2)
    if result_1 > result_2:
        answer = result_1
    elif result_1 < result_2:
        answer = result_2
    elif result_1 == result_2:
        answer = result_1
    return answer