package com.devijoe.project;

import java.util.List;

public class Player {

    private Queue<CardDeck.Card> player = new Queue<>();
    private int identifier;

    public Player(int id) {
        identifier = id;
    }

    /**
     * Добавление карты в конец
     * @param card
     */
    public void addCard(CardDeck.Card card) {
        player.add(card);
    }

    /**
     * Устанавливает "руку" игрока
     * @param deck
     */
    public void setHand(CardDeck deck) {
        if (deck.getDeck().size()>18) {
            for (int i = 0; i < 18; i++) {
                addCard(deck.takeCard(i));
            }
        } else {
            for (int i = 0; i < deck.getDeck().size(); i++) {
                addCard(deck.takeCard(i));
                i--;
            }
        }
    }

    /**
     * Проверка на пустоту
     * @return
     */
    public boolean isEmpty() {
        if (player.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Queue<CardDeck.Card> getPlayer() {
        return player;
    }

    public CardDeck.Card takeCard() throws Exception {
        return player.get();
    }

    public void addList(List<CardDeck.Card> list) {
        for (int i = 0; i < list.size(); i++) {
            player.add(list.get(i));
        }
    }

    public int getIdentifier() {
        return identifier;
    }
}
