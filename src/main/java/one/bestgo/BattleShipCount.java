package one.bestgo;

// https://leetcode.com/problems/battleships-in-a-board
public class BattleShipCount {
  public int countBattleshipsBetterOne(char[][] board) {
    int numShips = 0;
    for(int x=0; x<board.length; x++) {
      for(int y=0; y<board[x].length; y++) {
        if(board[x][y] == '.') continue;

        // now 'X' case, not all cases counted
        if(y>0 && board[x][y-1] == 'X') continue;
        if(x>0 && board[x-1][y] == 'X') continue;
        numShips++;
      }
    }
    return numShips;
  }
    public int countBattleships(char[][] board) {
    int numShips = 0;

    for(int x=0; x<board.length; x++) {
      for(int y=0; y<board[x].length; y++) {
        if(board[x][y] == 'X') {
          numShips++;
          sink(board, x, y);
        }
      }
    }
    return numShips;
  }

  private void sink(char[][] board, int x, int y) {
    if(x<0 || y<0 || x>=board.length || y>=board[x].length
        || board[x][y] == '.') return; // *** board[x][y] == '.'

    board[x][y] = '.';
    sink(board, x-1, y);
    sink(board, x+1, y);
    sink(board, x, y-1);
    sink(board, x, y+1);
  }
}