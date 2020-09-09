package com.codurance;

public class TicTacToe {

  private Marker lastPlayer = Marker.EMPTY;
  Board board = new Board();
  Decider decider = new Decider(board);

  public String play(int x, int y) {
    lastPlayer = nextPlayer();
    Position position = new Position(x, y);
    board.move(position, lastPlayer);
    return determineResult(position);
  }

  private String determineResult(Position position) {
    if (decider.isWin(lastPlayer)) {
      return lastPlayer + " is the winner";
    } else if (decider.isDraw()) {
      return "The result is draw";
    } else {
      return "No winner";
    }
  }

  public Marker nextPlayer() {
    if (lastPlayer == Marker.X) {
      return Marker.O;
    }
    return Marker.X;
  }
}