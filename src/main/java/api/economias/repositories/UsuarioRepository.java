package api.economias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.economias.dtos.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {}