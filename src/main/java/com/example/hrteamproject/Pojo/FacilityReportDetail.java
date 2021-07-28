package com.example.hrteamproject.Pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class FacilityReportDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @JsonBackReference(value="user-movement")
  @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
  @JoinColumn(name = "report_id")
  private FacilityReport facilityReport;

  @JsonBackReference(value="b")
  @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Column
  private String comments;

  @Column
  private String createDate;

  @Column
  private String lastModificationDate;



}
