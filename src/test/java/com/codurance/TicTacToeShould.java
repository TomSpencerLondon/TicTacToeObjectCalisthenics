package com.codurance;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeShould {
  private TicTacToe ticTacToe;

  @BeforeEach
  void setUp() {
    ticTacToe = new TicTacToe();
  }

  @Test
  void not_allow_x_to_be_outside_of_the_board() {
    assertThatThrownBy(() -> ticTacToe.play(5, 2))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("X is outside board");
  }

  @Test
  void not_allow_y_to_be_outside_of_the_board() {
    assertThatThrownBy(() -> ticTacToe.play(2, 5))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("X is outside board");
  }

  @Test
  void not_allow_playing_the_same_square_twice() {
    ticTacToe.play(1, 1);
    thenThrownBy(() -> ticTacToe.play(1, 1))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("Box is occupied");
  }

  @Test
  public void givenFirstTurnWhenNextPlayerThenX() {
    assertEquals('X', ticTacToe.nextPlayer());
  }

  @Test
  public void givenLastTurnWasXWhenNextPlayerThenO() {
    ticTacToe.play(1, 1);
    assertEquals('O', ticTacToe.nextPlayer());
  }

  @Test
  public void whenPlayThenNoWinner() {
    String actual = ticTacToe.play(1, 1);
    assertEquals("No winner", actual);
  }

  @Test
  public void whenPlayAndWholeHorizontalLineThenWinner() {
    ticTacToe.play(1, 1); // X
    ticTacToe.play(1, 2); // O
    ticTacToe.play(2, 1); // X
    ticTacToe.play(2, 2); // O
    String actual = ticTacToe.play(3, 1); // X
    assertEquals("X is the winner", actual);
  }

  @Test
  public void whenPlayAndWholeVerticalLineThenWinner() {
    ticTacToe.play(2, 1); // X
    ticTacToe.play(1, 1); // O
    ticTacToe.play(3, 1); // X
    ticTacToe.play(1, 2); // O
    ticTacToe.play(2, 2); // X
    String actual = ticTacToe.play(1, 3); // O
    assertEquals("O is the winner", actual);
  }

  @Test
  public void whenPlayAndTopBottomDiagonalLineThenWinner() {
    ticTacToe.play(1, 1); // X
    ticTacToe.play(1, 2); // O
    ticTacToe.play(2, 2); // X
    ticTacToe.play(1, 3); // O
    String actual = ticTacToe.play(3, 3); // O
    assertEquals("X is the winner", actual);
  }

  @Test
  public void whenPlayAndBottomTopDiagonalLineThenWinner() {
    ticTacToe.play(1, 3); // X
    ticTacToe.play(1, 1); // O
    ticTacToe.play(2, 2); // X
    ticTacToe.play(1, 2); // O
    String actual = ticTacToe.play(3, 1); // O
    assertEquals("X is the winner", actual);
  }

  @Test
  public void whenAllBoxesAreFilledThenDraw() {
    ticTacToe.play(1, 1);
    ticTacToe.play(1, 2);
    ticTacToe.play(1, 3);
    ticTacToe.play(2, 1);
    ticTacToe.play(2, 3);
    ticTacToe.play(2, 2);
    ticTacToe.play(3, 1);
    ticTacToe.play(3, 3);
    String actual = ticTacToe.play(3, 2);
    assertEquals("The result is draw", actual);
  }
}
