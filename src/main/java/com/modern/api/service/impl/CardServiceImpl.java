package com.modern.api.service.impl;

import com.modern.api.entity.CardEntity;
import com.modern.api.entity.UserEntity;
import com.modern.api.repository.AddressRepository;
import com.modern.api.repository.CardRepository;
import com.modern.api.repository.UserRepository;
import com.modern.api.service.inf.CardService;
import com.opw.modern.api.model.AddCardReq;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public CardServiceImpl(CardRepository cardRepository,
                           UserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void deleteCardById(String id) {
        cardRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public Iterable<CardEntity> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Optional<CardEntity> getCardById(String id) {
        return cardRepository.findById(UUID.fromString(id));
    }

    @Override
    public Optional<CardEntity> registerCard(@Valid AddCardReq req) {
        return Optional.of(cardRepository.save(toEntity(req)));
    }

    private CardEntity toEntity(AddCardReq request) {
        CardEntity cardEntity = CardEntity.builder()
                                          .cvv(request.getCvv())
                                          .expires(request.getExpires())
                                          .number(request.getCardNumber())
                                          .build();
        userRepository.findById(UUID.fromString(request.getUserId()))
                      .ifPresent(cardEntity::setUser);
        return cardEntity;
    }
}
