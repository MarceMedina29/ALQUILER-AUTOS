package co.edu.unab.apirestaa.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UsuarioModelo {
    @Id
    private String id;
    @Field("usuario")
    private String usuario;
    @Field("contraseña")
    private Long contraseña;
    @Field("estado")
    private Boolean estado;
    @DBRef
    private PersonasModelo personaId;
    @DBRef
    private RolModelo rolId;
    
}
