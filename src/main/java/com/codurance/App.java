package com.codurance;

import static com.codurance.Square.E;
import static com.codurance.Square.O;
import static com.codurance.Square.X;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    TicTacToeMinimax ticTacToeMinimax = new TicTacToeMinimax();
    Minimax minimax = new Minimax();

    minimax.play(ticTacToeMinimax);

    TicTacToe ticTacToe = new TicTacToe();
    ticTacToe.play(1, 1);
    ticTacToe.play(1, 2);
    ticTacToe.play(1, 3);
    ticTacToe.play(2, 1);
    ticTacToe.play(2, 3);
    ticTacToe.play(2, 2);
    ticTacToe.play(3, 1);
    ticTacToe.play(3, 3);

  }
}
