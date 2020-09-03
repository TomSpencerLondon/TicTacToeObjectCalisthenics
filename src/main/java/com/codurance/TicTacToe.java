package com.codurance;

public class TicTacToe {

  private Marker[][] board = {
      {new Marker('\0'), new Marker('\0'), new Marker('\0')},
      {new Marker('\0'), new Marker('\0'), new Marker('\0')},
      {new Marker('\0'), new Marker('\0'), new Marker('\0')}
  };

  private Marker lastPlayer = new Marker('\0');
  private static final int SIZE = 3;

  public String play(int x, int y) {
    checkAxis(x);
    checkAxis(y);
    lastPlayer = nextPlayer();
    setBox(x, y, lastPlayer);
    return determineResult(x, y);
  }

  private String determineResult(int x, int y) {
    if (isWin(x, y)) {
      return lastPlayer.mark + " is the winner";
    } else if (isDraw()) {
      return "The result is draw";
    } else {
      return "No winner";
    }
  }

  public Marker nextPlayer() {
    if (lastPlayer.equals(new Marker('X'))) {
      return new Marker('O');
    }
    return new Marker('X');
  }

  private void checkAxis(int axis) {
    if (axis < 1 || axis > SIZE) {
      throw new RuntimeException("X is outside board");
    }
  }

  private void setBox(int x, int y, Marker lastPlayer) {
    if (!board[x - 1][y - 1].isEmpty()) {
      throw new RuntimeException("Box is occupied");
    }

    board[x - 1][y - 1] = lastPlayer;
  }

  private boolean isWin(int x, int y) {
    int playerTotal = lastPlayer.mark * SIZE;
    char horizontal, vertical, diagonal1, diagonal2;
    horizontal = vertical = diagonal1 = diagonal2 = '\0';
    for (int i = 0; i < SIZE; i++) {
      horizontal += board[i][y - 1].mark;
      vertical += board[x - 1][i].mark;
      diagonal1 += board[i][i].mark;
      diagonal2 += board[i][SIZE - i - 1].mark;
    }
    if (horizontal == playerTotal
        || vertical == playerTotal
        || diagonal1 == playerTotal
        || diagonal2 == playerTotal) {
      return true;
    }
    return false;
  }

  private boolean isDraw() {
    for (int x = 0; x < SIZE; x++) {
      for (int y = 0; y < SIZE; y++) {
        if (board[x][y].isEmpty()) {
          return false;
        }
      }
    }
    return true;
  }
}