package com.codurance;

import static java.util.Arrays.asList;

import java.util.List;

public class Decider {
  public static final int TOTAL_SQUARES = 9;
  private static final List<List<Position>> WINNING_COMBINATIONS = asList(
      asList(new Position(1, 1), new Position(1, 2), new Position(1, 3)),
      asList(new Position(2, 1), new Position(2, 2), new Position(2, 3)),
      asList(new Position(3, 1), new Position(3, 2), new Position(3, 3)),
      asList(new Position(1, 1), new Position(2, 1), new Position(3, 1)),
      asList(new Position(1, 2), new Position(2, 2), new Position(3, 2)),
      asList(new Position(1, 3), new Position(2, 3), new Position(3, 3)),
      asList(new Position(1, 1), new Position(2, 2), new Position(3, 3)),
      asList(new Position(1, 3), new Position(2, 2), new Position(3, 1))
  );
  private final Board board;
  public Decider(Board board) {
    this.board = board;
  }

  public boolean isWin(Marker lastPlayer) {
    return board.isWin(WINNING_COMBINATIONS, lastPlayer);
  }

  public boolean isDraw() {
    return board.getPositions(Marker.X).size() + board.getPositions(Marker.O).size() == TOTAL_SQUARES;
  }

}
