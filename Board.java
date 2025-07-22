public class Board {
  private int[][] board = new int[3][3];
  private int winner = 0;
  private int moves = 0;

  public Board() {
    for (int column = 0; column < 3; column++) {
      for (int row = 0; row < 3; row++) {
        board[column][row] = 0;
      }
    }
  }

  public void update(int column, int row) {
    if (board[column][row] == 0) {
      board[column][row] = (moves % 2) + 1;
    }
    moves++;
  }

  public boolean gameOver() {

    for (int i = 0; i < 3; i++) {
      //Rows
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] > 0) {
        winner = board[i][0];
        return true;
      }

      //Columns
      if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] > 0) {
        winner = board[0][i];
        return true;
      }

      //Diagonals
      if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] > 0) {
        winner = board[0][0];
        return true;
      }
      if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] > 0) {
        winner = board[0][2];
        return true;
      }
    }

    if (moves >= 9) {
      return true;
    }
    
    return false;
  }

  public int getWinner() {
    return winner;
  }
  
  public int[][] getBoard() {
    return board;
  }

  public int getMoves() {
    return moves;
  }

  public void refresh() {
    for (int column = 0; column < 3; column++) {
      for (int row = 0; row < 3; row++) {
        board[column][row] = 0;
      }
    }
    winner = 0;
    moves = 0;
  }

  public void print() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.print("\n");
    }
    System.out.print("\n");
  }
}