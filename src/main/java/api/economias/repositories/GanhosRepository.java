package api.economias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import api.economias.dtos.GanhosDto;


public interface GanhosRepository extends JpaRepository<GanhosDto, Long> {

    @Query(value= """
        select tab1.id, desc_ganho, valor, auto_guardar, dt_movimentacao
        from dbo.Ganhos tab1
        inner join dbo.Historico tab2 on tab1.id = tab2.id_movimentacao
        where tab2.id_user = :id_user
        and tab1.id_categoria = :id_categoria
        and tab2.tipo_movimentacao = 'E'
    """, nativeQuery= true)
    List<Object> procurarPorCategorias(@Param("id_user") Long idUser, @Param("id_categoria") Long idCategoria);
    
    @Procedure(name= "inserirGanho")
    void inserir_movimento_ganho(
        @Param("id_user") Long id_user,
        @Param("desc_ganho") String desc_ganho,
        @Param("valor") double valor,
        @Param("id_categoria") Long id_categoria,
        @Param("auto_guardar") int auto_guardar,
        @Param("id_cofre") Integer id_cofre
    );
}