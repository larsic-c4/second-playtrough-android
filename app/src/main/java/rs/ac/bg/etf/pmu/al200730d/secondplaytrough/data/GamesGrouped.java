package rs.ac.bg.etf.pmu.al200730d.secondplaytrough.data;

import java.util.List;

public class GamesGrouped {
    private String player1, player2;
    private int wins1, wins2;

    private List<Game> games;

    public GamesGrouped(String player1, String player2, int wins1, int wins2, List<Game> games) {
        this.player1 = player1;
        this.player2 = player2;
        this.wins1 = wins1;
        this.wins2 = wins2;
        this.games = games;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public int getWins1() {
        return wins1;
    }

    public int getWins2() {
        return wins2;
    }

    public List<Game> getGames() {
        return games;
    }
}