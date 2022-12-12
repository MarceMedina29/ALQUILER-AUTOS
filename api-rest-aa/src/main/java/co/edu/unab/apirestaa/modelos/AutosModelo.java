package co.edu.unab.apirestaa.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("Autos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AutosModelo {
    @Id
    private String id;
    @Field("placa")
    private String placa;
    @Field("numeroPasajeros")
    private Integer numeroPasajeros;
    @Field("estado")
    private Boolean estado;
    @Field("estadoPrestamo")
    private Boolean estadoPrestamo;
    @DBRef
    private CategoriaAutosModelo categoriaAutosId;
    @DBRef
    private MarcaAutosModelo marcaAutosId;

}
