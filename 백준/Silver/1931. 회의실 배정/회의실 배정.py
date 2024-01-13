import sys

n = int(input())

end_time = 0
answer = 0
meetings = []

for i in range(n):
    meet_start, meet_end = map(int, sys.stdin.readline().rstrip().split())
    meetings.append([meet_start, meet_end])

meetings.sort(key=lambda x: (x[1], x[0]))

for start, end in meetings:
    if end_time <= start:
        answer += 1
        end_time = end

print(answer)