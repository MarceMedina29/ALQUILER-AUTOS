package co.edu.unab.apirestaa.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.MarcaAutosModelo;

@Repository
public interface MarcaAutosRepositorio extends MongoRepository <MarcaAutosModelo, String>{
    List<MarcaAutosModelo> findByNombreMarca(String nombreMarca); //keywords for query methods

    @Query("{'estado':?0}")
    List<MarcaAutosModelo>buscarPorEstado(Boolean estado); 
}
