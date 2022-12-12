package co.edu.unab.apirestaa.repositorios;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestaa.modelos.PermisosRolModelo;

@Repository
public interface PermisosRolRepositorio extends MongoRepository <PermisosRolModelo, String>{
    
    List<PermisosRolModelo> findByNombreDelPermiso(String nombreDelPermiso); //keywords for query methods

    @Query("{'rutaPermiso':?0}")
    List<PermisosRolModelo>buscarPorRutaPermiso(String rutaPermiso); 

    @Query("{rolId:{$lt:?0}}")
    List<PermisosRolModelo>buscarPermisoRolPorRolId(String rolId);
}
