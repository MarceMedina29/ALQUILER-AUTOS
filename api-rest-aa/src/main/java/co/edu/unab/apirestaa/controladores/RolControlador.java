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
import co.edu.unab.apirestaa.Servicios.RolServicio;
import co.edu.unab.apirestaa.modelos.RolModelo;

@RestController
@RequestMapping("/Personas")
@CrossOrigin(origins = "*")
public class RolControlador {
    @Autowired
    RolServicio rolServicio;

    @GetMapping()
    public List<RolModelo> getallRolOrder(){
        return rolServicio.getListRolOrder();
    }

    @GetMapping("/{id}")
    public Optional<RolModelo> findRolByID(@PathVariable("id") String id){
        return rolServicio.getRolById(id);
    }

    @GetMapping("/query") 
    public List<RolModelo> getRolByNombreRol(@RequestParam("nombreRol") String nombreRol){
        return rolServicio.getRolByNombreRol(nombreRol); 
    }
    
    public List<RolModelo> listRolEstado(@PathVariable("estado") Boolean estado){
        return rolServicio.rolByEstado(estado);
    }
    
    @PostMapping()
    public String saveRol(@RequestBody RolModelo rol){
        return rolServicio.guardarRol(rol);
    }

    @DeleteMapping("/{id}")
    public String deleteRolById(@PathVariable("id")String id){
        return rolServicio.eliminarRolPorId(id);
            
    }
}
