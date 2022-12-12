package co.edu.unab.apirestaa.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("PermisosRolModelo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PermisosRolModelo {
    @Id
    private String id;
    @Field("nombreDelPermiso")
    private String nombreDelPermiso;
    @Field("rutaPermiso")
    private String rutaPermiso;
    @Field("estado")
    private Boolean estado;
    @DBRef
    private RolModelo rolId;

}
