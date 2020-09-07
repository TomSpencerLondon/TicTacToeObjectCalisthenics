package com.codurance;

import static com.codurance.Square.E;
import static com.codurance.Square.O;
import static java.util.Arrays.asList;

import java.util.List;

public class TicTacToeMinimax extends TicTacToe implements Game {
  private TicTacToe ticTacToe = new TicTacToe();
  private Square[][] board = {
      {E, E, E},
      {E, E, E},
      {E, E, E}
  };

  private List<Position> emptyPositions = asList(
      new Position(1, 1), new Position(1, 2), new Position(1,3),
      new Position(2, 1), new Position(2, 2), new Position(2,3),
      new Position(3, 1), new Position(3, 2), new Position(3,3)
  );

  @Override
  public void playerMove() {
    applyMove(O,2, 2);
  }

  @Override
  public void getScore() {

  }

  @Override
  public void getPossibleMoves() {

  }

  @Override
  public void applyMove(Square s, int x, int y) {
    ticTacToe.play(x, y);
    Position position = new Position(x, y);
    this.emptyPositions.remove(position);
    board[x - 1][y - 1] = s;
  }
}
