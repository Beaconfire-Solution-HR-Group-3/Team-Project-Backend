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

public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToOne(mappedBy = "employee")
  private Address address;

  @OneToOne(mappedBy = "employee")
  private ApplicationWorkFlow applicationWorkFlow;

  @Column
  private int managerId;

  @ManyToOne
  @JoinColumn(name = "house_id")
  private House house;

  @OneToMany(mappedBy = "employee")
  private List<FacilityReportDetail> facilityReportDetailList;

  @OneToMany(mappedBy = "employee")
  private List<PersonalDocument> personalDocumentList;

  @OneToOne(mappedBy = "employee")
  private VisaStatus visaStatus;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String middleName;

  @Column
  private String preferedName;

  @Column
  private String email;

  @Column
  private int cellphone;

  @Column
  private String alternatePhone;

  @Column
  private String gender;

  @Column
  private String ssn;

  @Column
  private String dob;

  @Column
  private String title;

  @Column
  private String startDate;

  @Column
  private String endDate;

  @Column
  private String avartar;

  @Column
  private String car;

  @Column
  private String driverLisence;

  @Column
  private String driverLisenceExpirationDate;


  public Employee(int id, User user, Address address, ApplicationWorkFlow applicationWorkFlow, int managerId, House house, List<FacilityReportDetail> facilityReportDetailList, List<PersonalDocument> personalDocumentList, VisaStatus visaStatus, String firstName, String lastName, String middleName, String preferedName, String email, int cellphone, String alternatePhone, String gender, String ssn, String dob, String title, String startDate, String endDate, String avartar, String car, String driverLisence, String driverLisenceExpirationDate) {
    this.id = id;
    this.user = user;
    this.address = address;
    this.applicationWorkFlow = applicationWorkFlow;
    this.managerId = managerId;
    this.house = house;
    this.facilityReportDetailList = facilityReportDetailList;
    this.personalDocumentList = personalDocumentList;
    this.visaStatus = visaStatus;
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.preferedName = preferedName;
    this.email = email;
    this.cellphone = cellphone;
    this.alternatePhone = alternatePhone;
    this.gender = gender;
    this.ssn = ssn;
    this.dob = dob;
    this.title = title;
    this.startDate = startDate;
    this.endDate = endDate;
    this.avartar = avartar;
    this.car = car;
    this.driverLisence = driverLisence;
    this.driverLisenceExpirationDate = driverLisenceExpirationDate;
  }
}
