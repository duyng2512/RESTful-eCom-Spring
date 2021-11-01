package com.modern.api.controller;

import com.modern.api.entity.CardEntity;
import com.modern.api.hateoas.CardRepresentationModelAssembler;
import com.modern.api.service.inf.CardService;
import com.opw.modern.api.AddressApi;
import com.opw.modern.api.CardApi;
import com.opw.modern.api.CartApi;
import com.opw.modern.api.model.AddCardReq;
import com.opw.modern.api.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CardController implements CardApi {

    private final CardService cardService;
    private final CardRepresentationModelAssembler assembler;

    public CardController(CardService cardService, CardRepresentationModelAssembler assembler) {
        this.cardService = cardService;
        this.assembler = assembler;
    }

    @Override
    public ResponseEntity<Void> deleteCardById(String id) {
        cardService.deleteCardById(id);
        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<Card>> getAllCards() {
        return new ResponseEntity<>(assembler.toListModel(cardService.getAllCards()),
                                    HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Card> getCardById(String id) {

        return cardService.getCardById(id)
                          .map(assembler::toModel)
                          .map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                          .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Card> registerCard(@Valid AddCardReq addCardReq) {
        return cardService.registerCard(addCardReq)
                          .map(assembler::toModel)
                          .map(model -> new ResponseEntity<>(model, HttpStatus.CREATED))
                          .orElse(new ResponseEntity<>(null, HttpStatus.CONFLICT));
    }
}
