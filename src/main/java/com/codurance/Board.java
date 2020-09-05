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
    if (!isEmpty(x - 1, y - 1)){
      throw new RuntimeException("Box is occupied");
    }
    board[x - 1][y - 1] = lastPlayer;
  }

  public boolean isEmpty(int x, int y) {
    checkAxis(x);
    checkAxis(y);
    return board[x][y].isEmpty();
  }

  public char getMarkAt(int x, int y){
    return board[x][y].mark;
  }

  private void checkAxis(int axis) {
    if (axis < 0 || axis >= SIZE) {
      throw new RuntimeException("X is outside board");
    }
  }
}
