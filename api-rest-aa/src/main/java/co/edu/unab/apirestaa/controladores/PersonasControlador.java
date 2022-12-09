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
import org.springframework.web.bind.annotation.RestController;
import co.edu.unab.apirestaa.modelos.PersonasModelo;
import co.edu.unab.apirestaa.repositorios.PersonasRepositorio;

@RestController
@RequestMapping("/Personas")
@CrossOrigin(origins = "*")
public class PersonasControlador {
    
    @Autowired
    PersonasRepositorio personasRepositorio;

    @GetMapping()
    public List<PersonasModelo> getallPersonas(){
        return personasRepositorio.findAll();
    }
    @PostMapping()
    public PersonasModelo savePersonas(@RequestBody PersonasModelo personas){
        return personasRepositorio.save(personas);
    }

    @DeleteMapping("/{id}")
    public String deletePersonasById(@PathVariable("id")String id){
        
        if(personasRepositorio.existsById(id)){
            Optional <PersonasModelo> personas = personasRepositorio.findById(id);
            personasRepositorio.deleteById(id);
            return "Personas" + personas.get().getNombres()+"Eliminado";
        }else{
            return "No Eliminado";
        }
            
    }
}
