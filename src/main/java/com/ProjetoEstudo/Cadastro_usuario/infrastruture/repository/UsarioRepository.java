package com.ProjetoEstudo.Cadastro_usuario.infrastruture.repository;

import com.ProjetoEstudo.Cadastro_usuario.infrastruture.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
