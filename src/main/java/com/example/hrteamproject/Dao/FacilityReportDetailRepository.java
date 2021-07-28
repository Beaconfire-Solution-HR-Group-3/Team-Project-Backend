package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.FacilityReport;
import com.example.hrteamproject.Pojo.FacilityReportDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacilityReportDetailRepository extends CrudRepository<FacilityReportDetail,String> {
    List<FacilityReportDetail> findByFacilityReportId(int id);
}
