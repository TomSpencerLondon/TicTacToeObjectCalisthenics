package com.codurance;

import static com.codurance.Square.E;
import static com.codurance.Square.O;
import static java.util.Arrays.asList;

import org.assertj.core.internal.Lists;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TicTacToeMinimax extends TicTacToe implements Game {
  private TicTacToe ticTacToe = new TicTacToe();
  private Square[][] board = {
      {E, E, E},
      {E, E, E},
      {E, E, E}
  };

  private List<Position> emptyPositions = new ArrayList<>();

  public TicTacToeMinimax() {
    emptyPositions.add(new Position(1, 1));
    emptyPositions.add(new Position(1, 2));
    emptyPositions.add(new Position(1, 3));
    emptyPositions.add(new Position(2, 1));
    emptyPositions.add(new Position(2, 2));
    emptyPositions.add(new Position(2, 3));
    emptyPositions.add(new Position(3, 1));
    emptyPositions.add(new Position(3, 2));
    emptyPositions.add(new Position(3, 3));
  }

  @Override
  public void playerMove(Square marker) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("enter an integer 0 - 8");
    int myint = keyboard.nextInt();
    int x = myint % 3 + 1;
    int y = myint / 3 + 1;
    applyMove(marker,x, y);
  }

  @Override
  public Pair <Integer, Boolean> getScore() {
    // TODO: Refactor comparison of string
    String result = determineResult();
    System.out.println(result);
    System.out.println(playerO.toString());
    System.out.println(playerX.toString());
    if(result.equals("No winner"))
      return new Pair(0, false);
    else if(result.equals("The result is draw"))
      return new Pair(0, true);
    else if(result.charAt(0) == 'O')
      return new Pair(-100, true);
    else if(result.charAt(0) == 'X')
      return new Pair(100, true);
    else
      throw new RuntimeException("Error in getScore()");
  }

  @Override
  public void getPossibleMoves() {

  }

  @Override
  public void applyMove(Square s, int x, int y) {
    ticTacToe.play(x, y);
    Position position = new Position(x, y);
    this.emptyPositions.remove(position);
    board[y - 1][x - 1] = s;
  }

  @Override
  public void show() {
    System.out.println(Arrays.deepToString(board));
  }
}
