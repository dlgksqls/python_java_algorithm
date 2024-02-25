array = [0] * 100

array[1] = 1
array[2] = 2

for i in range(3, 100):
    array[i] = array[i-1] + array[i-2]

print(array[99])