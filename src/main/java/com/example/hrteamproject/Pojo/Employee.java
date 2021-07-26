package com.example.hrteamproject.Pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
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

  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  @JsonManagedReference
  @OneToOne(mappedBy = "employee", cascade=CascadeType.ALL)
  private Address address;

  @OneToOne(mappedBy = "employee")
  private ApplicationWorkFlow applicationWorkFlow;

  @Column
  private int managerId;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "house_id")
  private House house;

  @JsonManagedReference
  @OneToMany(mappedBy= "employee", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
  private  List<Contact> contactList;

  @OneToMany(mappedBy = "employee")
  private List<FacilityReportDetail> facilityReportDetailList;

  @JsonManagedReference
  @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
  private List<PersonalDocument> personalDocumentList;

  @JsonManagedReference
  @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
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
  private String cellphone;

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

}
