package api.economias.dtos;

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
            type= Float.class
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
    private Long id_user;

    @Getter
    @Setter
    private String desc_ganho;
    
    @Getter
    @Setter
    private float valor;
    
    @Getter
    @Setter
    private Integer id_categoria;
    
    @Getter
    @Setter
    private int auto_guardar;
    
    @Getter
    @Setter
    private Integer id_cofre;
}
