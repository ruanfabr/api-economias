package api.economias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import api.economias.dtos.GanhosDto;

public interface GanhosRepository extends JpaRepository<GanhosDto, Long> {

    
    @Procedure(name= "inserirGanho")
    void inserir_movimento_ganho(
        @Param("id_user") Long id_user,
        @Param("desc_ganho") String desc_ganho,
        @Param("valor") float valor,
        @Param("id_categoria") Integer id_categoria,
        @Param("auto_guardar") int auto_guardar,
        @Param("id_cofre") Integer id_cofre
    );
}