package com.kata.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * Created by mac on 09/06/2019.
 */
class GameTest {

    Player player1;
    Player player2;
    Game game1;

    @BeforeEach
    public void beforeGameTest() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game1 = new Game(1, player1, player2);
    }

    @Test
    public void StartingPOintsAsScore0() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game1 = new Game(1, player1, player2);
        assertEquals("Starting Points : 0, Starting Points : 0", game1.getScore());
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game1 = new Game(1, player1, player2);
        player2.winBall();
        assertEquals("Starting Points : 0, First point : 15", game1.getScore());
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game1 = new Game(1, player1, player2);
        IntStream.rangeClosed(1, 2).forEach((Integer) -> {
            player1.winBall();
        });
        player2.winBall();
        assertEquals("Second point : 30, First point : 15", game1.getScore());
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game1 = new Game(1, player1, player2);
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            player1.winBall();
        });
        assertEquals("Third point : 40, Starting Points : 0", game1.getScore());
    }

    @Test
    public void advantageShouldBeDisplayed() {
        Player player1 = new Player(1, "Jhon", "Doe", 32, 0);
        Player player2 = new Player(2, "Marc", "Shuls", 29, 0);
        Game game1 = new Game(1, player1, player2);

        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            player1.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            player2.winBall();
        });
        assertEquals("advantage Marc Shuls", game1.getScore());
    }

    @Test
    public void deuceShouldBeDisplayed() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game1 = new Game(1, player1, player2);

        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            player1.winBall();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            player2.winBall();
        });
        assertEquals("Deuce", game1.getScore());
        player1.winBall();
        assertNotEquals("Deuce", game1.getScore());
        player2.winBall();
        assertEquals("Deuce", game1.getScore());
    }

    @Test
    public void firstPlayerShouldBeDisplayedWinner() {
        Player player1 = new Player(1, "Jhon", "Doe", 32, 0);
        Player player2 = new Player(2, "Marc", "Shuls", 29, 0);
        Game game1 = new Game(1, player1, player2);

        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            player1.winBall();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            player2.winBall();
        });
        assertNotEquals("Jhon Doe won", game1.getScore());
        assertNotEquals("Marc Shuls won", game1.getScore());
        player1.winBall();
        assertEquals("Jhon Doe won", game1.getScore());
    }

    @Test
    public void SecondPlayerShouldBeDisplayedWinnerAfterAdvantage() {
        Player player1 = new Player(1, "Jhon", "Doe", 32, 0);
        Player player2 = new Player(2, "Marc", "Shuls", 29, 0);
        Game game1 = new Game(1, player1, player2);
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            player1.winBall();
        });
        IntStream.rangeClosed(1, 8).forEach((Integer) -> {
            player2.winBall();
        });
        assertEquals("Marc Shuls won", game1.getScore());
    }

}