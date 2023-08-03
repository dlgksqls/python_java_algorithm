def solution(s):
    answer = ''
    alpha_list = []
    for i in range(len(s)):
        if s[i].isalpha():
            alpha_list.append(s[i])
        else:
            answer+=s[i]
        if alpha_list != []:
            alpha = ''.join(alpha_list)
            if alpha == 'zero':
                answer+='0' 
                alpha_list = []
            elif alpha == 'one': 
                answer+='1' 
                alpha_list = []
            elif alpha == 'two': 
                answer+='2' 
                alpha_list = []
            elif alpha == 'three': 
                answer+='3' 
                alpha_list = []
            elif alpha == 'four': 
                answer+='4' 
                alpha_list = []
            elif alpha == 'five': 
                answer+='5' 
                alpha_list = []
            elif alpha == 'six': 
                answer+='6' 
                alpha_list = []
            elif alpha == 'seven': 
                answer+='7'
                alpha_list = []
            elif alpha == 'eight': 
                answer+='8' 
                alpha_list = []
            elif alpha == 'nine': 
                answer+='9' 
                alpha_list = []
            else: 
                pass 
            
    return int(answer)