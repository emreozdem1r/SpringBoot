package com.junit.student;

import com.junit.exception.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    public void canGetAllStudents() {
        // when
        studentService.getAllStudents();
        // then
        verify(studentRepository).findAll();
    }
    @Test
    public void canAddStudent() {
        // given
        String email = "john@gmail.com";
        Student student = new Student("John" , email, Gender.MALE);

        // when
        studentService.addStudent(student);
        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    public void willThrownEmailIsTaken() {
        // given
        String email = "john@gmail.com";
        Student student = new Student("John" , email, Gender.MALE);

        // when
        given(studentRepository.selectExistsEmail(email)).willReturn(true);

        // then
        assertThatThrownBy(() -> studentService.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");
    }
}
