package BackTracking;

public class Sudoku {
//   numbers in each row, col and four corner subgrids of sqrt(n) * sqrt(n)
//	length should be different
	final static int N = 4;
	static int grid[][] = new int[N][N];

	public static boolean isSafe(int i, int j, int num) {
//		for col check
		for (int k = 0; k < N; k++) {
			if (grid[k][j] == num || grid[i][k] == num) {
				return false;
			}
		}
//		for (int col = 0; col < N; col++) {
//			if (grid[i][col] == num) {
//				return false;
//			}
//		}
		int sqrt = (int) Math.sqrt(N);
		int sr = i - i % sqrt;
		int sc = j - j % sqrt;
		for (int row = 0; row < sr; row++) {
			for (int col = 0; col < sc; col++) {
				if (grid[row + sr][col + sc] == num) {
					return false;
				}
			}
		}
		return true;
	}

//Time complexity : O(N^(N*N)) and space complexity or auxiliary space: O(N*N)
	public static boolean solve() {
		int row = -1, col = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 0) {
					row = i;
					col = j;
					break;
				}
			}
		}
		if (row == -1 && col == -1) {
			return true;
		}
		for (int n = 1; n <= N; n++) {
			if (isSafe(row, col, n)) {
				grid[row][col] = n;
				if (solve()) {
					return true;
				}
				grid[row][col] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();
		for (int i[] : grid) {
			for (int k : i) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
//	-----------------------------------
//	public static boolean isSafe(int[][] board,int row, int col, int num) 
//    { 
//     
//        for (int d = 0; d < board.length; d++)  
//        { 
//            
//            if (board[row][d] == num) { 
//                return false; 
//            } 
//        } 
//  
//        for (int r = 0; r < board.length; r++)  
//        { 
//               
//            if (board[r][col] == num)  
//            { 
//                return false; 
//            } 
//        }  
//        int sqrt = (int)Math.sqrt(board.length); 
//        int boxRowStart = row - row % sqrt; 
//        int boxColStart = col - col % sqrt; 
//  
//        for (int r = boxRowStart; 
//             r < boxRowStart + sqrt; r++)  
//        { 
//            for (int d = boxColStart; 
//                 d < boxColStart + sqrt; d++)  
//            { 
//                if (board[r][d] == num)  
//                { 
//                    return false; 
//                } 
//            } 
//        } 
//  
//        return true; 
//    } 
//  
//    public static boolean solveSudoku( 
//        int[][] board, int n) 
//    { 
//        int row = -1; 
//        int col = -1; 
//        boolean isEmpty = true; 
//        for (int i = 0; i < n; i++)  
//        { 
//            for (int j = 0; j < n; j++)  
//            { 
//                if (board[i][j] == 0)  
//                { 
//                    row = i; 
//                    col = j; 
//                    isEmpty = false; 
//                    break; 
//                } 
//            } 
//            if (!isEmpty) { 
//                break; 
//            } 
//        } 
//  
//        if (isEmpty)  
//        { 
//            return true; 
//        } 
//        
//        for (int num = 1; num <= n; num++)  
//        { 
//            if (isSafe(board, row, col, num))  
//            { 
//                board[row][col] = num; 
//                if (solveSudoku(board, n))  
//                { 
//                    // print(board, n); 
//                    return true; 
//                } 
//                else 
//                { 
//                    // replace it 
//                    board[row][col] = 0; 
//                } 
//            } 
//        } 
//        return false; 
//    } 
//  
//    public static void print(int[][] board, int N) 
//    { 
//        for (int r = 0; r < N; r++)  
//        { 
//            for (int d = 0; d < N; d++) 
//            { 
//                System.out.print(board[r][d]); 
//                System.out.print(" "); 
//            } 
//            System.out.print("\n"); 
//  
//            if ((r + 1) % (int)Math.sqrt(N) == 0) 
//            { 
//                System.out.print(""); 
//            } 
//        } 
//    } 
//  
//    public static void main(String args[]) 
//    { 
//  
//        int[][] board = new int[][] { 
//            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
//            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
//            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
//            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
//            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
//            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
//            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
//            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
//            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
//        }; 
//        int N = board.length; 
//  
//        if (solveSudoku(board, N))  
//        {  
//            print(board, N); 
//        } 
//        else { 
//            System.out.println("No solution"); 
//        } 
//    } 

}
