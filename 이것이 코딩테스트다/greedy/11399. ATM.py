import sys

n = sys.stdin.readline()

answer = 0
time_prv = 0

times = list(map(int, sys.stdin.readline().split()))

times.sort()

for i in range(len(times)):
    if i == 0:
        answer += times[i]
        time_prv = times[i]
        continue
    answer += times[i] + time_prv
    time_prv += times[i]

print(answer)

# 효율적 답안

# N = int(input())
# P = list(map(int, input().split()))

# P.sort()

# answer = 0
# for i in range(1, N+1):
#     answer += sum(P[:i])

# print(answer)
