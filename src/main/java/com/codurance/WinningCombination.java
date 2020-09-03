package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class WinningCombination {
  private static final int SIZE = 3;

  private Marker[][] board;

  public WinningCombination(Marker[][] board) {
    this.board = board;
  }

  public void add(int x, int y, Marker lastPlayer){
    board[x - 1][y - 1] = lastPlayer;
  }

  public boolean isEmpty(int x, int y) {
    return board[x][y].isEmpty();
  }

  public boolean isWin(Marker lastPlayer, int x, int y) {
    int playerTotal = lastPlayer.mark * SIZE;
    char horizontal, vertical, diagonal1, diagonal2;
    horizontal = vertical = diagonal1 = diagonal2 = '\0';
    for (int i = 0; i < SIZE; i++) {
      horizontal += board[i][y - 1].mark;
      vertical += board[x - 1][i].mark;
      diagonal1 += board[i][i].mark;
      diagonal2 += board[i][SIZE - i - 1].mark;
    }
    if (horizontal == playerTotal
        || vertical == playerTotal
        || diagonal1 == playerTotal
        || diagonal2 == playerTotal) {
      return true;
    }
    return false;
  }
}
