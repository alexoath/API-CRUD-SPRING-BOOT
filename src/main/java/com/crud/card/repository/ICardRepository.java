package com.crud.card.repository;

import java.util.List;
import com.crud.card.model.Card;

public interface ICardRepository {
    List<Card> findAll();
    int save(Card card);
    int update(Card card);
    int deleteById(int id);
}