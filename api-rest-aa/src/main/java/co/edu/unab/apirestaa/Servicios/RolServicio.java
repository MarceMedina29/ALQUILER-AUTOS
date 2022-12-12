package co.edu.unab.apirestaa.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.RolModelo;
import co.edu.unab.apirestaa.repositorios.RolRepositorio;

@Service
public class RolServicio {
    @Autowired
    RolRepositorio rolRepositorio;

    public String guardarRol(RolModelo rol){
        rol.setNombreRol(rol.getNombreRol().toLowerCase());
        boolean estado=rol.getId()==null||!rolRepositorio.existsById(rol.getId());
        rolRepositorio.save(rol);
        if(estado){
            return "Se Guardo el Rol";
        }else{
            return"Se Actualizo el Rol";
        }
    }
        
    public List<RolModelo> getListRolOrder(){
        List<RolModelo> listaRol = rolRepositorio.findAll();
        listaRol.sort(Comparator.comparing(RolModelo::getNombreRol));
        return listaRol;

    }

    public Optional<RolModelo> getRolById(String id) {
        return rolRepositorio.findById(id);
    }

    public List<RolModelo> getRolByNombreRol(String nombreRol){
        return rolRepositorio.findByNombreRol(nombreRol);
    }

    public String eliminarRolPorId(String id) {
        if (rolRepositorio.existsById(id)) {
            Optional<RolModelo> rol = rolRepositorio.findById(id);
            rolRepositorio.deleteById(id);
            return "Rol " + rol.get().getNombreRol() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

    public List<RolModelo> rolByEstado(Boolean estado){
        return rolRepositorio.buscarPorEstado(estado);
    }

}
