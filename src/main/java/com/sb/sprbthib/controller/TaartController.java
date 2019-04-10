package com.sb.sprbthib.controller;

import com.sb.sprbthib.entity.Taart;
import com.sb.sprbthib.service.ITaartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/taartinator")
public class TaartController {

    @Autowired
    private ITaartService taartService;

    @PostMapping("/taart")
    public ResponseEntity<Void> addTaart(@RequestBody Taart taart, UriComponentsBuilder builder) {

    boolean flag = taartService.addTaart(taart);
    if(!flag) return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("taart/{id}").buildAndExpand(taart.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/taart/{id}")
    public ResponseEntity<Taart> getTaartById(@PathVariable("id") Integer id) {
        Taart trt = taartService.getTaartById(id);
        return new ResponseEntity<Taart>(trt, HttpStatus.OK);
    }

    @PutMapping("/taart")
    public ResponseEntity<Taart> updateTaart(@RequestBody Taart taart) {
        taartService.updateTaart(taart);
        return new ResponseEntity<Taart>(taart, HttpStatus.OK);
    }

    @DeleteMapping("/taart/{id}")
    public ResponseEntity<Void> deleteTaart(@PathVariable("id") Integer id) {
        taartService.deleteTaart(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
