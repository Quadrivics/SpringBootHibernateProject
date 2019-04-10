package com.sb.sprbthib.service;

import com.sb.sprbthib.entity.Taart;

import java.util.List;

public interface ITaartService {
    boolean addTaart(Taart taart);
    List<Taart> getAllTaarten();
    Taart getTaartById(int taartId);
    void updateTaart(Taart taart);
    void deleteTaart(int taartId);
}
