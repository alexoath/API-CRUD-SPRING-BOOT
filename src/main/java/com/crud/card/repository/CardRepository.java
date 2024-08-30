package com.crud.card.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.crud.card.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepository implements ICardRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Card> findAll() {
        List<Card> cards = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM cards");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Card card = new Card();
                card.setId_card(rs.getInt("id_card"));
                card.setName(rs.getString("name"));
                card.setNumber(rs.getString("number"));
                card.setType(rs.getString("type"));
                card.setCcv(rs.getInt("ccv"));
                card.setStatus(rs.getInt("status"));
                cards.add(card);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cards;
    }

    @Override
    public int save(Card card) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO cards (name, number, type, ccv, status) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, card.getName());
            ps.setString(2, card.getNumber());
            ps.setString(3, card.getType());
            ps.setInt(4, card.getCcv());
            ps.setInt(5, card.getStatus());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Card card) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE cards SET name = ?, number = ?, type = ?, ccv = ?, status = ? WHERE id_card = ?")) {
            ps.setString(1, card.getName());
            ps.setString(2, card.getNumber());
            ps.setString(3, card.getType());
            ps.setInt(4, card.getCcv());
            ps.setInt(5, card.getStatus());
            ps.setInt(6, card.getId_card());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(int id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM cards WHERE id_card = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}