a = input()

sum = 0

for i in range(len(a)):
    key = int(a[i])
    
    if (sum == 1 or sum == 0) or (key == 0 or key == 1):
        sum = sum + key
    else:
        if i == 0:
            sum = key
        else:
            sum = sum*key
print(sum)