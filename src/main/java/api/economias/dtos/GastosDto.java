package api.economias.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Getter;
import lombok.Setter;

@Entity
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
        ),
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_categoria",
            type= Integer.class
        )
    }
)
public class GastosDto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @JsonProperty("id_user")
    private Long idUser;

    @Getter
    @Setter
    @JsonProperty("desc_gasto")
    private String descGasto;
    
    @Getter
    @Setter
    private double valor;

    @Getter
    @Setter
    @JsonProperty("id_categoria")
    private Long idCategoria;
}