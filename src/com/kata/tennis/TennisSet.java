package com.kata.tennis;

/**
 * Created by mac on 10/06/2019.
 */
public class TennisSet {

    private int tennisSetId;
    private Game game;
    private Player player1;
    private Player player2;
    private int player1SetScore;
    private int player2SetScore;

    public TennisSet() {
    }

    public TennisSet(int tennisSetId, Game game, int player1SetScore, int player2SetScore) {
        this.tennisSetId = tennisSetId;
        this.game = game;
        this.player1SetScore = player1SetScore;
        this.player2SetScore = player2SetScore;
    }

    public int getTennisSetId() {
        return tennisSetId;
    }

    public void setTennisSetId(int tennisSetId) {
        this.tennisSetId = tennisSetId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPlayer1SetScore() {
        return player1SetScore;
    }

    public void setPlayer1SetScore(int player1SetScore) {
        this.player1SetScore = player1SetScore;
    }

    public int getPlayer2SetScore() {
        return player2SetScore;
    }

    public void setPlayer2SetScore(int player2SetScore) {
        this.player2SetScore = player2SetScore;
    }

    public String getSetResult() {
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();
        player1SetScore = player1.getScoreOfSet();
        player2SetScore = player2.getScoreOfSet();
        if ((player1SetScore == 6) && (Math.abs(player2SetScore - player1SetScore) >= 2)) {

            return getWinnerOfTheSet().getFirstName() + " " + getWinnerOfTheSet().getLastName() + " Won The Match";

        } else if ((player2SetScore == 7 || player1SetScore == 7) && (Math.abs(player2SetScore - player1SetScore) == 2)) {
            return getWinnerOfTheSet().getFirstName() + " " + getWinnerOfTheSet().getLastName() + " Won The Match";
        } else {
            return getScoreOfSetDescription();
        }
    }

    public Player getWinnerOfTheSet() {
        return (player1SetScore > player2SetScore) ? player1 : player2;
    }

    public String getScoreOfSetDescription() {
        return player1.getFirstName() + "" + player1.getLastName() + " : " + player2SetScore + " - " + player2.getFirstName() + "" + player2.getLastName() + " : " + player2SetScore;
    }

}
