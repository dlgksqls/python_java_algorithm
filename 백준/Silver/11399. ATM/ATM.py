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