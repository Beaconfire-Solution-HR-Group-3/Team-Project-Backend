package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.DigitalDocument;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DigitalDocumentRepository extends CrudRepository<DigitalDocument, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM digital_document d WHERE d.required = true order by d.id")
    List<DigitalDocument> getAll();

}
