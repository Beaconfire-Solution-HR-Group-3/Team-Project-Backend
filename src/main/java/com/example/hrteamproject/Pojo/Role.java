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
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToMany(mappedBy = "roleList", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
  //mappedBy的参数是User类里面的被ManyToMany注释的属性名
  private List<User> userList;

  @Column
  private String roleName;

  @Column
  private String description;

  @Column
  private String createDate;

  @Column
  private String lastModificationDate;

  @Column
  private int lastModificationUserId;


}
