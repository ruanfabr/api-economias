package api.economias.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Historico")
public class HistoricoDto {

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
    @JsonProperty("id_movimentacao")
    private Long idMovimentacao;

    @Getter
    @Setter
    @JsonProperty("dt_movimentacao")
    private String dtMovimentacao;

    @Getter
    @Setter
    @JsonProperty("tipo_movimentacao")
    private char tipoMovimentacao;
}
