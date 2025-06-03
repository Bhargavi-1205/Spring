package com.xworkz.snapbasket.repo;

import com.xworkz.snapbasket.entity.SnapbasketEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public interface SnapbasketRepo {

    boolean saveData(SnapbasketEntity entity);
    List<SnapbasketEntity> getAll();
    SnapbasketEntity getNameById(int id);
    void updateById(SnapbasketEntity snapbasketEntity);

}