s = int(input())

students_list = []
for i in range(s):
    student = input().split()
    students_list.append([student[0],int(student[1]),int(student[2]),int(student[3])])

students_list.sort(key = lambda x:x[0])
students_list.sort(key = lambda x:x[3], reverse=True)
students_list.sort(key = lambda x:x[2])
students_list.sort(key = lambda x:x[1], reverse=True)

for i in students_list:
    print(i[0])
