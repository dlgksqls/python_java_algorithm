def solution(n, k):
    answer = []
    for i in range(n+1):
        if k*i <= n and k*i >= 1:
            answer.append(k*i)
    return answer