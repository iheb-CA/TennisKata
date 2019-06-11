package com.kata.tennis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by mac on 11/06/2019.
 */
class TennisSetTest {

    /*
    If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set.
    */

    @Test
    public void getSetResult() {
        Player player1 = new Player(1, "Jhon", "Doe", 32, 0, 6);
        Player player2 = new Player(2, "Marc", "Shuls", 29, 0, 3);
        Game game1 = new Game(1, player1, player2);
        TennisSet tennisSet = new TennisSet(1, game1, 6, 3);
        assertEquals("Jhon Doe Won The Match", tennisSet.getSetResult());
    }

    /*
    Test for unfinished match:
    If a player wins a Game and reach the Set score of 6 and the other player has a Set score of 5,
    a new Game must be played and the first player who reach the score of 7 wins the match.
    */

    @Test
    public void getSetResultForUnfinishedMatch() {
        Player player1 = new Player(1, "Jhon", "Doe", 32, 0, 6);
        Player player2 = new Player(2, "Marc", "Shuls", 29, 0, 5);
        Game game1 = new Game(1, player1, player2);
        TennisSet tennisSet = new TennisSet(1, game1, 6, 5);
        assertEquals("JhonDoe : 5 - MarcShuls : 5", tennisSet.getSetResult());
    }


    /*
    The Tie-Break ends as soon as a player gets a least 7 points and 2 points more than his opponent.
    The player who wins the Tie-Break wins the Set and the match.
    */

    @Test
    public void getSetResultWithTieBreakRule() {
        Player player1 = new Player(1, "Jhon", "Doe", 32, 0, 7);
        Player player2 = new Player(2, "Marc", "Shuls", 29, 0, 5);
        Game game1 = new Game(1, player1, player2);
        TennisSet tennisSet = new TennisSet(1, game1, 7, 5);
        assertEquals("Jhon Doe Won The Match", tennisSet.getSetResult());
    }

}