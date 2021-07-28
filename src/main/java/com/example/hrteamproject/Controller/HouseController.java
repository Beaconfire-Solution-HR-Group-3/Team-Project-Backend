package com.example.hrteamproject.Controller;


import com.example.hrteamproject.Dao.EmployeeRepository;
import com.example.hrteamproject.Dao.FacilityReportDetailRepository;
import com.example.hrteamproject.Dao.FacilityReportRepository;
import com.example.hrteamproject.Dao.HouseRepositoty;
import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Pojo.FacilityReport;
import com.example.hrteamproject.Pojo.FacilityReportDetail;
import com.example.hrteamproject.Pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HouseController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    HouseRepositoty houseRepositoty;

    @Autowired
    FacilityReportRepository facilityReportRepository;

    @Autowired
    FacilityReportDetailRepository facilityReportDetailRepository;

    @CrossOrigin
    @GetMapping("/House")
    public @ResponseBody
    ResponseEntity<List<House>> getAllHouse(){
        List<House> houseList = houseRepositoty.findAll();
        return ResponseEntity.ok(houseList);
    }

    @CrossOrigin
    @GetMapping("/House/{email}")
    public @ResponseBody
    ResponseEntity<House> getHouseByEmail(@PathVariable String email){
        House h = employeeRepository.findByEmailAndFetchHouseEagerly(email).getHouse();
        int id = h.getId();
        return ResponseEntity.ok(houseRepositoty.findById(id));
    }


    @CrossOrigin
    @GetMapping("/reports")
    public @ResponseBody
    ResponseEntity<List<FacilityReport>> getFacilityReport(){
        List<FacilityReport> facilityReportList = facilityReportRepository.findAll();
        return ResponseEntity.ok(facilityReportList);
    }


    @CrossOrigin
    @PostMapping("/reports")
    public @ResponseBody
    ResponseEntity writeFacilityReport(@RequestBody FacilityReport facilityReport){
        facilityReportRepository.save(facilityReport);
        return ResponseEntity.ok("");
    }

    @CrossOrigin
    @PostMapping("/comment/{id}")
    public @ResponseBody
    ResponseEntity writeComment(@RequestBody FacilityReportDetail facilityReportDetail, @PathVariable int id){
        FacilityReport facilityReport = facilityReportRepository.findById(id);
        facilityReportDetail.setFacilityReport(facilityReport);
        facilityReportDetailRepository.save(facilityReportDetail);
        return ResponseEntity.ok("");
    }

    @CrossOrigin
    @PostMapping("/reportDetail")
    public @ResponseBody
    ResponseEntity<List<FacilityReportDetail>> getReportDetail(@RequestBody FacilityReport facilityReport){
        return ResponseEntity.ok(facilityReportDetailRepository.findByFacilityReportId(facilityReport.getId()));
    }
}
