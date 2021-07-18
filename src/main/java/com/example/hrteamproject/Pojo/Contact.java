package com.example.hrteamproject.Pojo;
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
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @Column
  private String fisrtName;
  @Column
  private String lastName;
  @Column
  private String email;
  @Column
  private int cellphone;

  @Column(name = "employee_id")
  private int employeeId;

  @OneToMany(mappedBy = "contact")
  private List<House> houseList;


  @Column
  private String relationship;

  @Column
  private String title;

  @Column
  private boolean isReference;

  @Column
  private boolean isEmergency;

  @Column
  private boolean isLandlord;



}
