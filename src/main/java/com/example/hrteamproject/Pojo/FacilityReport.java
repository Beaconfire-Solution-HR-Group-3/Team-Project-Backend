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

public class FacilityReport {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "facility_id")
  private Facility facility;

  @OneToOne(mappedBy = "facilityReport",fetch = FetchType.LAZY)
  private FacilityReportDetail facilityReportDetail;

  @Column
  private String title;

  @Column
  private String reportDate;

  @Column
  private String description;

  @Column
  private Status status;




}
