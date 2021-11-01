package com.modern.api.service.inf;

import com.modern.api.entity.CardEntity;
import com.opw.modern.api.model.AddCardReq;

import javax.validation.Valid;
import java.util.Optional;

public interface CardService {

    public void deleteCardById(String id);

    public Iterable<CardEntity> getAllCards();

    public Optional<CardEntity> getCardById(String id);

    public Optional<CardEntity> registerCard(@Valid AddCardReq req);

}
