package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Pojo.PersonalDocument;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalDocumentRepositoty extends CrudRepository<PersonalDocument,String> {

    List<PersonalDocument> findAllByEmployeeBeforeOrderByIdAsc(Employee employee);
    int countAllByEmployee(Employee employee);
}
