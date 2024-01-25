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

# 촌수를 독립적으로 계산하기 위해 인수로 0을 보냄 몇번째 깊이에 들어왔는지?
dfs(x, 0)

if len(result) == 0:
    print(-1)
else:
    print(result[0]-1)

# import sys

# num = 0

# def dfs(start):
#     visited[start] = 1
#     global num
#     num += 1

#     if y == start:
#         result.append(num)
#     else:
#         for i in graph[start]:
#             if not visited[i]:
#                 dfs(i)


# n = int(input())
# x, y = map(int, input().split())
# m = int(input())
# result = []

# graph = [[] for _ in range(n+1)]
# visited = [0] * (n+1)

# for i in range(m):
#     a, b = map(int, sys.stdin.readline().split())
#     graph[a].append(b)
#     graph[b].append(a)

# # for i in range(n+1):
# #     graph[i].sort()

# dfs(x)

# if len(result) == 0:
#     print(-1)
# else:
#     print(result[0]-1)