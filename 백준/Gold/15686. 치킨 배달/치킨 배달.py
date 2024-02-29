from itertools import combinations

n, m = map(int, input().split())
graph = []

def distance(combi):
    result = 0
    for hx, hy in house:
        temp = 1e9
        for cx, cy in combi:
            temp = min(temp, abs(hx - cx) + abs(hy - cy))
        result += temp

    return result

for i in range(0, n):
    data = list(map(int, input().split()))
    graph.append(data)

house = []
chicken = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            house.append((i, j))
        elif graph[i][j] == 2:
            chicken.append((i, j))

combis = combinations(chicken, m)

result = 1e9

for combi in combis:
    result = min(result, distance(combi))

print(result)