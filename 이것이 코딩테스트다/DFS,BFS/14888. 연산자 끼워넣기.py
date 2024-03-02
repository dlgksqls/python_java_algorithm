# 코드 다시보기... 계속 틀림.....

import sys
# from sys import setrecursionlimit
# setrecursionlimit(10**9)

n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))

add, sub, mul, div = map(int, sys.stdin.readline().split())

max_result = -1e9
min_result = 1e9

def dfs(i, result):
    global max_result, min_result, add, sub, mul, div

    if i == n:
        min_result = min(min_result, result)
        max_result = max(max_result, result)
    else:
        if add > 0:
            add -= 1
            dfs(i + 1, result + data[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i + 1, result - data[i])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(i + 1, result * data[i])
            mul += 1
        if div > 0:
            div -= 1
            dfs(i + 1, int(result / data[i]))
            div += 1

dfs(1, data[0])

print(max_result)
print(min_result)

