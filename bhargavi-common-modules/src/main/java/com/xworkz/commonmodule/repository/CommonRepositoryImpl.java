package com.xworkz.commonmodule.repository;

import com.xworkz.commonmodule.entity.RegisterEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Slf4j
@Repository
public class CommonRepositoryImpl implements CommonRepository{
    @Autowired
    EntityManagerFactory emf ;
    @Override
    public boolean saveRegister(RegisterEntity entity) {
        log.info("Invoking saveRegister");
        boolean isSaved=false;
        if(entity!=null) {
            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();
            log.info("Data saved to Database :{}", entity.getUserName());
            isSaved = true;
        }
        return isSaved;
    }

    @Override
    public RegisterEntity getRegisterByEmail(String email) {
       // return (RegisterEntity) emf.createEntityManager().createNamedQuery("checkEmail").setParameter("email",email).getSingleResult();

        try {
           return  (RegisterEntity) emf.createEntityManager().createNamedQuery("checkEmail").
                    setParameter("email", email).
                    getSingleResult();
        }catch (Exception e){
            return  null;
        }
    }

    @Override
    public RegisterEntity getRegisterByPhoneNumber(Long mobileNumber) {
        try {
            return (RegisterEntity) emf.createEntityManager().createNamedQuery("ValidateRegisterByPhoneNumber").setParameter("mobileNumber", mobileNumber).getSingleResult();
        } catch (Exception e) {

            return null;
        }

    }

    @Override
    public String updateByOtp(String email , String otp) {
        log.info("Invoke email");

      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
     int num =  em.createNamedQuery("UpdateByOtp").setParameter("newotp",otp).setParameter("email",email).executeUpdate();
        log.info("Getting email{}", email);
        log.info("Getting otp {}", otp);
      em.getTransaction().commit();
      if(num>0){
          return "updated";
      }else{
          return "Not updated";
      }
    }

    @Override
    public RegisterEntity getRegisterById(Integer id) {
        System.out.println(emf.createEntityManager().find(RegisterEntity.class,id));
        return emf.createEntityManager().find(RegisterEntity.class,id);
    }

    @Override
    public boolean updateRegister(RegisterEntity entity) {
        log.info("updateRegister Repo: {}", entity);
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.createNamedQuery("updateRegisterByImageName").setParameter("userName", entity.getUserName()).setParameter("phoneNumber", entity.getPhoneNumber()).setParameter("imageName", entity.getImageName()).setParameter("registerId", entity.getRegisterId()).executeUpdate();
            manager.getTransaction().commit();
           log.info("Data updated successfully for email: {}", entity.getEmail());
            return true;
        } catch (Exception e) {
            log.error("Error updating register", e);
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            return false;
        } finally {
            manager.close();
        }
    }

}
