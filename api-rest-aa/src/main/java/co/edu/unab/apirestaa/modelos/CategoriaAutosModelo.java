package co.edu.unab.apirestaa.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("CategoriaAutos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CategoriaAutosModelo {
    
    @Id
    private String id;
    @Field("nombreCategoria")
    private String nombreCategoria;
    @Field("estado")
    private Boolean estado;
    
}
