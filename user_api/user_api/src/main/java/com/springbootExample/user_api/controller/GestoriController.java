package com.springbootExample.user_api.controller;

import com.springbootExample.user_api.model.Gestori;
import com.springbootExample.user_api.model.User;
import com.springbootExample.user_api.service.GestoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gestori")
@CrossOrigin(origins = "*")
public class GestoriController {

    @Autowired
    private GestoriService gestoriService;

    @GetMapping("/all")
    public ResponseEntity<List<Gestori>> getAllGestori(){
        return ResponseEntity.ok(gestoriService.getAllGestori());
    }

    @PostMapping("/save")
    public ResponseEntity<Gestori> saveUser(@RequestBody Gestori gestore){
        return ResponseEntity.ok(gestoriService.saveGestore(gestore));
    }
}
