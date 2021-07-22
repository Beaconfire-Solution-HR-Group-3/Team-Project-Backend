package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.DigitalDocument;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocumentRepository extends CrudRepository<DigitalDocument,String> {
    List<DigitalDocument> findAll();
    DigitalDocument findByTitle(String title);
}
