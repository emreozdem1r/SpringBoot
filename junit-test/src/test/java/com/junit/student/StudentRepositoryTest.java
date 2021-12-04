package com.junit.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        String email = "john@gmail.com";
        Student student = new Student("John" , email, Gender.MALE);
        this.studentRepository.save(student);

        Boolean isExistsEmail = this.studentRepository.selectExistsEmail(email);
        assertThat(isExistsEmail).isTrue();
    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        String email = "john@gmail.com";

        Boolean isExistsEmail = this.studentRepository.selectExistsEmail(email);
        assertThat(isExistsEmail).isFalse();
    }
}