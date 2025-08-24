package com.ProjetoEstudo.Cadastro_usuario.infrastruture.entitys;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "name")
    private String nome;

}
