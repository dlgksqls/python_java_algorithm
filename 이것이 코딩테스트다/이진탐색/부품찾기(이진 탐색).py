import sys

## 이진탐색 함수
def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2

        if array[mid] == target:
            return True
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False

# 가게에 있는 부품 목록
n = int(sys.stdin.readline())
home = list(map(int, sys.stdin.readline().split()))
# 정렬을 해야 이진탐색 수행이 가능하므로 정렬
home.sort()

# 고객이 요청하는 부품 목록
m = int(sys.stdin.readline())
req = list(map(int, sys.stdin.readline().split()))

# 고객의 요청 목록 하나씩 가져와서 이진탐색
for i in req:
    if not binary_search(home, i, 0, len(home)):
        print("no", end=' ')
    else:
        print("yes", end=' ')