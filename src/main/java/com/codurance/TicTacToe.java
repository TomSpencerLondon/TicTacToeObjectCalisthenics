package com.codurance;

public class TicTacToe {
  private Board board = new Board(
      new Marker[][]{
      {new Marker('\0'), new Marker('\0'), new Marker('\0')},
      {new Marker('\0'), new Marker('\0'), new Marker('\0')},
      {new Marker('\0'), new Marker('\0'), new Marker('\0')}
  });

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
    if (board.isWin(lastPlayer, x, y)) {
      return lastPlayer.mark + " is the winner";
    } else if (board.isDraw()) {
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
    if (!board.isEmpty(x - 1, y - 1)){
      throw new RuntimeException("Box is occupied");
    }

    board.add(x, y, lastPlayer);
  }

}