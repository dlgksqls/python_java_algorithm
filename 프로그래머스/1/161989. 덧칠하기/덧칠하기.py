def solution(n, m, section):
    answer = 0
    start = section[0]

    if m == 1:
        return len(section)
    else:
        for i in section:
            if i >= start + m:
                start = i
                answer += 1
        answer += 1

    return answer