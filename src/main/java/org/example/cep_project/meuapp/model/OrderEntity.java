package org.example.cep_project.meuapp.model;


import jakarta.persistence.*;

@Entity
@Table(name= "Order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantidade_itens;
    private Long valor_total;
    @ManyToOne
    @JoinColumn(name = "client_id") // Nome da coluna de chave estrangeira
    private ClientEntity client;

}
