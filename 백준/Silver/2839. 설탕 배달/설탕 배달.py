import sys

dp = [5000 for _ in range(5001)]

dp[3] = 1
dp[5] = 1
n = int(sys.stdin.readline())

for i in range(6, n+1):
    if dp[i-3] != 5000 or dp[i-5] != 5000:
        dp[i] = min(dp[i-3], dp[i-5]) + 1

if dp[n] == 5000:
    print(-1)
else:
    print(dp[n])