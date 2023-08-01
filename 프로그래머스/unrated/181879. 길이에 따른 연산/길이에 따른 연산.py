def solution(num_list):
    answer = 0
    sum = 0
    var = 1
    
    if len(num_list) > 10:
        for i in range(len(num_list)):
            sum += num_list[i]
        return sum
    elif len(num_list) <= 10:
        for j in range(len(num_list)):
            var *= num_list[j]
        return var