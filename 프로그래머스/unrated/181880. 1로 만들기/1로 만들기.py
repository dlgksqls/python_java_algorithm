def solution(num_list):
    answer = 0
    count = 0
    while True:
        for i in range(len(num_list)):
            if num_list[i] == 1:
                count += 1
            else:
                count = 0
                if num_list[i] % 2 == 0:
                    num_list[i] /= 2
                    answer += 1
                else:
                    num_list[i] = (num_list[i] - 1) / 2
                    answer += 1
            if count == len(num_list):
                return answer