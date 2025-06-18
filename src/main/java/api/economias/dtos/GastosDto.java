package api.economias.dtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class GastosDto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private Strinng desc_gasto;
    
    @Getter
    @Setter
    private float valor;

    @Getter
    @Setter
    private Integer id_categoria;
}