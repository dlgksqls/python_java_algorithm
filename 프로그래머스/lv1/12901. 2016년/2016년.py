def solution(a, b):
    answer = ''
    days = [31,29,31,30,31,30,31,31,30,31,30,31] # 달 별 일수
    DAY = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"] # 요일 1월 1일은 금요일 이므로...

        
    return DAY[(sum(days[:(a)-1])+b-1)%7]