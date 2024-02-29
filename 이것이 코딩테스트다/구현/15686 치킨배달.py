from itertools import combinations

n, m = map(int, input().split())
graph = []

# 지정된 치킨집과 일반 집 간의 최소 거리 계산
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

# 조합을 사용하여 치킨집 중 m개 빼내는 조합
combis = combinations(chicken, m)

result = 1e9

for combi in combis:
    result = min(result, distance(combi))

print(result)