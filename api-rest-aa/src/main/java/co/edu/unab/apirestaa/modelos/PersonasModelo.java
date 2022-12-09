package co.edu.unab.apirestaa.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("Personas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PersonasModelo {
    @Id
    private String id;
    @Field("tipodedocumento")
    private String tipodedocumento;
    @Field("numerodedocumento")
    private Long numerodedocumento;
    @Field("nombres")
    private String nombres;
    @Field("apellidos")
    private String apellidos;
    @Field("correo")
    private String correo;
    @Field("telefono")
    private Long telefono;
    @Field("direccion")
    private Object direccion;
    @Field("licenciadeconduccion")
    private Boolean licenciadeconduccion;
    @Field("numerodelicencia")
    private Long numerodelicencia;
    @Field("estado")
    private Boolean estado;

    }
