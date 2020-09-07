package com.codurance;

public class TicTacToe {

  private static final int SIZE = 3;
  private Board board = new Board();

  private Marker lastPlayer = new Marker('\0');

  public String play(int x, int y) {
    lastPlayer = nextPlayer();
    setBox(x, y, lastPlayer);
    return determineResult(new Position(x, y));
  }

  private String determineResult(Position position) {
    if (isWin(lastPlayer, position)) {
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

  public boolean isWin(Marker lastPlayer, Position position) {
    int playerTotal = lastPlayer.mark * SIZE;
    int x = position.getX();
    int y = position.getY();

    char horizontal = '\0';
    char vertical = '\0';
    char diagonal1 = '\0';
    char diagonal2 = '\0';

    for (int i = 0; i < SIZE; i++) {
      horizontal += board.getMarkAt(position.newPosition(i, y - 1));
      vertical += board.getMarkAt(position.newPosition(x - 1, i));
      diagonal1 += board.getMarkAt(position.newPosition(i, i));
      diagonal2 += board.getMarkAt(position.newPosition(i, SIZE - i - 1));
    }
    return isWinHorizontal(playerTotal, horizontal)
        || isWinVertical(playerTotal, vertical)
        || isWinDiagonal(playerTotal, diagonal1)
        || isWinDiagonal(playerTotal, diagonal2);
  }

  private boolean isWinDiagonal(int playerTotal, char diagonal1) {
    return diagonal1 == playerTotal;
  }

  private boolean isWinVertical(int playerTotal, char vertical) {
    return vertical == playerTotal;
  }

  private boolean isWinHorizontal(int playerTotal, char horizontal) {
    return horizontal == playerTotal;
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