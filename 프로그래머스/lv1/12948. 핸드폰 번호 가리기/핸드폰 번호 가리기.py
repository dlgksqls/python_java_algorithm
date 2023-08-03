def solution(phone_number):
    answer = ''
    phone_number = list(phone_number)
    for i in range(len(phone_number)-4):
        phone_number[i] = '*'
    phone_number=''.join(phone_number)
    
    return phone_number