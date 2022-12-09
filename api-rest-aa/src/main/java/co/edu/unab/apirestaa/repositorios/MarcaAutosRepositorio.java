package co.edu.unab.apirestaa.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.MarcaAutosModelo;

@Repository
public interface MarcaAutosRepositorio extends MongoRepository <MarcaAutosModelo, String>{
    
}
