# SWExpertAcademy_D4__Java_8568

## SW Expert Academy D4 8568. 3으로 나눈 수열

### 1. 문제설명

출처: https://swexpertacademy.com/main/code/problem/problemList.do

input으로 순열의 갯수 `N`과 `N`개의 정수가 들어온다. `i`번째 숫자가 `a(i)`라 할때 값도 `i % 3 == a(i) % 3`으로 만드려 주려고한다. 이때 맞지않는 숫자들을 교환하며 순열을 맞춰가려고 할때 최소 교환횟수를 구하는 문제.

[입력]
> 첫 번째 줄에 테스트 케이스의 수 `T`가 주어진다.
> 각 테스트 케이스의 첫 번째 줄에는 하나의 정수 `N(3≤N≤999)`이 주어진다.
> `N`은 `3`의 배수이다.
> 두 번째 줄에는 `N`개의 정수 `p1, p2, …, pN (1≤pi≤N)`이 공백 하나로 구분되어 주어진다.
> `p`는 순열이다.

[출력]
> 각 테스트 케이스마다 `#x`(`x`는 테스트케이스 번호를 의미하며 `1`부터 시작한다)를 출력하고,
> 각 테스트 케이스마다 주어진 순열을 좋은 순열로 바꾸기 위해 필요한 두 수의 위치를 바꾸는 횟수의 최솟값을 출력한다.

### 2. 풀이

`3*3` 배열을 만들었다. `map[i][j]`에서 `i`는 `i % 3`번째임을 뜻하며 `j`는 `a(i) % 3`을 뜻한다. 즉, `(i,i)`에 있는 숫자는 교환할 필요없는 숫자들이며 이외의 숫자들은 교환을 통해 알맞은 자리로 가야만 한다. 이때 `(i,j)`와 `(j,i)`에 있는 값들은 서로 자신의 위치가 뒤바뀐 숫자들이며 이들은 한번의 교환으로 2개의 숫자를 원래의 자리로 돌릴 수 있다. 그렇기 때문에 `Math.min(map[i][j], map[j][i])` 값만큼 교환을 해주었다.

교환을 모두 하지못하여 남은 숫자들이 있을 수 있다. 이런 경우는 `0`, `1`, `2`의 위치가 순서대로 교차한 꼴이며 이런 경우 두번의 교환으로 원래의 자리로 되돌릴 수 있다. `Math.abs(map[i][j] - map[j][i])`의 값에 두배를 해주어 교환횟수를 추가하여 출력해었다.

```java

int N = Integer.parseInt(sc.nextLine());
  int[] num = new int[N];
  int[][] map = new int[3][3];

  StringTokenizer st = new StringTokenizer(sc.nextLine());
  for (int i = 0; i < N; i++) {
    num[i] = Integer.parseInt(st.nextToken()) % 3;
    int row = num[i] % 3 == 0 ? 2 : num[i] % 3 - 1;
    int col = (i+1) % 3 == 0 ? 2 : (i+1) % 3 - 1;
    map[row][col]++;
  }

  int count = 0;
  int idx = 0;
  int left = 0;
  for (int i = 0; i < 3; i++) {
    for (int j = i+1; j < 3; j++) {
      count += Math.min(map[i][j], map[j][i]);
      left = Math.abs(map[i][j] - map[j][i]);
    }
  }
  count += left*2;

  System.out.println("#"+test_case+" "+count);
}

```
