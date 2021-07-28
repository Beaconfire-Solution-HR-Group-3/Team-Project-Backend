package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.Employee;
import com.example.hrteamproject.Pojo.House;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepositoty extends CrudRepository<House,String> {


    List<House> findAll();
    House findById(int id);

    // 还没测试这里：1.不知道能否解决lazy fatch。2.可以优化这个join。
    @Query(nativeQuery = true, value = "SELECT * FROM house h " +
            "join facility f on h.id = f.house_id " +
            "join employee e on h.id = e.house_id WHERE h.id = ?")
    public House findByIdAndFetchFacilityAndEmployeesEagerly(@Param("id") int id);




}
