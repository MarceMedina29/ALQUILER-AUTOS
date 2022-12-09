package co.edu.unab.apirestaa.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestaa.modelos.AutosModelo;

@Repository
public interface AutosRepositorio extends MongoRepository <AutosModelo, String>{
    
}
