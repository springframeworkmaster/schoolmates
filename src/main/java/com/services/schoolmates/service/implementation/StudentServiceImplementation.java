package com.services.schoolmates.service.implementation;
import com.services.schoolmates.dto.SchoolmateDto;
import com.services.schoolmates.repository.SchoolmateRepository;
import lombok.AllArgsConstructor;
import com.services.schoolmates.entity.Schoolmate;
import com.services.schoolmates.exception.ResourceNotFoundException;
import com.services.schoolmates.mapper.SchoolmateMapper;
import com.services.schoolmates.service.SchoolmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImplementation implements SchoolmateService {
    @Autowired
    private SchoolmateRepository studentRepository;

    @Override
    public SchoolmateDto createSchoolmate(SchoolmateDto studentDto) {
        Schoolmate schoolmate = SchoolmateMapper.mapToStudent(studentDto);

        Schoolmate savedSchoolmate =  studentRepository.save(schoolmate);
        return SchoolmateMapper.mapToStudentDto(savedSchoolmate);
    }

    @Override
    public SchoolmateDto getSchoolmateById(Long studentId) {
       Schoolmate schoolmate = studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student was not found with given id: " + studentId));
        return SchoolmateMapper.mapToStudentDto(schoolmate);
    }

    @Override
    public List<SchoolmateDto> getAllSchoolmates() {
       List<Schoolmate> schoolmateList =  studentRepository.findAll();
        return schoolmateList.stream()
                .map(SchoolmateMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public SchoolmateDto updateSchoolmate(Long studentId, SchoolmateDto schoolmateDto) {
        Schoolmate schoolmate = studentRepository.findById(studentId).orElseThrow(()->
                new ResourceNotFoundException("Student was not found with given id: " + studentId));

        schoolmate.setFirstName(schoolmateDto.getFirstName());
        schoolmate.setLastName(schoolmateDto.getLastName());
        schoolmate.setPhone(schoolmateDto.getPhone());
        schoolmate.setCurrentCity(schoolmateDto.getCurrentCity());
        schoolmate.setProfession(schoolmateDto.getProfession());
        schoolmate.setComments(schoolmateDto.getComments());
        schoolmate.setDob(schoolmateDto.getDob());

        Schoolmate savedSchoolmate = studentRepository.save(schoolmate);
        return SchoolmateMapper.mapToStudentDto(savedSchoolmate);
    }

    @Override
    public void deleteSchoolmate(Long schoolmateId) {
        Schoolmate schoolmate = studentRepository.findById(schoolmateId).orElseThrow(()->
                new ResourceNotFoundException("Student was not found with given id: " + schoolmateId));
        studentRepository.deleteById(schoolmateId);
    }
}
