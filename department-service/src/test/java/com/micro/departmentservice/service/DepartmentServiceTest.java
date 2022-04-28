package com.micro.departmentservice.service;

import com.micro.departmentservice.data.Department;
import com.micro.departmentservice.repository.DepartmentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departRepo;
    private DepartmentService underTest;

    @BeforeEach
    void setUp() {

        underTest = new DepartmentService(departRepo);
    }

    @Test
    void CanCreateDepart() {

        //Given

        Department depart = new Department();
        //long id =1;
        depart.setDepartId(1L);
        depart.setDepartName("Java");
        depart.setDepartCode("Java-450");
        depart.setDepartAddress("Gishushu");

        //When
        underTest.createDepart(depart);

        //then

       // ArgumentCaptor<Department> departmentArgumentCaptor = ArgumentCaptor.forClass(Department.class);

        verify(departRepo).save(depart);

      //  Department capturedDepart = departmentArgumentCaptor.getValue();

       // assertThat(capturedDepart).isEqualTo(depart);
    }
    @Test
    @Disabled
    void canFindAllDepartments() {
        //when
        underTest.findAllDepartments();
        //then
        verify(departRepo).findAll();

    }

    @Test
    @Disabled
    void testFindDerpatById() {
    }
}