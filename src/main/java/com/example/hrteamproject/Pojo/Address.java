package com.example.hrteamproject.Pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @JsonBackReference
  @OneToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Column
  private String addressLine1;
  @Column
  private String addressLine2;
  @Column
  private String city;
  @Column
  private int zipcode;
  @Column
  private String stateName;
  @Column
  private String stateAbbr;




}
