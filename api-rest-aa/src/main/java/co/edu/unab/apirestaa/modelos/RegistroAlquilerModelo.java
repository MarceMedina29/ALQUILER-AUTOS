package co.edu.unab.apirestaa.modelos;

import java.sql.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("RegistroAlquiler")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class RegistroAlquilerModelo {
    
    @Id
    private String id;
    @Field("fechaSolicitud")
    private Date fechaSolicitud;
    @Field("fechaEntrega")
    private Date fechaEntrega;
    @Field("fechaRecibido")
    private Date fechaRecibido;
    @Field("KilometrajeEntrega")
    private Integer KilometrajeEntrega;
    @Field("KilometrajeRecibido")
    private Integer KilometrajeRecibido;
    @Field("descripcion")
    private String descripcion;
    @Field("valoraPagar")
    private Integer valoraPagar;
    @Field("estadoPago")
    private Boolean estadoPago;
    @DBRef
    private AutosModelo AutosId;
    @DBRef
    private PersonasModelo ClienteId;
    @DBRef
    private PersonasModelo ResponsableId;

}
