import sys

def count_by_value(array, target):
    left_count = left(array, target, 0, len(array)-1)
    if left_count == None:
        return 0
    
    right_count = right(array, target, 0, len(array)-1)

    return right_count - left_count + 1

def left(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2

    # target > array[mid-1] 를 하는 이유는 더 이상 왼쪽에 target보다 작은값이 없다는 걸 뜻함
    # 고로 array[mid]가 시작하는 순간
    if (mid == 0 or target > array[mid-1]) and array[mid] == target: 
        return mid
    elif array[mid] >= target:
        return left(array, target, start, mid-1)
    else:
        return left(array, target, mid+1, end)

def right(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2

    # target < array[mid+1] 를 하는 이유는 더 이상 오른쪽에 target보다 큰 값이 없다는 걸 뜻함
    # 고로 array[mid]가 끝나는 순간
    if (mid == n-1 or target < array[mid+1]) and array[mid] == target:
        return mid
    elif array[mid] > target:
        return right(array, target, start, mid-1)
    else:
        return right(array, target, mid+1, end)

n, x = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))

result = count_by_value(data, x)

if result == 0:
    print(-1)
else:
    print(result)