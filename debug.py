s = input()

students_list = []
for i in range(int(s)):
    student = input().split()
    students_list.append([student[0],int(student[1]),int(student[2]),int(student[3])])
    print(students_list)