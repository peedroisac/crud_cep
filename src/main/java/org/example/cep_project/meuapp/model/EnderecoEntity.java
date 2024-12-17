package org.example.cep_project.meuapp.model;


import jakarta.persistence.*;

@Entity
@Table(name= "Endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
