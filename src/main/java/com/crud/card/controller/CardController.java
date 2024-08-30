package com.crud.card.controller;

import java.util.List;
import com.crud.card.model.Card;
import com.crud.card.model.ServiceResponse;
import com.crud.card.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @autor Walter Morales
 */
@RestController
@RequestMapping("/api/v1/card")
@CrossOrigin("*")
public class CardController {

    @Autowired
    private ICardService idCardService;

    @GetMapping("/list")
    public ResponseEntity<List<Card>> list() {
        var result = idCardService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Card card) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = idCardService.save(card);
        if (result == 1) {
            serviceResponse.setSuccess(true);
            serviceResponse.setMessage("Item saved with success");
        } else {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Failed to save item");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
    
    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Card card){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = idCardService.update(card);
        if(result == 1){
            serviceResponse.setSuccess(true);
            serviceResponse.setMessage("Item updated with success");
        } else {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Failed to update item");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
    
    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = idCardService.deleteById(id);
        if(result == 1){
            serviceResponse.setSuccess(true);
            serviceResponse.setMessage("Item removed with success");
        } else {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage("Failed to remove item");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome to the Card Application!", HttpStatus.OK);
    }
}