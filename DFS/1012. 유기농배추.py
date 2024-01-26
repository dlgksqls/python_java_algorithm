import sys 
sys.setrecursionlimit(1000000)

def dfs(x, y):
    dx = [0, -1, 0, 1]
    dy = [1, 0, -1, 0]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if (0<=nx<m) and (0<=ny<n):
            if graph[ny][nx] == 1:
                graph[ny][nx] = -1
                dfs(nx, ny)


t = int(sys.stdin.readline())

for _ in range(t):
    m,n,k = map(int,sys.stdin.readline().split())
    answer = []

    graph = [[0 for _ in range(m)] for _ in range(n)]

    for _ in range(k):
        x, y = map(int,sys.stdin.readline().split())
        graph[y][x] = 1

    count = 0
    for a in range(m):
        for b in range(n):
            if graph[b][a] == 1:
                dfs(a, b)
                count += 1

    print(count)