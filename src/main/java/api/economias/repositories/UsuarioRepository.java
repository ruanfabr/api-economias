package api.economias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.economias.dtos.UserDto;

public interface UsuarioRepository extends JpaRepository<UserDto, Long> {}