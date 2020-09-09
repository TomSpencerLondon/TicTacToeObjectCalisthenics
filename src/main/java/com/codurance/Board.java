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

  private boolean isNotEmpty(Position position) {
    return this.board.get(Marker.X).contains(position) || this.board.get(Marker.O).contains(position);
  }

  private void checkAxis(Position position){
    if (position.isOutside(SIZE)){
      throw new RuntimeException("Outside board");
    }
  }

  private void add(Position position, Marker lastPlayer) {
    board.get(lastPlayer).add(position);
  }
}
