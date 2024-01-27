import sys
sys.setrecursionlimit(10**9)

answer = False

def dfs(x, y):
    global answer

    if x == m-1:
        answer = True
        return True
    
    # 상하좌우
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    graph[x][y] = 2

    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y

        if (0<=nx<m) and (0<=ny<n):
            if graph[nx][ny] == 0:
                dfs(nx, ny)
        

m, n = map(int, sys.stdin.readline().split())

graph = []

for i in range(m):
    graph.append(list(map(int,sys.stdin.readline().rstrip())))

for i in range(n):
    if graph[0][i] == 0:
        dfs(0, i)
        if answer:
            print("YES")
            break
if not answer:
    print("NO")