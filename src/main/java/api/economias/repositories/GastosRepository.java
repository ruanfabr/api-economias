package api.economias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import api.economias.dtos.GastosDto;

public interface GastosRepository extends JpaRepository<GastosDto, Long> {

    @Query(value= """
    SELECT 
    tab1.id, desc_gasto, valor_gasto, dt_movimentacao
    FROM dbo.Gastos tab1
    INNER JOIN dbo.Historico tab2 ON tab1.id = tab2.id_movimentacao
    WHERE tab1.id_categoria = :idCategoria
    AND tab2.id_user = :idUser
    AND tab2.tipo_movimentacao = 'S'
    """, nativeQuery= true)
    List<Object> procurarPorCategoria(Long idUser, Long idCategoria);

    @Procedure(name="inserirGasto")
    void inserir_movimento_gasto(
        @Param("id_user") Long id_user,
        @Param("desc_gasto") String desc_gasto,
        @Param("valor") double valor,
        @Param("id_categoria") Long id_categoria
    );
}
