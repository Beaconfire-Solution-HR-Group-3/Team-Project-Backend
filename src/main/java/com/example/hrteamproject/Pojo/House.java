package com.example.hrteamproject.Pojo;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class House {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "contact_id")
  private Contact contact;

  @Column
  private String address;

  @Column
  private int numberOfPerson;


  @OneToMany(mappedBy = "house", fetch = FetchType.LAZY)
  private List<Employee> employeeList;

  @OneToMany(mappedBy = "house", fetch = FetchType.LAZY)
  private List<Facility> facilityList;

//  @OneToMany(mappedBy = "house", fetch = FetchType.LAZY)
//  private List<FacilityReport> facilityReportList;
}
