# dp[i][j] = dp[i-1][j-1] + dp[i][j-1]

import sys

dp = [[0 for _ in range(30)] for _ in range(30)]

t = int(sys.stdin.readline())
graph = []

for _ in range(t):
    data = list(map(int, sys.stdin.readline().split()))
    graph.append(data)

for i in range(30):
    for j in range(30):
        if i == 1:
            dp[i][j] = j
        else:
            if i == j:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1]

for i, j in graph:
    print(dp[i][j])