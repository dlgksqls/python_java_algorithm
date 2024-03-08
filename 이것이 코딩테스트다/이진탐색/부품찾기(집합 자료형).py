import sys

# 가게에 있는 부품 목록
n = int(sys.stdin.readline())

home = set(map(int, sys.stdin.readline().split())) # set은 해시테이블을 사용하므로 더 빠름 
# home = list(map(int, sys.stdin.readline().split())) # 리스트는 요소를 하나씩 조사하므로 느림 하지만 중복 허용

# 고객이 요청하는 부품 목록
m = int(sys.stdin.readline())
req = list(map(int, sys.stdin.readline().split()))

for i in req:
    if i in home:
        print("yes", end= ' ')
    else:
        print("no", end=' ')