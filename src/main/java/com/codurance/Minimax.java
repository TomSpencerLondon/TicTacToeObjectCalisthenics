package com.codurance;

public class Minimax {
  public void play(TicTacToeMinimax ticTacToeMinimax){
    while(("No winner").equals(ticTacToeMinimax.determineResult())){
      ticTacToeMinimax.playerMove();
      if (!("No winner").equals(ticTacToeMinimax.determineResult())){
        break;
      }
      computerMove();
    }
  }

  private void computerMove() {

  }
}
