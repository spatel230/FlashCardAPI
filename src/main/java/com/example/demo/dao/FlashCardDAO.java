package com.example.demo.dao;

import com.example.demo.entity.FlashCard;

import java.util.List;

public interface FlashCardDAO {
    List<FlashCard> findAllFlashCards();
    FlashCard findById(int ID);
    void save(FlashCard newFlashCard);
    void deleteFlashCardById(int ID);
}
