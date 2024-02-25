import sys
from bisect import bisect_left, bisect_right

# bisect을 사용하여 x가 있는 왼쪽 그리고 오른쪽에서 몇번째 위치에 있는지 체크
def count_by_range(array, left, right): 
        right_index = bisect_right(array, right)
        left_index = bisect_left(array, left)

        return right_index - left_index 

n, x = map(int, sys.stdin.readline().split())

array = list(map(int, sys.stdin.readline().split()))

result = count_by_range(array, x, x)

if result == 0:
    print(-1)
else:
    print(result)