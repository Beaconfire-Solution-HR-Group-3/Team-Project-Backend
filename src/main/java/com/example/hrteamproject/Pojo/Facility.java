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

public class Facility {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "house_id")
  private House house;

  @JsonManagedReference(value="a")
  @OneToMany(mappedBy = "facility", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
  private List<FacilityReport> facilityReportList;

  @Column
  private String type;

  @Column
  private String description;

  @Column
  private int quantity;


}
