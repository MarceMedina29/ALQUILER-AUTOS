package co.edu.unab.apirestaa.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("MarcaAutos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MarcaAutosModelo {
    @Id
    private String id;
    @Field("nombreMarca")
    private String nombreMarca;
    @Field("estado")
    private Boolean estado;
}
