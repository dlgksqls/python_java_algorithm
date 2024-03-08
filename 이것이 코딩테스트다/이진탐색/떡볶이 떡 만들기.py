import sys

# 입력
n, m = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))

# 시작점과 끝 점 설정 (리스트 길이를 보는게 아니라 요소 기준으로 탐색하므로 정렬 안해줘도 됨)
start = 0
end = max(data)
result = 0

# 이진 탐색
while start <= end:
    total = 0
    # 절단기 길이 세팅
    mid = (start + end) // 2

    # data에서 하나씩 꺼내와서
    for i in data:
        # 절단기 보다 길다면 자르기
        if i > mid:
            # 자른 결과값 더해주기
            total += i - mid

    # 덜 잘렸으면 중단값 낮춰줘서 더 잘라주기
    if total < m:
        end = mid - 1
    # 충분히 잘렸으면 결과 저장하고, 최적의 값 나올때까지 덜 잘라주기
    else:
        result = mid
        start = mid + 1

print(result)