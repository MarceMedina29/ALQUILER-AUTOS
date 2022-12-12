package co.edu.unab.apirestaa.repositorios;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.UsuarioModelo;

@Repository
public interface UsuarioRepositorio extends MongoRepository <UsuarioModelo, String>{
    
    List<UsuarioModelo> findByUsuario(String usuario); //keywords for query methods
    List<UsuarioModelo> findByEstado(Boolean estado);

    @Query("{'rolId':?0}")
    List<UsuarioModelo> buscarPorRolId(String rolId);

    @Query("{personaId:{$lt:?0}}")
    List<UsuarioModelo>buscarPorPersonaId(String personaId);

}
