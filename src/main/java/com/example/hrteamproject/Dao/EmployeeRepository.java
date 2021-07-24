package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.Address;
import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Pojo.FacilityReportDetail;
import com.example.hrteamproject.Pojo.VisaStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
    Employee findById(int id);
    Employee findByEmail(String email);
    List<Employee> findAll();

    @Query("SELECT e FROM Employee e JOIN FETCH e.address WHERE e.id = (:id)")
    public Employee findByIdAndFetchAddressEagerly(@Param("id") int id);
    //

//    @Modifying  //需要执行一个更新操作
//    int id, User user, Address address, ApplicationWorkFlow applicationWorkFlow, int managerId, House house, List<FacilityReportDetail> facilityReportDetailList, List<PersonalDocument> personalDocumentList, VisaStatus visaStatus, String firstName, String lastName, String middleName, String preferedName, String email, int cellphone, String alternatePhone, String gender, String ssn, String dob, String title, String startDate, String endDate, String avartar, String car, String driverLisence, String driverLisenceExpirationDate) {
//
//    void updateUsersNameById(String name,Integer id);
}
