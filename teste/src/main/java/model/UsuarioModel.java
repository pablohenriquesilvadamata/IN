package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "integradash")
public class UsuarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String cep;
    private String url_img;

    // Provisóriamente String, será alterado para TipoModel enum
    private String tipo_usuario;

    public void setErro(UsuarioModel usuarioModel) {
    }
}
