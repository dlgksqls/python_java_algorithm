def solution(num_list):
    answer = 0
    sum_odd = 0 #홀
    sum_even = 0 #짝
    
    for i in range(len(num_list)):
        if i % 2 == 0:
            sum_odd += num_list[i]
        else:
            sum_even += num_list[i]
            
    if sum_even < sum_odd:
        return sum_odd
    elif sum_even > sum_odd:
        return sum_even
    elif sum_even == sum_odd:
        return sum_even

    return sum_even