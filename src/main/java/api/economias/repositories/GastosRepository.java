package api.economias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import api.economias.dtos.GastosDto;

public interface GastosRepository extends JpaRepository<GastosDto, Long> {

    @Procedure(name="inserirGasto")
    void inserir_movimento_gasto(
        @Param("id_user") long id_user,
        @Param("desc_gasto") String desc_gasto,
        @Param("valor") double Valor,
        @Param("id_categoria") Integer id_categoria
    );
}