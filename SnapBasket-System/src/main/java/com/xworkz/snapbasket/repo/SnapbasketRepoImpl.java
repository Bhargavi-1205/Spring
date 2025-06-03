package com.xworkz.snapbasket.repo;

import com.xworkz.snapbasket.entity.SnapbasketEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

@Repository
public class SnapbasketRepoImpl implements SnapbasketRepo{


    @Override
    public boolean saveData(SnapbasketEntity entity) {

        boolean isSaved=false;
        if(entity!=null){
            EntityManager em = Persistence.createEntityManagerFactory("snapbasket").createEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            isSaved=true;
        }
        return isSaved;
    }

    @Override
    public List<SnapbasketEntity> getAll() {
        System.out.println("invoking repo");
        return Persistence.createEntityManagerFactory("snapbasket").
                createEntityManager().createNamedQuery("getAll").getResultList();
    }

    @Override
    public SnapbasketEntity getNameById(int requestedIdFromFrontEnd) {
        System.out.println("invoking repo class ");
        return (SnapbasketEntity) Persistence.createEntityManagerFactory("snapbasket").
                createEntityManager().createNamedQuery("findNameById").setParameter("id",requestedIdFromFrontEnd).getSingleResult();

    }

    @Override
    public void updateById(SnapbasketEntity snapbasketEntity) {
        EntityManager em = Persistence.createEntityManagerFactory("snapbasket").createEntityManager();
        em.getTransaction().begin();
        em.merge(snapbasketEntity);
        em.getTransaction().commit();


    }
}

