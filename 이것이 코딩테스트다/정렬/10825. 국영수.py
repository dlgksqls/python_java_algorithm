import sys

n = int(input())

data = [list(sys.stdin.readline().split()) for _ in range(n)]

# 첫번째 요소가 같으면 두번째 요소 기준으로
# 두 번째 요소가 같으면 세번째 요소 기준으로 .. 이렇게 계속....

data.sort(key = lambda x: (-int(x[1]), int(x[2]), -int(x[3]), x[0]))

for i in data:
    print(i[0])