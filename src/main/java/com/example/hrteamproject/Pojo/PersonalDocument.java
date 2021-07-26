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
public class PersonalDocument {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Column
  private String path;

  @Column
  private String title;

  @Column
  private String comment;

  @Column
  private String createDate;

}
