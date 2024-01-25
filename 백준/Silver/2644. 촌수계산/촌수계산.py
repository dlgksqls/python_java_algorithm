import sys

num = 0

def dfs(start, num):
    visited[start] = 1
    #global num
    num += 1

    if y == start:
        result.append(num)
    else:
        for i in graph[start]:
            if not visited[i]:
                dfs(i, num)


n = int(input())
x, y = map(int, input().split())
m = int(input())
result = []

graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

# for i in range(n+1):
#     graph[i].sort()

dfs(x, 0)

if len(result) == 0:
    print(-1)
else:
    print(result[0]-1)
