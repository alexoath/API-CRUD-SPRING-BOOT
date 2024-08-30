package com.crud.card.service;

import java.util.List;
import com.crud.card.model.Card;

public interface ICardService {
    List<Card> findAll();
    int save(Card card);
    int update(Card card);
    int deleteById(int id);
}