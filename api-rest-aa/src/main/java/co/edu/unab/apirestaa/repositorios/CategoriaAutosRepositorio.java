package co.edu.unab.apirestaa.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.CategoriaAutosModelo;

@Repository
public interface CategoriaAutosRepositorio extends MongoRepository <CategoriaAutosModelo, String>{
    
}
