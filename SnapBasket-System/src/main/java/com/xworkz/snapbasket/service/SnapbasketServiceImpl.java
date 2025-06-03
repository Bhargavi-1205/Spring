package com.xworkz.snapbasket.service;

import com.xworkz.snapbasket.dto.SnapbasketDto;
import com.xworkz.snapbasket.entity.SnapbasketEntity;
import com.xworkz.snapbasket.repo.SnapbasketRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SnapbasketServiceImpl implements SnapbasketService{
    @Autowired
    SnapbasketRepo repo;
    @Override
    public String saveData(SnapbasketDto dto) {
        String isSaved=null;
        if(dto!=null){
            SnapbasketEntity entity = new SnapbasketEntity();
            BeanUtils.copyProperties(dto,entity);
           boolean checkSave =  repo.saveData(entity);
           if(checkSave){
              isSaved ="Data saved to database";
           }

        }
        return isSaved;
    }

    @Override
    public List<SnapbasketDto> getAll() {
        List<SnapbasketEntity> entityList = repo.getAll();
        List<SnapbasketDto> dtoList = new ArrayList<>();
        System.out.println("SnapbasketEntity "+entityList.size());
        entityList.stream().forEach(
                entity->{
                    SnapbasketDto snapbasketDto = new SnapbasketDto();
                    BeanUtils.copyProperties(entity, snapbasketDto);

                    dtoList.add(snapbasketDto);
                    System.out.println("SnapbasketDto "+snapbasketDto);
                }
        );
        return dtoList;
    }

    @Override
    public SnapbasketDto getNameById(int requestedIdFromFrontEnd) {
        SnapbasketDto snapbasketDto = new SnapbasketDto();
        System.out.println("invoking dto class "+snapbasketDto);
        if(requestedIdFromFrontEnd !=0){
            SnapbasketEntity snapbasketEntity= repo.getNameById(requestedIdFromFrontEnd);
            BeanUtils.copyProperties(snapbasketEntity, snapbasketDto);
        }
        System.out.println("service :"+snapbasketDto);
        return snapbasketDto;
    }

    @Override
    public void updateById(SnapbasketDto dto) {
        if(dto!=null){
            SnapbasketEntity entity = repo.getNameById(dto.getId());
            BeanUtils.copyProperties(dto,entity);
            repo.updateById(entity);
        }
    }

}
