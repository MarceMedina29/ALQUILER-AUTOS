package co.edu.unab.apirestaa.repositorios;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.AutosModelo;

@Repository
public interface AutosRepositorio extends MongoRepository <AutosModelo, String>{
    List<AutosModelo> findByPlaca(String placa); //keywords for query methods

    @Query("{'numeropasajeros':?0}")
    List<AutosModelo>buscarPorNumeroPasajeros(Integer numeroPasajeros); 

    @Query("{'estado':?0}")
    List<AutosModelo>buscarPorEstado(Boolean estado); 

    @Query("{estadoprestamo:{$lt:?0}}")
    List<AutosModelo>buscarAutosPorEstadoPrestamo(Boolean estadoPrestamo);
}