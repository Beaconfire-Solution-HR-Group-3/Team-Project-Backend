package com.example.hrteamproject.Pojo;
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
public class ApplicationWorkFlow {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @OneToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Column
  private String createdDate;

  @Column
  private String modificationDate;

  @Column
  private String status;

  @Column
  private String comments;




}
