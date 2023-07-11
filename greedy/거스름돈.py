n = 1260 # 거스름돈
count = 0

coin = [500,100,50,10] #동전 종류
 
for i in coin:
    count += n//i
    n = n % i
print(count) #가장 적은 수의 동전 거스름돈