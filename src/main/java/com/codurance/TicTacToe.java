package com.codurance;

import static com.codurance.WinningCombinations.TOTAL_SQUARES;
import static com.codurance.WinningCombinations.WINNING_COMBINATIONS;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

  private Marker lastPlayer = new Marker('\0');
  public List<Position> playerX = new ArrayList<>();
  public List<Position> playerO = new ArrayList<>();

  public String play(int x, int y) {
    checkAxis(x);
    checkAxis(y);
    Position position = new Position(x, y);
    lastPlayer = nextPlayer();
    if (playerX.contains(position) || playerO.contains(position)){
      throw new RuntimeException("Box is occupied");
    }
    setBox(position, lastPlayer);
    return determineResult();
  }

  public String determineResult() {
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
    if (lastPlayer.equals(new Marker('X'))) {
      playerX.add(position);
    }else if(lastPlayer.equals(new Marker('O'))){
      playerO.add(position);
    }
  }

  public boolean isWin(Marker lastPlayer) {
    if (lastPlayer.equals(new Marker('X'))){
      return WINNING_COMBINATIONS.stream().anyMatch(playerX::containsAll);
    }else if(lastPlayer.equals(new Marker('O'))){
      return WINNING_COMBINATIONS.stream().anyMatch(playerO::containsAll);
    }else {
      return false;
    }
  }

  boolean isDraw() {
    return playerX.size() + playerO.size() == TOTAL_SQUARES;
  }

  private void checkAxis(int axis) {
    if (axis < 1 || axis > WinningCombinations.SIZE) {
      throw new RuntimeException("X is outside board");
    }
  }
}