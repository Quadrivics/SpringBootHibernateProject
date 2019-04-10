package com.sb.sprbthib.dao;

import com.sb.sprbthib.entity.Taart;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class TaartDAO implements ITaartDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTaart(Taart taart) {
        entityManager.persist(taart);
    }

    @Override
    public boolean taartExists(String name, String owner) {
        String jpql = "FROM Taart WHERE name = ?0 and owner = ?1";
        int count = entityManager.createQuery(jpql)
                .setParameter(0, name)
                .setParameter(1, owner)
                .getResultList()
                .size();
        return count > 0;
    }

    @Override
    public List<Taart> getAllTaarten() {
        String query = "select t from Taarten t order by t.naam";
        return (List<Taart>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public Taart getTaartById(int taartId) {
        return entityManager.find(Taart.class, taartId);
    }

    @Override
    public void updateTaart(Taart taart) {
        Taart trt = getTaartById(taart.getId());
        trt.setName(taart.getName());
        trt.setDescription(taart.getDescription());
        trt.setOwner(taart.getOwner());
        entityManager.flush();
    }

    @Override
    public void deleteTaart(int taartId) {
        entityManager.remove(getTaartById(taartId));
    }

}
