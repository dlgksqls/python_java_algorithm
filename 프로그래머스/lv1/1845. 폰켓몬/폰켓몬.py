def solution(nums):
    answer = 0
    num = set(nums)
    result = list(num)
    
    for i in result:
        answer += 1
        if answer == len(nums)/2:
            break
    return answer