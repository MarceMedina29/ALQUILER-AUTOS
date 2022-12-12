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
import co.edu.unab.apirestaa.Servicios.PersonasServicio;
import co.edu.unab.apirestaa.modelos.PersonasModelo;

@RestController
@RequestMapping("/Personas")
@CrossOrigin(origins = "*")
public class PersonasControlador {
    
    @Autowired
    PersonasServicio personasServicio;

    @GetMapping()
    public List<PersonasModelo> getallPersonasOrder(){
        return personasServicio.getListPersonasOrder();
    }

    @GetMapping("/{id}")
    public Optional<PersonasModelo> findPersonasByID(@PathVariable("id") String id){
        return personasServicio.getPersonasById(id);
    }

    @GetMapping("/query") // ejemplo: http://localhost:8080/personas/query?apellidos=medina
    public List<PersonasModelo> getPersonasByApellidos(@RequestParam("apellidos") String apellidos){
        return personasServicio.getPersonasByApellidos(apellidos); 
    }
    
    @PostMapping()
    public String savePersonas(@RequestBody PersonasModelo personas){
        return personasServicio.guardarPersonas(personas);
    }

    @DeleteMapping("/{id}")
    public String deletePersonasById(@PathVariable("id")String id){
        return personasServicio.eliminarPersonasPorId(id);
            
    }
}
