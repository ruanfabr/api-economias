package api.economias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.economias.dtos.UserDto;
import api.economias.repositories.UsuarioRepository;

@Service
public class UsuariosService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UserDto> veUsuarios(){
        return usuarioRepository.findAll();
    }
}
