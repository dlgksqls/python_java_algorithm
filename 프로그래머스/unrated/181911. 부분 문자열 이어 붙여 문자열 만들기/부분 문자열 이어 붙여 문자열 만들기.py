def solution(my_strings, parts):
    answer = ''
    for i in range(len(parts)):
        s, e = parts[i]
        for j in range(s,e+1):
            answer = answer + my_strings[i][j]
    return answer