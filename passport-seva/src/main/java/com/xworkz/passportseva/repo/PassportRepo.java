package com.xworkz.passportseva.repo;

import com.xworkz.passportseva.entity.PassportEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PassportRepo {


    String save(PassportEntity passportEntity);
    List<PassportEntity> getAll();
    PassportEntity getNameById(int id);
    void updateById(PassportEntity passportEntity);
    void deleteById(int id);


}
