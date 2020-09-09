package com.codurance;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TicTacToe {

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
  private static final int SIZE = 3;
  public static final int TOTAL_SQUARES = 9;

  private Marker lastPlayer = Marker.EMPTY;
  List<Position> playerX = new ArrayList<>();
  List<Position> playerO = new ArrayList<>();
//  Map<Marker, List<Position>> board = Map.of(Marker.X, playerX, Marker.O,playerO);
  Board board = new Board();

  public String play(int x, int y) {
    lastPlayer = nextPlayer();
    Position position = new Position(x, y);
    board.move(position, lastPlayer);
    return determineResult(position);
  }

  private String determineResult(Position position) {
    if (isWin(lastPlayer)) {
      return lastPlayer + " is the winner";
    } else if (isDraw()) {
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

  public boolean isWin(Marker lastPlayer) {
    if (lastPlayer == Marker.X){
      return WINNING_COMBINATIONS.stream().anyMatch(board.board.get(Marker.X)::containsAll);
    }else if(lastPlayer ==Marker.O){
      return WINNING_COMBINATIONS.stream().anyMatch(board.board.get(Marker.O)::containsAll);
    }else {
      return false;
    }
  }

  boolean isDraw() {
    return board.board.get(Marker.X).size() + board.board.get(Marker.O).size() == TOTAL_SQUARES;
  }
}