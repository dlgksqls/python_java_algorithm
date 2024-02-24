import sys

def binary_search(array, target, start, end):
    result = 0
    while start <= end:
        total = 0
        mid = (start + end) // 2

        for i in array:
            if mid < i:
                total += i - mid
        if total < target:
            end = mid - 1
        else:
            result = mid
            start = mid + 1
    return result

n, m = map(int, sys.stdin.readline().split())
array = list(map(int, sys.stdin.readline().split()))

answer = binary_search(array, m, 0, max(array))

print(answer)