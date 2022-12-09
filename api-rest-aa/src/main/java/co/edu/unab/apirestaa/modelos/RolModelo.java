package co.edu.unab.apirestaa.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("RolModelo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RolModelo {
    @Id
    private String id;
    @Field("nombreRol")
    private String nombreRol;
    @Field("estado")
    private Boolean estado;

}
