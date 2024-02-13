import sys
from collections import deque

answer = False


# 오른쪽, 아래
def bfs(x, y):
    global answer
    queue = deque([(x, y)])

    while queue:
        v, w = queue.popleft()
        cur = graph[v][w]

        if graph[v][w] == -1:
            answer = True
            return

        # 오른쪽, 아래
        dx = [0, cur]
        dy = [cur, 0]

        for i in range(2):
            nx = v + dx[i]
            ny = w + dy[i]

            if (0 <= nx < n) and (0 <= ny < n):
                if not vistied[nx][ny]:
                    queue.append((nx, ny))
                    vistied[nx][ny] = True


n = int(sys.stdin.readline())

graph = []
visited = []

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

vistied = [[False for _ in range(n)] for _ in range(n)]

bfs(0, 0)

if answer:
    print("HaruHaru")
else:
    print("Hing")
