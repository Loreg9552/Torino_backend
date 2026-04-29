package com.springbootExample.user_api.service;

import com.springbootExample.user_api.model.Book;
import com.springbootExample.user_api.model.Immobili;
import com.springbootExample.user_api.model.User;
import com.springbootExample.user_api.repository.ImmobiliRepository;
import com.springbootExample.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImmobiliService {

    @Autowired
    private ImmobiliRepository immobiliRepository;

    @Autowired
    private UserRepository userRepository;

    public Immobili saveImmobile(Immobili immobile){
        if (immobile.getOwner() != null && immobile.getOwner().getId() != null) {
            User owner = userRepository.findById(immobile.getOwner().getId())
                    .orElseThrow(() -> new RuntimeException("Utente non trovato"));
            immobile.setOwner(owner);
        }

        return immobiliRepository.save(immobile);
    }

    public List<Immobili> getAllImmobili(){
        return immobiliRepository.findAll();
    }
}
