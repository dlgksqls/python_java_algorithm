import sys

# 입력
n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().split()))

# 고정점이 있는지 여부 체크를 위한 flag
flag = False

def binary_search(data, start, end):
    global flag

    if start > end:
        return None
    
    mid = (start+end) // 2

    # 리스트 인덱스가 값이랑 같다면 고정점이므로 flag를 True로 바꾸고 고정점 바로 리턴 (고정점이 최대 1개만 존재하기 때문)
    if data[mid] == mid:
        flag = True
        return mid
    elif data[mid] > mid:
        return binary_search(data, start, mid-1)
    else:
        return binary_search(data, mid + 1, end)

result = binary_search(data, 0, len(data))

# flag가 false라면 고정점이 없다는 뜻이므로 -1
if flag == False:
    print(-1)
else:
    print(result)