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
@Table(name="Gastos")
@NamedStoredProcedureQuery(
    name= "inserirGasto",
    procedureName= "economias..Gerar_movimento_saida",
    parameters= {
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_user",
            type= Integer.class
        ),

        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "desc_gasto",
            type= String.class
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "valor",
            type= Double.class
        )
        }
)
@NamedStoredProcedureQuery(
    name= "alterarMovimentacaoGasto",
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
    name= "removerMovimentoGasto",
    procedureName= "Remover_movimento",
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
public class GastosDto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @JsonProperty("id_user")
    private Long idUser;

    @Getter
    @Setter
    @JsonProperty("desc_gasto")
    private String descGasto;
    
    @Getter
    @Setter
    private double valor;
}