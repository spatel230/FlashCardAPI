package com.example.demo.rest;

import com.example.demo.dao.FlashCardDAO;
import com.example.demo.entity.FlashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping(path="/flashcard")
public class FlashCardController {
    private FlashCardDAO flashCardDAO;

    @Autowired
    public FlashCardController(@Qualifier("flashCardIMPL") FlashCardDAO flashCardDAO) {
        this.flashCardDAO = flashCardDAO;
    }
    @GetMapping("retrieveAllFlashCards")
    public List<FlashCard> findAllFlashCards(){
        return flashCardDAO.findAllFlashCards();
    }
    @GetMapping("retrieveById/{flashCardId}")
    public FlashCard findUserById(@PathVariable int flashCardId){
        return (FlashCard) flashCardDAO.findById(flashCardId);
    }
    @PostMapping("/addFlashCard")
    public FlashCard addUser(@RequestBody FlashCard newFlashCard){
        newFlashCard.setId(0);
        flashCardDAO.save(newFlashCard);
        return newFlashCard;
    }
    @PostMapping("/updateFlashCard")
    public FlashCard updateFlashCard(@RequestBody FlashCard updatedFlashCard) {
        flashCardDAO.save(updatedFlashCard);
        return updatedFlashCard;
    }
    @DeleteMapping("/deleteUser/{FlashCardId}")
    public String deleteUser(@PathVariable int FlashCardId){
        flashCardDAO.deleteFlashCardById(FlashCardId);
        return "Deleted User Id: "+FlashCardId;
    }
}
