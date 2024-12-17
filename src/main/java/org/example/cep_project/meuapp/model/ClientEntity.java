package org.example.cep_project.meuapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "Client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String street;
    private String zip;
    private String country;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> ordens;
}
