package com.codurance;

public class TicTacToe {

  private static final int SIZE = 3;
  private Board board = new Board();

  private Marker lastPlayer = new Marker('\0');

  public String play(int x, int y) {
    lastPlayer = nextPlayer();
    setBox(x, y, lastPlayer);
    return determineResult(x, y);
  }

  private String determineResult(int x, int y) {
    if (isWin(lastPlayer, x, y)) {
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

  private void setBox(int x, int y, Marker lastPlayer) {
    board.add(x, y, lastPlayer);
  }

  public boolean isWin(Marker lastPlayer, int x, int y) {
    int playerTotal = lastPlayer.mark * SIZE;

    char horizontal = '\0';
    char vertical = '\0';
    char diagonal1 = '\0';
    char diagonal2 = '\0';

    for (int i = 0; i < SIZE; i++) {
      horizontal += board.getMarkAt(i, y - 1);
      vertical += board.getMarkAt(x - 1, i);
      diagonal1 += board.getMarkAt(i, i);
      diagonal2 += board.getMarkAt(i, SIZE - i - 1);
    }
    return horizontal == playerTotal
        || vertical == playerTotal
        || diagonal1 == playerTotal
        || diagonal2 == playerTotal;
  }
  boolean isDraw() {
    for (int x = 0; x < SIZE; x++) {
      for (int y = 0; y < SIZE; y++) {
        if (board.isEmpty(x, y)) {
          return false;
        }
      }
    }
    return true;
  }
}