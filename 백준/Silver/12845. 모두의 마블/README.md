# [Silver III] 모두의 마블 - 12845 

[문제 링크](https://www.acmicpc.net/problem/12845) 

### 성능 요약

메모리: 14680 KB, 시간: 108 ms

### 분류

그리디 알고리즘

### 제출 일자

2025년 6월 20일 16:16:32

### 문제 설명

<p>영관이는 게임을 좋아한다. 별의별 게임을 다 하지만 그 중에서 제일 좋아하는 게임은 모두의 마블이다. 어김없이 오늘도 영관이는 학교 가는 버스에서 캐릭터 합성 이벤트를 참여했다.</p>

<p>이번 이벤트는 다음과 같다. 순서가 매겨진 여러 장의 카드가 있다. 각각의 카드는 저마다 레벨이 있다.</p>

<p>카드 A에 카드 B를 덧붙일 수 있다. 이때 붙이는 조건은 다음과 같다.</p>

<ol>
	<li>두 카드는 인접한 카드여야 한다.</li>
	<li>업그레이드 된 카드 A의 레벨은 변하지 않는다.</li>
</ol>

<p>카드 합성을 할 때마다 두 카드 레벨의 합만큼 골드를 받는다.</p>

<p>영관이가 골드를 최대한 많이 받을 수 있게 여러분이 도와주자.</p>

<p>예를 들어, c1, c2, c3로 연속된 카드 3개가 있고 각각 레벨이 40,30,30 이라고 하자.</p>

<p>이 카드들을 합치는 과정에서, 먼저 c3에 c2를 합쳐 임시 카드 x1을 만든다. x1의 레벨은 30이고 획득 골드는 60이다. 그 다음엔 c1에 x1을 합쳐 카드 x2를 만들면 레벨이 40이고 70만큼의 골드를 획득할 수 있다. 이때, 영관이가 획득한 골드는 70+60 = 130이다.</p>

<p>다른 방법으로 c1에 c2를 덧붙인 카드 x1을 만들면, x1의 레벨은 40이고 획득한 골드는 70이다.</p>

<p>x1에 c3를 덧붙인 카드 x2의 레벨은 40이고 획득 골드는 70이다. 이때, 영관이가 획득한 골드는 70 + 70 = 140이다. 이외에 더 많은 골드를 받는 방법이 없으므로 140이 획득할 수 있는 최대 골드이다.</p>

### 입력 

 <p>카드의 개수 n(1 ≤ n ≤ 1,000)이 주어진다.</p>

<p>다음 줄에 각각 카드의 레벨 L<sub>i</sub>가 순서대로 주어진다. (0 < L<sub>i</sub> ≤ 100,000)</p>

### 출력 

 <p>영관이가 받을 수 있는 골드의 최댓값을 출력한다.</p>

