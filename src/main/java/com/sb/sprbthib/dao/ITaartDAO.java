package com.sb.sprbthib.dao;

import com.sb.sprbthib.entity.Taart;

public interface ITaartDAO {
    void addTaart(Taart taart);
    boolean taartExists(String name, String owner);
    Taart getTaartById(int taartId);
    void updateTaart(Taart taart);
    void deleteTaart(int taartId);
}
