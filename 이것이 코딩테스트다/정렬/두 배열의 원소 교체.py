n, k = map(int ,input().split())

ans_1 = list(map(int, input().split()))
ans_2 = list(map(int, input().split()))

ans_1.sort()
ans_2.sort(reverse=True)

for i in range(k):
    ans_1[i], ans_2[i] = ans_2[i], ans_1[i]

print(sum(ans_1))