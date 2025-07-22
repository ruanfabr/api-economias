package api.economias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.economias.dtos.GastosDto;

@Repository
public interface GastosRepository extends JpaRepository<GastosDto, Long> {

    @Query(value= """
    SELECT 
    tab1.id, tab1.desc_gasto, tab1.valor, tab1.pago, tab1.dt_pago, tab2.dt_movimentacao
    FROM dbo.Gastos tab1
    INNER JOIN dbo.Historico tab2 ON tab1.id = tab2.id_movimentacao
    WHERE tab1.desc_gasto = :desc_gasto
    AND tab2.id_user = :id_user
    AND tab2.tipo_movimentacao = 'S'
    """, nativeQuery= true)
    List<Object> procurarPorCategoria(@Param("id_user") Long idUser, @Param("desc_gasto") String descGasto);

    @Procedure(name="inserirGasto")
    void inserir_movimento_gasto(
        @Param("id_user") Long id_user,
        @Param("desc_gasto") String desc_gasto,
        @Param("valor") double valor,
        @Param("pago") int pago,
        @Param("id_categoria") Integer id_categoria,
        @Param("auto_guardar") Integer auto_guardar
    );

    @Procedure(name= "alterarMovimentacaoGasto")
    void alterar_dado_movimentacao(
        @Param("id_movimentacao") Long id,
        @Param("id_user") Long idUser,
        @Param("tipo_movimentacao") char tipoMovimentacao,
        @Param("valor") Double valor,
        @Param("descricao_movimentacao") String descGasto
    );

    @Query(value="""
    SELECT
    id as id,
    desc_gasto as desc_gasto,
    valor as valor,
    id_categoria as id_categoria,
    dt_movimentacao as dt_movimentacao,
    dt_pago as dt_pago
    FROM [economias].[dbo].[saidas_mes_atual]
    WHERE id_user = :id_user
    """, nativeQuery=true)
    List<GastosDto.SaidaMesAtual> ver_saidas_mes_atual(@Param("id_user") Long id_user);
    
    @Procedure(name= "removerMovimentoGasto")
    void remover_movimento_gasto(
        @Param("id_movimentacao") Long id,
        @Param("id_user") Long idUser,
        @Param("tipo_movimentacao")  char tipoMovimentacao
    );
}
