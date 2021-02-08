package one.bestgo.problems;

import java.util.*;


/*
## Scoring a Board Game

|   |   |   |   |   |
|---|---|---|---|---|
| x | x |   |   | x |
|   |   | x |   | x |
|   |   |   | x |   |
|   |   |   | x |   |

Each turn, the player is allowed to remove one piece that shares either a row or a column with another piece.
At the end of the game, the score of the board is how many pieces are left on the board

Your goal is to write an algorithm that finds the lowest score any given board can score.
The alogorithm does NOT need to tell you how to achieve the lowest score, jusr what the lowest score is.

Hint: Play through the example board manually. Think about how pieces are connected.
 */
public class SplunkTest {
  private static class Piece {
    int x;
    int y;

    Piece(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "("+x+","+y+")";
    }
  }

  public static void main(String [] args) {
    // you can write to stdout for debugging purposes, e.g.
    System.out.println("This is a debug message");

    Piece[] board = new Piece[]{
        new Piece(0, 0),
        new Piece(0, 1),
        new Piece(0, 4),
        new Piece(1, 2),
        new Piece(1, 4),
        new Piece(2, 3),
        new Piece(3, 3)
    };

    Map<Integer, List> xGroups = new HashMap<>() {
      {
        List<Piece> list = new ArrayList<>();
        list.add(board[0]);
        list.add(board[1]);
        list.add(board[2]);
        put(0, list);
        list = new ArrayList<>();
        list.add(board[3]);
        list.add(board[4]);
        put(1, list);
        list = new ArrayList<>();
        list.add(board[5]);
        put(2, list);
        list = new ArrayList<>();
        list.add(board[6]);
        put(3, list);
      }
    };
    Map<Integer, List> yGroups = new HashMap<>() {
      {
        List<Piece> list = new ArrayList<>();
        list.add(board[0]);
        put(0, list);
        list = new ArrayList<>();
        list.add(board[1]);
        put(1, list);
        list = new ArrayList<>();
        list.add(board[3]);
        put(2, list);
        list = new ArrayList<>();
        list.add(board[5]);
        list.add(board[6]);
        put(3, list);
        list = new ArrayList<>();
        list.add(board[2]);
        list.add(board[4]);
        put(4, list);
      }
    };

    List<Piece> remaining = new ArrayList<>();

    for(Piece one: board) {
      int x = one.x;
      int y = one.y;
      List<Piece> xgroup = xGroups.get(x);
      List<Piece> ygroup = yGroups.get(y);

      if(xgroup.size()>1) {
        //delete: remove the piece from both x/yGroups
        xgroup.remove(one);
        yGroups.get(y).remove(one);
      } else if(ygroup.size()>1) {
        //delete: remove the piece from both x/yGroups
        ygroup.remove(one);
        xGroups.get(x).remove(one);
      } else {
        remaining.add(one);
      }
    }
    System.out.println(remaining.size());
    for(Piece one: remaining) {
      System.out.println(one);
    }
  }

    /*
    Map<int, object> xGroups
    Map<int, object> yGroups
    List<object> allGroups

    for piece in board {
        check if xGroup exists
        if not, check if yGroup exists
        if not, new group
        put group into x and y
    }
    */
}
