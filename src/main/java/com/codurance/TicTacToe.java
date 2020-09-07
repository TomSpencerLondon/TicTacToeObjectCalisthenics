package com.codurance;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

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
  private Board board = new Board();

  private Marker lastPlayer = new Marker('\0');
  List<Position> playerX = new ArrayList<>();
  List<Position> playerO = new ArrayList<>();


  public String play(int x, int y) {
    Position position = new Position(x, y);
    lastPlayer = nextPlayer();
    setBox(position, lastPlayer);
    return determineResult(position);
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

  private void setBox(Position position, Marker lastPlayer) {
    if (lastPlayer.mark == 'X') {
      playerX.add(position);
    }else if(lastPlayer.mark == 'O'){
      playerO.add(position);
    }

    board.add(position.getX(), position.getY(), lastPlayer);
  }

  public boolean isWin(Marker lastPlayer, Position position) {
    if (lastPlayer.mark == 'X'){
      return WINNING_COMBINATIONS.stream().anyMatch(playerX::containsAll);
    }else if(lastPlayer.mark == 'O'){
      return WINNING_COMBINATIONS.stream().anyMatch(playerO::containsAll);
    }else {
      return false;
    }
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