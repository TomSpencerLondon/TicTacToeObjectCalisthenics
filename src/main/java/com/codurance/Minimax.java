package com.codurance;

public class Minimax {
  public void play(Game game){
    while(game.getScore().getValue0() == 0){
      game.playerMove(Square.O);
      game.show();
      if (game.getScore().getValue0() != 0){
        break;
      }
      computerMove(game);
      game.show();
    }
  }

  private void computerMove(Game game) {
    game.playerMove(Square.X);
  }
}