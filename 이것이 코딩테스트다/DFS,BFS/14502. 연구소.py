## python 으로 하니 시간초과가 뜸... 다시 생각해보기.....

import sys
from collections import deque
import copy

n, m = map(int, sys.stdin.readline().split())

graph = []
answer = []

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(n):
    data = list(map(int, sys.stdin.readline().split()))
    graph.append(data)

def wall(count):
    if count == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                wall(count+1)
                graph[i][j] = 0

def bfs():
    queue = deque()

    test_map = copy.deepcopy(graph)
    # test_map = graph

    for i in range(n):
        for j in range(m):
            if test_map[i][j] == 2:
                queue.append((i ,j))

    while queue:
        v, w = queue.popleft()
        
        for i in range(4):
            nx = v + dx[i]
            ny = w + dy[i]

            if (0<=nx<n) and (0<=ny<m):
                if test_map[nx][ny] == 0:
                    test_map[nx][ny] = 2
                    queue.append((nx, ny))

    global result
    count = 0
    for i in range(n):
        for j in range(m):
            if test_map[i][j] == 0:
                count += 1

    result = max(result, count)


result = 0
wall(0)

print(result)

