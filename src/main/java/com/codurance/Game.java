package com.codurance;

public interface Game {
  public void playerMove();
  public void getScore();
  public void getPossibleMoves();
  void applyMove(Square s, int x, int y);
}
