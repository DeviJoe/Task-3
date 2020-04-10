package com.devijoe.project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private CardDeck deck = new CardDeck();
    private Player p1 = new Player(1);
    private Player p2 = new Player(2);
     GameStatus status = GameStatus.BEFORE_GAME;
    private int winner;

    public enum GameStatus {
        BEFORE_GAME,
        GAME_STARTED,
        END
    }

    /**
     * Метод подготавливает все необходимое для начала игры:
     * создает колоду, перетасовывает и раздает карты игрокам
     */
    public void start() throws Exception {
        if (status == GameStatus.BEFORE_GAME) {
            deck.createDeck();
            deck.shake(4);
            p1.setHand(deck);
            p2.setHand(deck);
            status = GameStatus.GAME_STARTED;
        } else {
            throw new Exception("ИГРА УЖЕ ЗАПУЩЕНА");
        }
    }

    /**
     * Метод реализует механизм совершения хода
     */
    public void makeMove() throws Exception {
        if (status == GameStatus.GAME_STARTED) {
            int point = -2;
            List<CardDeck.Card> buffer = new ArrayList<>();

            do {
                buffer.add(p1.takeCard());
                buffer.add(p2.takeCard());
                point += 2;
            } while (buffer.get(point).getValue() == buffer.get(point+1).getValue());

            if (buffer.get(point).getValue() > buffer.get(point+1).getValue()) {
                p1.addList(buffer);
            } else {
                p2.addList(buffer);
            }

            if (p1.isEmpty()) {
                status = GameStatus.END;
                winner = p2.getIdentifier();
            }

            if (p2.isEmpty()) {
                status = GameStatus.END;
                winner = p1.getIdentifier();
            }
        } else {
            throw new Exception("ИГРА НЕ НАЧАЛАСЬ ЛИБО УЖЕ ОКОНЧЕНА");
        }
    }

    public int getWinner() throws Exception {
        if (status == GameStatus.END) {
            return winner;
        } else {
            throw new Exception("ИГРА НЕ ОКОНЧЕНА");
        }
    }

}
