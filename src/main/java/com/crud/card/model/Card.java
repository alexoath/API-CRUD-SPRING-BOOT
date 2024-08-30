package com.crud.card.model;

import lombok.Data;

@Data
public class Card {
    private int id_card;
    private String name;
    private String number;
    private String type;
    private int ccv;
    private int status;

    // Constructor sin argumentos
    public Card() {
    }
}