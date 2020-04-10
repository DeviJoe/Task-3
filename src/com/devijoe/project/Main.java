package com.devijoe.project;

public class Main {

    public static void main(String[] args) throws Exception {

        Game game = new Game();

        game.start();
        do {
            game.makeMove();
        } while (game.status != Game.GameStatus.END);
        int winner;
        winner = game.getWinner();
        System.out.println(winner);
    }
}
