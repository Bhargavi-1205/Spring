package com.xworkz.passportseva.service;


import com.xworkz.passportseva.dto.PassportDto;
import com.xworkz.passportseva.entity.PassportEntity;
import com.xworkz.passportseva.repo.PassportRepo;
import com.xworkz.passportseva.repo.PassportRepoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PassServiceImpl implements PassportService {

    @Autowired
    PassportRepo repo;

    @Override
    public String saveDto(PassportDto dto) {
        System.out.println("Invoking saveDto method");

        if (dto != null) {
            PassportEntity entity = new PassportEntity();
            entity.setPassportOffice(dto.getPassportOffice());
            entity.setGivenName(dto.getGivenName());
            entity.setSurName(dto.getSurName());
            entity.setDob(dto.getDob());
            entity.setEmail(dto.getEmail());
            entity.setLoginId(dto.getLoginId());
            entity.setPassword(dto.getPassword());
            entity.setConfirmPassword(dto.getConfirmPassword());
            entity.setHintQuestion(dto.getHintQuestion());
            entity.setHintAnswer(dto.getHintAnswer());
            System.out.println("service entity " + dto);
            repo.save(entity);
        }
        return "data saved";
    }

    @Override
    public List<PassportDto> getAll() {
        List<PassportEntity> entityList = repo.getAll();
        List<PassportDto> dtoList = new ArrayList<>();
        System.out.println("PassportEntity "+entityList.size());
        entityList.stream().forEach(
                entity->{
                    PassportDto passportDto = new PassportDto();
                    BeanUtils.copyProperties(entity,passportDto);

                    dtoList.add(passportDto);
                    System.out.println("Passport Dto "+passportDto);
                }
        );


     return dtoList;

    }

      @Override
    public PassportDto getNameById(int requestedIdFromFrontEnd) {
        PassportDto passportDto = new PassportDto();
        System.out.println("invoking dto class "+passportDto);
        if(requestedIdFromFrontEnd !=0){
            PassportEntity passportEntity = repo.getNameById(requestedIdFromFrontEnd);
            BeanUtils.copyProperties(passportEntity, passportDto);
        }
        System.out.println("service :"+passportDto);
        return passportDto;
    }

    @Override
    public void updateById(PassportDto dto) {
        if(dto!=null){
            PassportEntity entity = repo.getNameById(dto.getId());
            BeanUtils.copyProperties(dto,entity);
            repo.updateById(entity);
        }
    }

    @Override
    public void deleteById(int id) {
        if(id!=0){
            repo.deleteById(id);
            System.out.println("Delete Invoked");
        }
    }


}