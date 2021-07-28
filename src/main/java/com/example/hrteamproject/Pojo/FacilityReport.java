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

public class FacilityReport {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @JsonBackReference(value="a")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "facility_id")
  private Facility facility;

  @JsonManagedReference(value="user-movement")
  @OneToMany(mappedBy = "facilityReport",fetch = FetchType.LAZY)
  private List<FacilityReportDetail> facilityReportDetailList;

  @Column
  private String title;

  @Column
  private String reportDate;

  @Column
  private String description;

  @Column
  private Status status;




}
