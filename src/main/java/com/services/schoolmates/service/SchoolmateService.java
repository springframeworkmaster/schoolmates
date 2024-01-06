package com.services.schoolmates.service;
import com.services.schoolmates.dto.SchoolmateDto;

import java.util.List;

public interface SchoolmateService {
    SchoolmateDto createSchoolmate(SchoolmateDto studentDto);
    SchoolmateDto getSchoolmateById(Long studentId);
    List<SchoolmateDto> getAllSchoolmates();
    SchoolmateDto updateSchoolmate(Long studentId, SchoolmateDto studentDto);
    void deleteSchoolmate(Long studentId);
}
