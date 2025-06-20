package api.economias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.economias.dtos.UserDto;
import api.economias.services.UsuariosService;


@RestController
@RequestMapping
public class User {

    @Autowired
    private UsuariosService usuariosService;


    @GetMapping("/verUsuarios")
    public ResponseEntity<List<UserDto>> verUsuarios(){
        List<UserDto> all_users = usuariosService.veUsuarios();

        return ResponseEntity.status(HttpStatus.OK).body(all_users);
    }
}