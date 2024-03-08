import sys

array = [0] * 1000001

# 가게에 있는 부품 목록
n = int(sys.stdin.readline())
home = list(map(int, sys.stdin.readline().split()))

# 고객이 요청하는 부품 목록
m = int(sys.stdin.readline())
req = list(map(int, sys.stdin.readline().split()))

for i in home:
    array[i] = 1

for i in req:
    if array[i] == 1:
        print("yes", end=" ")
    else:
        print("no", end=" ")