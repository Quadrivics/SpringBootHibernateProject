package com.sb.sprbthib.service;

import com.sb.sprbthib.dao.ITaartDAO;
import com.sb.sprbthib.entity.Taart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaartService implements ITaartService {

    @Autowired
    private ITaartDAO taartDAO;

    @Override
    public synchronized boolean addTaart(Taart taart) {
        if(taartDAO.taartExists(taart.getName(), taart.getOwner())) {
            return false;
        } else{
            taartDAO.addTaart(taart);
            return true;
        }
    }

    @Override
    public Taart getTaartById(int taartId) {
        return taartDAO.getTaartById(taartId);
    }

    @Override
    public List<Taart> getAllTaarten() {
        return taartDAO.getAllTaarten();
    }

    @Override
    public void updateTaart(Taart taart) {
        taartDAO.updateTaart(taart);
    }

    @Override
    public void deleteTaart(int taartId) {
        taartDAO.deleteTaart(taartId);
    }
}
