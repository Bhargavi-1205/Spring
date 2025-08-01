package com.xworkz.passportseva.service;

import com.xworkz.passportseva.dto.PassportDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PassportService {
    String saveDto(PassportDto dto);
    List<PassportDto> getAll();
    PassportDto getNameById(int requestedIdFromFrontEnd);
    void updateById(PassportDto dto);
    void deleteById(int id);


}
