package com.codurance;

public class Board {
  private static final int SIZE = 3;

  private Marker[][] board;

  public Board() {
    this.board = new Marker[][]{
        {new Marker(), new Marker(), new Marker()},
        {new Marker(), new Marker(), new Marker()},
        {new Marker(), new Marker(), new Marker()}
    };
  }

  public void add(int x, int y, Marker lastPlayer){
    board[x - 1][y - 1] = lastPlayer;
  }

  public boolean isEmpty(int x, int y) {
    return board[x][y].isEmpty();
  }

  public boolean isWin(Marker lastPlayer, int x, int y) {
    int playerTotal = lastPlayer.mark * SIZE;

    char horizontal = '\0';
    char vertical = '\0';
    char diagonal1 = '\0';
    char diagonal2 = '\0';

    for (int i = 0; i < SIZE; i++) {
      horizontal += board[i][y - 1].mark;
      vertical += board[x - 1][i].mark;
      diagonal1 += board[i][i].mark;
      diagonal2 += board[i][SIZE - i - 1].mark;
    }
    return horizontal == playerTotal
        || vertical == playerTotal
        || diagonal1 == playerTotal
        || diagonal2 == playerTotal;
  }

  boolean isDraw() {
    for (int x = 0; x < SIZE; x++) {
      for (int y = 0; y < SIZE; y++) {
        if (isEmpty(x, y)) {
          return false;
        }
      }
    }
    return true;
  }
}
