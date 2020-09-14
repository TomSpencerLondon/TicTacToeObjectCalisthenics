package com.codurance;

import org.javatuples.Pair;

public interface Game {
  public void playerMove(Square x);
  Pair<Integer, Boolean> getScore();
  public void getPossibleMoves();
  void applyMove(Square s, int x, int y);
  void show();

}
