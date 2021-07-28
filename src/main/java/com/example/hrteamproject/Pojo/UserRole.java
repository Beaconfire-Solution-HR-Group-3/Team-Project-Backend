package com.example.hrteamproject.Pojo;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;


public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name="role_id")
  private Role role;

  @Column
  private boolean activeFlag;

  @Column
  private String createDate;

  @Column
  private String lastModificationDate;

  @Column
  private String lastModificationUser;


}
