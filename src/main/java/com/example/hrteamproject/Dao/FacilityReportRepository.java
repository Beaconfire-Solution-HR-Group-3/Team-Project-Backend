package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Pojo.FacilityReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacilityReportRepository extends CrudRepository<FacilityReport,String> {

    List<FacilityReport> findAll();
    FacilityReport findById(int id);
}
