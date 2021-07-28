package com.example.hrteamproject.Pojo;import lombok.AllArgsConstructor;
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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  private String userName;
  @Column
  private String email;
  @Column
  private String password;
  @Column
  private String createDate;
  @Column
  private String modificationDate;

  @OneToOne(mappedBy = "user")
  private Employee employee;

  @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
  @JoinTable(name = "user_role",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roleList;



}
