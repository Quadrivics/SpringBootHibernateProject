package com.sb.sprbthib.service;

import com.sb.sprbthib.entity.Taart;

public interface ITaartService {
    boolean addTaart(Taart taart);
    Taart getTaartById(int taartId);
    void updateTaart(Taart taart);
    void deleteTaart(int taartId);
}
