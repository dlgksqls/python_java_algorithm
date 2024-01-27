import sys

sys.setrecursionlimit(1000000)

def dfs(x, y):
    #상하좌우
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    graph[x][y] = False

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if (0<=nx<n) and (0<=ny<m):
            if graph[nx][ny] ==True:
                #graph[nx][ny] = False
                dfs(nx, ny)

t = int(sys.stdin.readline())


for _ in range(t):
    count = 0 
    m, n, k = map(int, sys.stdin.readline().split())

    graph = [[False for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        a, b = map(int, sys.stdin.readline().split())
        graph[b][a] = True

    for i in range(n):
        for j in range(m):
            if graph[i][j] == True:
                count += 1
                dfs(i, j)

    print(count)
