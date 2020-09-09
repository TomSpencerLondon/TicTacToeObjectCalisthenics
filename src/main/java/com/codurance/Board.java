package com.codurance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
  private static final int SIZE = 3;

  public Map<Marker, List<Position>> board = Map.of(Marker.X, new ArrayList<>(), Marker.O,new ArrayList<>());

  public void move(Position position, Marker player){
    checkAxis(position);
    if (isNotEmpty(position)){
      throw new RuntimeException("Box is occupied");
    }
    add(position, player);
  }

  public boolean isWin(List<List<Position>> combinations, Marker player){
    return combinations.stream().anyMatch(getPositions(player)::containsAll);
  }

  public List<Position> getPositions(Marker lastPlayer) {
    return board.get(lastPlayer);
  }

  private boolean isNotEmpty(Position position) {
    return getPositions(Marker.X).contains(position) || getPositions(Marker.O).contains(position);
  }

  private void checkAxis(Position position){
    if (position.isOutside(SIZE)){
      throw new RuntimeException("Outside board");
    }
  }

  private void add(Position position, Marker lastPlayer) {
    getPositions(lastPlayer).add(position);
  }


}
