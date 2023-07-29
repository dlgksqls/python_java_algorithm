def solution(str_list):
    answer = []
    
    if 'l' not in str_list and 'r' not in str_list:
        return []
    elif 'l' not in str_list:
        answer.extend(str_list[str_list.index('r')+1:])
    elif 'r' not in str_list:
        answer.extend(str_list[:str_list.index('l')])
    elif str_list.index('l') < str_list.index('r'):
        answer.extend(str_list[:str_list.index('l')])
    elif str_list.index('l') > str_list.index('r'):
        answer.extend(str_list[str_list.index('r')+1:])
    return answer