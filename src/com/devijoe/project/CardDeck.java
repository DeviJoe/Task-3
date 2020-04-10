package com.devijoe.project;

import java.util.ArrayList;

public class CardDeck {

    public enum Suit {
        /**
         * Черви
         */
        HEART,
        /**
         * Буби
         */
        DIAMOND,
        /**
         * Крести
         */
        CLUB,
        /**
         * Пики
         */
        SPADE
    }

    public class Card {

        private Suit suit;
        private int value;

        public Card(Suit suit, int value) {
            this.suit = suit;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Suit getSuit() {
            return suit;
        }
    }

    /** Колода карт */
    private ArrayList<Card> deck = new ArrayList<>();

    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Создает колоду на 36 карт
     */
    public void createDeck() {
        createSubDec(Suit.CLUB);
        createSubDec(Suit.DIAMOND);
        createSubDec(Suit.HEART);
        createSubDec(Suit.SPADE);
    }

    /**
     * Создает дополнительную колоду из карт определенной масти
     * @param suit масть
     */
    private void createSubDec(Suit suit) {
        for (int i = 6; i < 15; i++) {
            deck.add(new Card(suit, i));
        }
    }

    /**
     * Перемешавает карты
     * @param count кол-во перетасовок
     */
    public void shake(int count) {

        ArrayList<Card> subList = new ArrayList<>();
        ArrayList<Card> copy = (ArrayList<Card>) deck.clone();
        int index;

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 36; j++) {
                index = (int) (Math.random() * copy.size());
                subList.add(copy.get(index));
                copy.remove(index);
            }
            copy = (ArrayList<Card>) subList.clone();
            if (i!=count-1) {
                subList.clear();
            }
        }

        deck = subList;
    }

    /**
     * Забирает карту из колоды
     * @param index
     * @return
     */
    public Card takeCard(int index) {
        Card card = deck.get(index);
        deck.remove(index);
        return card;
    }

    /**
     * Проверяет колоду на пустоту
     * @return
     */
    public boolean isEmpty() {
        if (deck.size()==0) {
            return true;
        } else {
            return false;
        }
    }
}
