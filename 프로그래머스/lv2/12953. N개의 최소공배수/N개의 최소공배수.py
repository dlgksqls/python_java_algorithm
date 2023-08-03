
from math import gcd # 최대공약수 

def solution(arr):
    for i in range(1, len(arr)):
        arr[i] = arr[i-1] * arr[i] // gcd(arr[i-1], arr[i]) # 최소공배수 = 두 수 // 최소공배수
    return arr[-1]