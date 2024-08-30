package com.crud.card.service;

import java.util.List;
import com.crud.card.model.Card;
import com.crud.card.repository.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService implements ICardService {

    @Autowired
    private ICardRepository iCardRepository;

    @Override
    public List<Card> findAll() {
        return iCardRepository.findAll();
    }

    @Override
    public int save(Card card) {
        return iCardRepository.save(card);
    }

    @Override
    public int update(Card card) {
        return iCardRepository.update(card);
    }

    @Override
    public int deleteById(int id) {
        return iCardRepository.deleteById(id);
    }
}