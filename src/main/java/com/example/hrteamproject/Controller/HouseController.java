package com.example.hrteamproject.Controller;


import com.example.hrteamproject.Dao.FacilityReportRepository;
import com.example.hrteamproject.Dao.HouseRepositoty;
import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Pojo.FacilityReport;
import com.example.hrteamproject.Pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HouseController {

    @Autowired
    HouseRepositoty houseRepositoty;

    @Autowired
    FacilityReportRepository facilityReportRepository;

    @CrossOrigin
    @GetMapping("/House")
    public @ResponseBody
    ResponseEntity<List<House>> getAllHouse(){
        List<House> houseList = houseRepositoty.findAll();
        return ResponseEntity.ok(houseList);
    }

    @CrossOrigin
    @GetMapping("/House/{id}")
    public @ResponseBody
    ResponseEntity<House> getHouseDetail(@PathVariable int id){
        return ResponseEntity.ok(houseRepositoty.findByIdAndFetchFacilityAndEmployeesEagerly(id));
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
    @PostMapping("/reportDetail")
    public @ResponseBody
    ResponseEntity<FacilityReport> getReportDetail(@RequestBody FacilityReport facilityReport){
        return ResponseEntity.ok(facilityReportRepository.findByIdAndFetchDetailEagerly(facilityReport.getId()));
    }
}