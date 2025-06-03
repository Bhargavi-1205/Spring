package com.xworkz.snapbasket.service;

import com.xworkz.snapbasket.dto.SnapbasketDto;

import java.util.List;

public interface SnapbasketService {

    String saveData(SnapbasketDto dto);
    List<SnapbasketDto> getAll();
    SnapbasketDto getNameById(int requestedIdFromFrontEnd);
    void updateById(SnapbasketDto dto);
}
