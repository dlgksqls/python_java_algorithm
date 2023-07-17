def solution(my_string, queries):
    answer = ''
    my_string_list = list(my_string)
    for i, j in queries:
        for z in range(i,j):
            my_string_list[z], my_string_list[j] = my_string_list[j], my_string_list[z]
            j = j - 1
            if z == j or z + 1 == j:
                break
    answer=''.join(my_string_list)
    return answer