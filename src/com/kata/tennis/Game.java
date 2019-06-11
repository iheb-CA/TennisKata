package com.kata.tennis;

/**
 * Created by mac on 09/06/2019.
 */
public class Game {

    private int gameId;
    private Player player1;
    private Player player2;
    private Player winner;

    public Game(int gameId, Player player1, Player player2) {
        this.gameId = gameId;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Game(int gameId, Player player1, Player player2, Player winner) {
        this.gameId = gameId;
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private boolean hasWinner() {
        if ((player1.getGameScore() >= 4 || player2.getGameScore() >= 4) && (Math.abs(player2.getGameScore() - player1.getGameScore()) >= 2))
            return true;
        return false;
    }

    private boolean hasAdvantage() {
        if (player1.getGameScore() >= 3 && player2.getGameScore() >= 3 && (Math.abs(player2.getGameScore() - player1.getGameScore()) == 1)) {
            return true;
        } else {
            return false;
        }
    }


    private boolean isDeuce() {
        return player1.getGameScore() >= 3 && player1.getGameScore() == player2.getGameScore();
    }

    public String getScore() {

        if (hasWinner()) {
            winner = getLeadPlayer();
            winner.setScoreOfSet(winner.getScoreOfSet() + 1);
            return winner.getFirstName() + " " + winner.getLastName() + " won";
        }

        if (hasAdvantage()) {
            return "advantage " + getLeadPlayer().getFirstName() + " " + getLeadPlayer().getLastName();
        }

        if (isDeuce()) {
            return "Deuce";
        }

        return player1.getScoreDescription() + ", " + player2.getScoreDescription();
    }


    public Player getLeadPlayer() {
        return (player1.getGameScore() > player2.getGameScore()) ? player1 : player2;
    }

}

