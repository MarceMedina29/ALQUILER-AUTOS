package co.edu.unab.apirestaa.controladores;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unab.apirestaa.Servicios.PermisosRolServicio;
import co.edu.unab.apirestaa.modelos.PermisosRolModelo;

@RestController
@RequestMapping("/PermisosRol")
@CrossOrigin(origins = "*")
public class PermisosRolControlador {
    
    @Autowired
    PermisosRolServicio permisosRolServicio;

    @GetMapping()
    public List<PermisosRolModelo> getallPermisosRolOrder(){
        return permisosRolServicio.getListPermisosRolOrder();
    }

    @GetMapping("/{id}")
    public Optional<PermisosRolModelo> findPermisosRolByID(@PathVariable("id") String id){
        return permisosRolServicio.getPermisosRolById(id);
    }

    @GetMapping("/query") 
    public List<PermisosRolModelo> getPermisosRolByNombreDelPermiso(@RequestParam("nombreDelPermiso") String nombreDelPermiso){
        return permisosRolServicio.getPermisosRolByNombreDelPermiso(nombreDelPermiso); 
    }

    @GetMapping("/rutaPermiso/query")
    public List<PermisosRolModelo> listPermisosRolRutaPermiso(@PathVariable("rutaPermiso") String rutaPermiso){
        return permisosRolServicio.permisosRolByRutaPermiso(rutaPermiso);
    }
    @GetMapping("/rolId/{rolId}")
    public List<PermisosRolModelo> listPermisosRolRolId(@PathVariable("rolId") String rolId){
        return permisosRolServicio.permisosRolByRolId(rolId);
    }
    
    @PostMapping()
    public String savePermisosRol(@RequestBody PermisosRolModelo permisosRol){
        return permisosRolServicio.guardarPermisosRol(permisosRol);
    }

    @DeleteMapping("/{id}")
    public String deletePermisosRolById(@PathVariable("id")String id){
        return permisosRolServicio.eliminarPermisosRolPorId(id);
            
    }
}
