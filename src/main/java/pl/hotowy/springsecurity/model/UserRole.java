package pl.hotowy.springsecurity.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String role;
}
