package co.edu.unab.apirestaa.repositorios;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.RolModelo;


@Repository
public interface RolRepositorio extends MongoRepository <RolModelo, String>{
    List<RolModelo> findByNombreRol(String nombreRol); //keywords for query methods

    @Query("{'estado':?0}")
    List<RolModelo>buscarPorEstado(Boolean estado); 


}
