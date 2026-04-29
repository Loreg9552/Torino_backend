package com.springbootExample.user_api.service;

import com.springbootExample.user_api.model.Gestori;
import com.springbootExample.user_api.model.User;
import com.springbootExample.user_api.repository.GestoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestoriService {
    @Autowired
    private GestoriRepository gestoriRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Gestori> getAllGestori(){
        return gestoriRepository.findAll();
    }

    public Gestori saveGestore(Gestori gestore){
        gestore.setPassword(passwordEncoder.encode(gestore.getPassword()));
        return gestoriRepository.save(gestore);
    }

}
