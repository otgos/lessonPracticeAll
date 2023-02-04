package com.tpe.dto;

import com.tpe.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    @NotNull(message = "firstName cannot be null")
    @NotBlank(message = "firstName cannot be white space")
    @Size(min=2, max=25, message="First name '${validatedValue} must be between {min} and {max} long")

    // repo layer, validator will be checked in controller layer... it is double check
    private String name;

    private String lastName;
    private Integer grade;

    @Email(message = "provide valid email")
    private String email;
    private String phoneNumber;

    private LocalDateTime createdDate = LocalDateTime.now();

    public StudentDTO (Student student){ //StudentDTO std1 = new StudentDTO(student)
        this.id = student.getId();
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.grade = student.getGrade();
        this.phoneNumber = student.getPhoneNumber();
        this.email = student.getEmail();
        this.createdDate = student.getCreatedDate();
    }
}
