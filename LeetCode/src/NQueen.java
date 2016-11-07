/*
 * 51. N-Queens
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
	public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> result = new ArrayList<List<String>>();
        for(int i = 0 ; i < n ; i++) 
            Arrays.fill(board[i],'.');
        solveNQueens(board,0,n, result);
        return result;
    }
    
    public void solveNQueens(char[][] board, int start, int end, List<List<String>> result) {
        
        if(start == end) {
            List<String> list = new ArrayList<String>();
            for(int i = 0 ; i < end ; i++) {
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
            
        }
        if(start < end) {
            for(int i = 0 ; i < end ; i++) {
                if(!check(board,i,start, end)) {
                    continue;
                }
                board[i][start] = 'Q';
                solveNQueens(board,start+1,end,result);
                board[i][start] = '.';
            }
        }
        
        return;
        
    }
    
    
    public boolean check(char[][] board, int i, int j, int end) {
        for(int k = j-1 ;  k >= 0 ; k--) {
            if(board[i][k] == 'Q') {
                return false;
            }
        }
        for(int k = j-1,l = i-1 ;  k >= 0 && l >= 0 ; k--, l--) {
            if(board[l][k] == 'Q') {
                return false;
            }
        }
        
        for(int k = j-1,l = i+1 ;  k >= 0 && l < end ; k--, l++) {
            if(board[l][k] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
