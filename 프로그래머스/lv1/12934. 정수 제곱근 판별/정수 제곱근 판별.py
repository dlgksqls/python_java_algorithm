from math import sqrt

def solution(n):
    answer = 0
    n = sqrt(n)
    if '0' not in str(n)[len(str(n))-1:]:
        return -1
    else:
        return (n+1)**2