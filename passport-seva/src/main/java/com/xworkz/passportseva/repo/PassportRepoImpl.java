package com.xworkz.passportseva.repo;

import com.xworkz.passportseva.dto.PassportDto;
import com.xworkz.passportseva.entity.PassportEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


@Repository
public class PassportRepoImpl implements PassportRepo{
    @Override
    public String save(PassportEntity passportEntity) {
        System.out.println("Invoking save method");
       EntityManager em = Persistence.createEntityManagerFactory("passport").createEntityManager();
       em.getTransaction().begin();
       em.persist(passportEntity);
        System.out.println("Data Inserted"+passportEntity);
        em.getTransaction().commit();

        return "save";
    }

    @Override
    public List<PassportEntity> getAll() {
        System.out.println("invoking repo");
        return Persistence.createEntityManagerFactory("passport").
                createEntityManager().createNamedQuery("getAll").getResultList();
    }

    @Override
    public PassportEntity getNameById(int requestedIdFromFrontEnd) {
        System.out.println("invoking repo class ");
        return (PassportEntity) Persistence.createEntityManagerFactory("passport").
                createEntityManager().createNamedQuery("findNameById").setParameter("id",requestedIdFromFrontEnd).getSingleResult();
    }

    @Override
    public void updateById(PassportEntity passportEntity) {
        EntityManager em = Persistence.createEntityManagerFactory("passport").createEntityManager();
        em.getTransaction().begin();
        em.merge(passportEntity);
        em.getTransaction().commit();

    }

    @Override
    public void deleteById(int id) {
       EntityManager em = Persistence.createEntityManagerFactory("passport").createEntityManager();
       em.getTransaction().begin();
       em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
       em.getTransaction().commit();

    }


}

