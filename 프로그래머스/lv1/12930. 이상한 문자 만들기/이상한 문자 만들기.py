def solution(s):
    answer = []
    result = []
    result_str = ''
    
    words = s.split(' ')
    
    for word in words:
        result_str = ''
        for i in range(len(word)):
            if i%2==0:
                result_str += word[i].upper()
            elif i%2!=0:
                result_str += word[i].lower()
        result.append(result_str)
                
    return ' '.join(result)