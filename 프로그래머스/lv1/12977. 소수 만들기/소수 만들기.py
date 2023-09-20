def solution(nums):
    answer = 0
    result = []
    sum = 0
    
    for i in range(len(nums)):
        for j in range(i+1,len(nums)):
            for k in range(j+1,len(nums)):
                sum = nums[i] + nums[j] + nums[k]
                result.append(sum)

    for z in result:
        count = 0
        for x in range(2,z):
            if z % x != 0:
                count += 1
        if count == z-2:
            answer += 1
        
    
    return answer