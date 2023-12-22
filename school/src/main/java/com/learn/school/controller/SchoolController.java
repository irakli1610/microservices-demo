package com.learn.school.controller;


import com.learn.school.entity.School;
import com.learn.school.response.FullSchoolResponse;
import com.learn.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void save(
            @RequestBody School school
            ){{
            schoolService.saveSchool(school);
        }
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllStudents(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }
    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllStudents(
            @PathVariable("school-id") Long schoolId
    ){
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }
}
