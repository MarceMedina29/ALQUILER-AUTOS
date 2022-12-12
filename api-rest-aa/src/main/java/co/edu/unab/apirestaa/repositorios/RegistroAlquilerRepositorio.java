package co.edu.unab.apirestaa.repositorios;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.RegistroAlquilerModelo;

@Repository
public interface RegistroAlquilerRepositorio extends MongoRepository <RegistroAlquilerModelo, String>{
    List<RegistroAlquilerModelo> findByFechaSolicitud(LocalDate fechaSolicitud); //keywords for query methods

    @Query("{'fechaentrega':?0}")
    List<RegistroAlquilerModelo>buscarPorFechaEntrega(LocalDate fechaEntrega); 

    @Query("{fecharecibido:{$lt:?0}}")
    List<RegistroAlquilerModelo>buscarRegistroAlquilerPorFechaRecibido(LocalDate fechaRecibido);

    @Query("{estadopago:{$lt:?0}}")
    List<RegistroAlquilerModelo>buscarRegistroAlquilerPorEstadoPago(Boolean estadoPago);
}
