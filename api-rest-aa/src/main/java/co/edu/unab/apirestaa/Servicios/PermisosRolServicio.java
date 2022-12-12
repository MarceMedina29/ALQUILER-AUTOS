package co.edu.unab.apirestaa.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.PermisosRolModelo;
import co.edu.unab.apirestaa.repositorios.PermisosRolRepositorio;

@Service
public class PermisosRolServicio {
    @Autowired
    PermisosRolRepositorio permisosRolRepositorio;

    public String guardarPermisosRol(PermisosRolModelo permisosRol){
        permisosRol.setNombreDelPermiso(permisosRol.getNombreDelPermiso().toLowerCase());
        permisosRol.setRutaPermiso(permisosRol.getRutaPermiso().toLowerCase());
        boolean estado=permisosRol.getId()==null||!permisosRolRepositorio.existsById(permisosRol.getId());
        permisosRolRepositorio.save(permisosRol);
        if(estado){
            return "Se Guardo la Persona";
        }else{
            return"Se Actualizo la Persona";
        }
    }
        
    public List<PermisosRolModelo> getListPermisosRolOrder(){
        List<PermisosRolModelo> listaPermisosRol = permisosRolRepositorio.findAll();
        listaPermisosRol.sort(Comparator.comparing(PermisosRolModelo::getNombreDelPermiso));
        return listaPermisosRol;

    }

    public Optional<PermisosRolModelo> getPermisosRolById(String id) {
        return permisosRolRepositorio.findById(id);
    }

    public List<PermisosRolModelo> getPermisosRolByNombreDelPermiso(String nombreDelPermiso){
        return permisosRolRepositorio.findByNombreDelPermiso(nombreDelPermiso);
    }

    public String eliminarPermisosRolPorId(String id) {
        if (permisosRolRepositorio.existsById(id)) {
            Optional<PermisosRolModelo> permisosRol = permisosRolRepositorio.findById(id);
            permisosRolRepositorio.deleteById(id);
            return "Permiso Rol " + permisosRol.get().getNombreDelPermiso() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

    public List<PermisosRolModelo> permisosRolByRutaPermiso(String rutaPermiso){
        return permisosRolRepositorio.buscarPorRutaPermiso(rutaPermiso);
    }

    public List<PermisosRolModelo>permisosRolByRolId(String rolId){
        return permisosRolRepositorio.buscarPermisoRolPorRolId(rolId);
    }    
}
