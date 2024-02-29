n = int(input())
rank = sorted([int(input()) for _ in range(n)])

answer = 0
for i in range(n):
    answer += abs(rank[i]-(i+1))

print(answer)