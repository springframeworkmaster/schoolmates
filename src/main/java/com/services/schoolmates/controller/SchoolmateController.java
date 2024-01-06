package com.services.schoolmates.controller;
import com.services.schoolmates.dto.SchoolmateDto;
import lombok.AllArgsConstructor;
import com.services.schoolmates.service.SchoolmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/schoolmates")
@AllArgsConstructor
public class SchoolmateController {
    @Autowired
    private SchoolmateService schoolmateService;
    @PostMapping
    public ResponseEntity<SchoolmateDto> createSchoolmate(@RequestBody SchoolmateDto SchoolmateDto) {
       SchoolmateDto savedSchoolmate =  schoolmateService.createSchoolmate(SchoolmateDto);
       return new ResponseEntity<>(savedSchoolmate, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SchoolmateDto> getSchoolmateById(@PathVariable("id") Long schoolmateId) {
       SchoolmateDto SchoolmateDto = schoolmateService.getSchoolmateById(schoolmateId);
       return new ResponseEntity<>(SchoolmateDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<SchoolmateDto>> getAllSchoolmates() {
       List<SchoolmateDto> SchoolmateDtoList =  schoolmateService.getAllSchoolmates();
       return new ResponseEntity<>(SchoolmateDtoList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<SchoolmateDto> updateSchoolmate(@PathVariable("id") Long schoolmateId,
                                                       @RequestBody SchoolmateDto SchoolmateDto) {
       SchoolmateDto newSchoolmateDto =  schoolmateService.updateSchoolmate(schoolmateId, SchoolmateDto);
       return new ResponseEntity<>(newSchoolmateDto, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSchoolmate(@PathVariable("id") Long schoolmateId) {
        schoolmateService.deleteSchoolmate(schoolmateId);
        return new ResponseEntity<>("Schoolmate was successfully deleted", HttpStatus.OK);
    }
}
