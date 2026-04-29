package com.springbootExample.user_api.controller;

import com.springbootExample.user_api.model.Immobili;
import com.springbootExample.user_api.service.ImmobiliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/immobili")
public class ImmobiliController {

    @Autowired
    private ImmobiliService immobiliService;

    @GetMapping("/all")
    public ResponseEntity<List<Immobili>> getAllImmobili(){
        return ResponseEntity.ok(immobiliService.getAllImmobili());
    }

    @PostMapping("/save")
    public ResponseEntity<Immobili> saveBook(@RequestBody Immobili immobili){
        return ResponseEntity.ok(immobiliService.saveImmobile(immobili));
    }

}
