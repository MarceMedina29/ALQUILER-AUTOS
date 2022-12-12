package co.edu.unab.apirestaa.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.CategoriaAutosModelo;

@Repository
public interface CategoriaAutosRepositorio extends MongoRepository <CategoriaAutosModelo, String>{
    List<CategoriaAutosModelo> findByNombreCategoria(String nombreCategoria); //keywords for query methods

    @Query("{'estado':?0}")
    List<CategoriaAutosModelo>buscarPorEstado(Boolean estado); 
}
