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
  public static final int TOTAL_SQUARES = 9;

  private Marker lastPlayer = new Marker('\0');
  List<Position> playerX = new ArrayList<>();
  List<Position> playerO = new ArrayList<>();


  public String play(int x, int y) {
    checkAxis(x);
    checkAxis(y);
    Position position = new Position(x, y);
    lastPlayer = nextPlayer();
    if (playerX.contains(position) || playerO.contains(position)){
      throw new RuntimeException("Box is occupied");
    }
    setBox(position, lastPlayer);
    return determineResult(position);
  }

  private String determineResult(Position position) {
    if (isWin(lastPlayer)) {
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

//    board.add(position.getX(), position.getY(), lastPlayer);
  }

  public boolean isWin(Marker lastPlayer) {
    if (lastPlayer.mark == 'X'){
      return WINNING_COMBINATIONS.stream().anyMatch(playerX::containsAll);
    }else if(lastPlayer.mark == 'O'){
      return WINNING_COMBINATIONS.stream().anyMatch(playerO::containsAll);
    }else {
      return false;
    }
  }

  boolean isDraw() {
    return playerX.size() + playerO.size() == TOTAL_SQUARES;
  }

  private void checkAxis(int axis) {
    if (axis < 1 || axis > SIZE) {
      throw new RuntimeException("X is outside board");
    }
  }
}