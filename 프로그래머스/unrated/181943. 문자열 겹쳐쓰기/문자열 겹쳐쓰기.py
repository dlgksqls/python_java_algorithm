def solution(my_string, overwrite_string, s):
    answer = ''
    len_over = len(overwrite_string)
    answer = my_string[:s]+overwrite_string+my_string[s+len_over:]
    return answer
