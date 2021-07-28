package com.example.hrteamproject.Pojo;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class RegistrationToken {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  private String token;

  @Column
  private String validDuration;

  @Column
  private String email;

  @Column
  private String createdBy;


  public RegistrationToken(String token, String validDuration, String email, String createdBy) {
    this.token = token;
    this.validDuration = validDuration;
    this.email = email;
    this.createdBy = createdBy;
  }
}
