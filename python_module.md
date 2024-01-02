<h2>Combination 모듈</h2>
<code>
def solution (number) :
    from itertools import combinations
    cnt = 0
    for i in combinations(number,3) :
        if sum(i) == 0 :
            cnt += 1
    return cnt
</code>

<h2>sys</h2>
반복문으로 여러줄을 받아야 할 때input()을 사용하면 시간초과가 뜰 수 있음<br>
<code>import sys
sys.stdin.readline()
</code><br>
사용할것!!<br>
사용 예시<br> 
<code>
import sys
input = sys.stdin.readline
</code><br>
-----------------------------------------------------------------<br>
<code>
import sys

T = int(input()) #Test case
for i in range(T):
        a,b = map(int, sys.stdin.readline().split())
        print(a+b)
</code>

<h2>루트</h2>
<code>
import math
int(math.sqrt(4)) => 2
</code>
소수 구하는데 사용 (프로그래머스 12921)
<code>
import math
def solution(n):
    answer = 0

    if n >= 2:
        answer += 1
        
    for i in range(3,n+1):
        count = 0
        for j in range(2,int(math.sqrt(i)+1)):
            if i % j == 0:
                count += 1
                break
            
        if count == 0:        
          answer += 1
          count = 0

    return answer
</code>
