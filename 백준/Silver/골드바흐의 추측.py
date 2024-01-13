n = int(input())
number = []

def is_prime(num):
    for i in range(2,num):
        if num % i == 0:
            return False
    return True
        


for i in range(n):
    m = int(input())
    number.append(m)

for j in number:
        reuslt_num = j // 2
        num_minus = reuslt_num
        num_plus = reuslt_num

        if is_prime(num_minus) and is_prime(num_plus):
            print(num_minus, num_plus)
        else:
            while True:
                if not is_prime(num_minus) or not is_prime(num_plus):
                    num_minus -= 1
                    num_plus += 1
                else:
                    print(num_minus, num_plus)
                    break