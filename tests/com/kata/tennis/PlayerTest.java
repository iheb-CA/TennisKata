package com.kata.tennis;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by mac on 09/06/2019.
 */
class PlayerTest {

    //Test all get Methods
    @Test
    void getPlayerInformations() {

        Player player1 = new Player(1, "Jhon", "Doe", 32, 2);

        assertEquals(1, player1.getPlayerId());
        assertEquals("Jhon", player1.getFirstName());
        assertEquals("Doe", player1.getLastName());
        assertEquals(32, player1.getAge());
        assertEquals(2, player1.getGameScore());

    }

    @Test
    void setPlayerInformations() {
        Player player2 = new Player();
        player2.setPlayerId(2);
        player2.setFirstName("Jane");
        player2.setLastName("Doe");
        player2.setAge(28);
        player2.setGameScore(3);
        assertEquals(2, player2.getPlayerId());
        assertEquals("Jane", player2.getFirstName());
        assertEquals("Doe", player2.getLastName());
        assertEquals(28, player2.getAge());
        assertEquals(3, player2.getGameScore());
    }

    @Test
    void winBall() {
        Player player3 = new Player();
        assertEquals(0, player3.getGameScore());
        player3.winBall();
        assertEquals(1, player3.getGameScore());
    }

    @Test
    void getScoreDescription() {
        Player player3 = new Player();
        player3.setGameScore(3);
        assertEquals("Third point : 40", player3.getScoreDescription());
    }

    @Test
    public void winningPointsForEachPlayer() {
        Player player1 = new Player();
        Player player2 = new Player();
        IntStream.rangeClosed(1, 2).forEach((Integer) -> {
            player1.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            player2.winBall();
        });

        assertEquals(2, player1.getGameScore());
        assertEquals(4, player2.getGameScore());
    }

}