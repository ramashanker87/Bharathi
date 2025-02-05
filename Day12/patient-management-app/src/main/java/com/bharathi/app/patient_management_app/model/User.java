package com.patient_management_app.com.patient_management_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor  // Required for Hibernate
@AllArgsConstructor
@ToString
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @Column(nullable = false)
  private String name;
  @Column(unique = true, nullable = false)
  private String schoolName;
  @Column(nullable = false)
  private String gender;
  @Column(nullable = false)
}

