package com.learn.school.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FullSchoolResponse {
    private String name;
    private String email;

    List<Student> students;


}
