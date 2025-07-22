package api.economias.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Ganhos")
@Getter
@Setter
@NamedStoredProcedureQuery(
    name = "inserirGanho",
    procedureName= "economias..Gerar_movimento_entrada",
    parameters= {
        //  Id_user
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_user",
            type= Long.class
            ),
        // Desc_ganho
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "desc_ganho",
            type= String.class
        ),
        // Valor 
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "valor",
            type= Double.class
        ),
        // Auto_guardar
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "auto_guardar",
            type= Integer.class
        ),
        // Id_categoria 
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_cofre",
            type= Integer.class
        ),
        // Id_categoria 
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_categoria",
            type= Integer.class
        )
        }
)

@NamedStoredProcedureQuery(
    name= "alterarMovimentacaoGanho",
    procedureName= "alterar_dado_movimentacao",
    parameters= {
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_movimentacao",
            type= Long.class
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_user",
            type= Long.class
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "tipo_movimentacao",
            type= Character.class
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "valor",
            type= Double.class
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "descricao_movimentacao",
            type= String.class
        )
    }
)
@NamedStoredProcedureQuery(
    name= "removerMovimentoGanho",
    procedureName= "economias..Remover_movimento",
    parameters= {
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_movimentacao",
            type= Long.class
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_user",
            type= Long.class
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "tipo_movimentacao",
            type= Character.class
        )
    }
)
public class GanhosDto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("id_user")
    private Long idUser;

    @JsonProperty("desc_ganho")
    private String descGanho;
    
    private Double valor;
    
    @JsonProperty("auto_guardar")
    private Integer autoGuardar;
    
    @JsonProperty("id_cofre")
    private Long idCofre;

    @JsonProperty("id_categoria")
    private Integer idCategoria;

    @JsonProperty("dt_movimentacao")
    private String dtMovimentacao;

    public interface EntradaMesAtual {
        Long getId();
        String getDesc_ganho();
        Double getValor();
        Long getId_cofre();
        Integer getId_categoria();
        String getDt_movimentacao();
    }
}
