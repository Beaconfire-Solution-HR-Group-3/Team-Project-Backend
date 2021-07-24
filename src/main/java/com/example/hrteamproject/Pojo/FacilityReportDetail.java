package com.example.hrteamproject.Pojo;import lombok.AllArgsConstructor;
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

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "report_id")
  private FacilityReport facilityReport;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Column
  private String comments;

  @Column
  private String createDate;

  @Column
  private String lastModificationDate;



}
