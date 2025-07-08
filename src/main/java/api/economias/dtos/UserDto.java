package api.economias.dtos;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Usuarios")
@Getter
@Setter
// public class UserDto implements Serializable {
public class UserDto implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String senha;

    @JsonProperty("media_ganho")
    private double mediaGanho;

    @JsonProperty("media_gasto")
    private double mediaGasto;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
        // throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }

    @Override
    public String getUsername() {
        return nome;
        // throw new UnsupportedOperationException("Unimplemented method 'getUsername'");
    }
}
