def solution(intStrs, k, s, l):
    answer = []
    for i in intStrs:
        result = ''
        for j in range(s,s+l):
            result = result + i[j]
        if int(result)>k:
            answer.append(int(result))
    return answer
