package co.edu.unab.apirestaa.repositorios;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.PersonasModelo;

@Repository
public interface PersonasRepositorio extends MongoRepository <PersonasModelo, String>{
    List<PersonasModelo> findByApellidos(String apellidos); //keywords for query methods

    @Query("{'numerodelicencia':?0}")
    List<PersonasModelo>buscarPorNumeroDeLicencia(Long numerodelicencia); 

    @Query("{numerodedocumento:{$lt:?0}}")
    List<PersonasModelo>buscarPersonasPorNumeroDeDocumento(Long numerodedocumento);
}
