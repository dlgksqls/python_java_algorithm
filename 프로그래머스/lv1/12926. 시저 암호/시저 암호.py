def solution(s, n):
    answer = ''
    
    for i in s:
        i = ord(i)
        
        if i == 32:
            pass
        elif i < ord('a'):
            i += n
            if i > ord('Z'):
                i = i - 26
        
        elif i >= ord('a'):
            i += n
            if i > ord('z'):
                i = i - 26
            
        answer += chr(i)
    return answer