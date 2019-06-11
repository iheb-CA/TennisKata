package com.kata.tennis;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Iheb on 09/06/2019.
 */
public class Player {

    private int playerId;
    private String firstName;
    private String lastName;
    private int age;
    private int gameScore;
    private int scoreOfSet;

    public static final List<String> pointsCounter = Arrays.asList("Starting Points : 0", "First point : 15", "Second point : 30", "Third point : 40");

    public Player(int playerId, String firstName, String lastName, int age, int gameScore) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gameScore = gameScore;
    }

    public Player(int playerId, String firstName, String lastName, int age, int gameScore, int scoreOfSet) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gameScore = gameScore;
        this.scoreOfSet = scoreOfSet;
    }

    public Player() {

    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public int getScoreOfSet() {
        return scoreOfSet;
    }

    public void setScoreOfSet(int scoreOfSet) {
        this.scoreOfSet = scoreOfSet;
    }

    public void winBall() {
        this.gameScore = this.gameScore + 1;
    }

    public String getScoreDescription() {
        if (gameScore > 3) {
            return pointsCounter.get(3);
        } else {
            return pointsCounter.get(gameScore);
        }
    }
}
