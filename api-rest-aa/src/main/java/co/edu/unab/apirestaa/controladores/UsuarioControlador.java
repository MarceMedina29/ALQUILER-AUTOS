package co.edu.unab.apirestaa.controladores;

import co.edu.unab.apirestaa.modelos.UsuarioModelo;
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
import org.springframework.web.bind.annotation.RestController;
import co.edu.unab.apirestaa.Servicios.UsuarioServicio;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping()
    public List<UsuarioModelo> getAllUsuarioOrden(){
        return usuarioServicio.getListUsuarioOrden();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModelo> findUsuarioByID(@PathVariable("id") String id){
        return usuarioServicio.getUsuarioById(id);
    }

    @GetMapping("/query") 
    public List<UsuarioModelo> getUsuarioByEstado(@PathVariable("apellido") Boolean estado){
        return usuarioServicio.getUsuarioByEstado(estado); 
    }

    @PostMapping()
    public String saveUsuario(@RequestBody UsuarioModelo usuario){
        return usuarioServicio.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public String deleteUsuarioById(@PathVariable("id") String id){
       return usuarioServicio.eliminarUsuarioPorId(id);
    }

}

