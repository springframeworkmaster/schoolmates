package com.services.schoolmates.mapper;
import com.services.schoolmates.dto.SchoolmateDto;
import com.services.schoolmates.entity.Schoolmate;

public class SchoolmateMapper {
    public static SchoolmateDto mapToStudentDto(Schoolmate schoolmate) {
        return new SchoolmateDto(
          schoolmate.getId(),
          schoolmate.getFirstName(),
          schoolmate.getLastName(),
          schoolmate.getPhone(),
          schoolmate.getCurrentCity(),
          schoolmate.getProfession(),
          schoolmate.getComments(),
          schoolmate.getDob()
        );
    }

    public static Schoolmate mapToStudent(SchoolmateDto schoolmateDto) {
        Schoolmate schoolmate = new Schoolmate();
        schoolmate.setId(schoolmateDto.getId());
        schoolmate.setFirstName(schoolmateDto.getFirstName());
        schoolmate.setLastName(schoolmateDto.getLastName());
        schoolmate.setPhone(schoolmateDto.getPhone());
        schoolmate.setCurrentCity(schoolmateDto.getCurrentCity());
        schoolmate.setProfession(schoolmateDto.getProfession());
        schoolmate.setComments(schoolmateDto.getComments());
        schoolmate.setDob(schoolmateDto.getDob());
        return schoolmate;
    }
}
