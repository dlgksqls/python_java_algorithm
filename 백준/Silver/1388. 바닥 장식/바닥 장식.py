import sys
sys.setrecursionlimit(10**9)


def dfs(x, y):
    cur = graph[x][y]
    graph[x][y] = 0
    if cur == '-':
        if y+1<m:
            if graph[x][y+1] == '-':
                dfs(x, y+1)
    elif cur == '|':
        if x+1<n:
            if graph[x+1][y] == '|':
                dfs(x+1, y)
            


n, m = map(int, sys.stdin.readline().split())

graph = []

answer = 0

for _ in range(n):
    graph.append(list(sys.stdin.readline().rstrip()))

for a in range(n):
    for b in range(m):
        if graph[a][b] != 0:
            answer += 1
            dfs(a, b)

print(answer)
