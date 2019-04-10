package com.sb.sprbthib.dao;

import com.sb.sprbthib.entity.Taart;

import java.util.List;

public interface ITaartDAO {
    void addTaart(Taart taart);
    List<Taart> getAllTaarten();
    boolean taartExists(String name, String owner);
    Taart getTaartById(int taartId);
    void updateTaart(Taart taart);
    void deleteTaart(int taartId);
}
