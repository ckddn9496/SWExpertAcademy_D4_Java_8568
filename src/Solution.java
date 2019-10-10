import java.util.Scanner;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
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
	}

}