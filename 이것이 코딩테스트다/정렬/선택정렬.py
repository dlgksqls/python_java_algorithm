array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_num = i
    for j in range(i+1, len(array)):
        if array[min_num] > array[j]:
            min_num = j
    array[i], array[min_num] = array[min_num], array[i]

array.sort()
print(array)