def solution(arr):
    answer = []
    arr.remove(min(arr))
    if arr == []:
        answer.append(-1)
    else:
        answer.extend(arr)
    return answer