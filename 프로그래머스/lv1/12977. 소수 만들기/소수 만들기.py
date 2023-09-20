def solution(nums):
    make_nums = []  # 가능한 모든 조합의 합을 저장할 리스트
    result = []     # 소수를 저장할 리스트
   
    # 가능한 모든 조합의 합을 구합니다.
    for i in range(len(nums)-2):
        for j in range(i+1, len(nums)-1):
            for k in range(j+1, len(nums)):
                make_nums.append(nums[i] + nums[j] + nums[k])
   
    # 가능한 조합의 합 중에서 소수인 것을 찾아서 result 리스트에 추가합니다.
    for i in make_nums:
       
        # i가 소수인지 검사합니다.
        # all은 모든 요소가 참이면 True를 반환, 하나라도 거짓이 있으면 False반환
        # i가 2~(i-1)까지 나머지가 있는지 확인합니다. 나머지가 다 있으면 모든 요소가 True이므로 참
        if all(i % j != 0 for j in range(2, i)):
            result.append(i)
   
    # 소수의 개수를 반환합니다.
    return len(result)