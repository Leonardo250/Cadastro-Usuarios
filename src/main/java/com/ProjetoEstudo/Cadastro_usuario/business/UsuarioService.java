package com.ProjetoEstudo.Cadastro_usuario.business;
import com.ProjetoEstudo.Cadastro_usuario.infrastruture.entitys.Usuario;
import com.ProjetoEstudo.Cadastro_usuario.infrastruture.repository.UsarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsarioRepository repository;

    public UsuarioService(UsarioRepository repository) {
        this.repository = repository;
    }

    // salvando usuarios
    public  void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);

    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }
    // salvando/ atualizando

    public void atualizarUsuarioPorID(Integer id,Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}

