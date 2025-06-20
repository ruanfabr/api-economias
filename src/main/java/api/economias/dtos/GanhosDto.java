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
        // Id_categoria 
        @StoredProcedureParameter(
            mode= ParameterMode.IN,
            name= "id_categoria",
            type= Integer.class
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
        )
        }
)
public class GanhosDto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @JsonProperty("id_user")
    private Long idUser;

    @Getter
    @Setter
    @JsonProperty("desc_ganho")
    private String descGanho;
    
    @Getter
    @Setter
    private double valor;
    
    @Getter
    @Setter
    @JsonProperty("id_categoria")
    private Long idCategoria;
    
    @Getter
    @Setter
    @JsonProperty("auto_guardar")
    private int autoGuardar;
    
    @Getter
    @Setter
    @JsonProperty("id_cofre")
    private Integer idCofre;
}
