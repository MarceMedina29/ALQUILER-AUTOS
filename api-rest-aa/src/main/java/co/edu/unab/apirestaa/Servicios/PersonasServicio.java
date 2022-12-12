package co.edu.unab.apirestaa.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.PersonasModelo;
import co.edu.unab.apirestaa.repositorios.PersonasRepositorio;

@Service
public class PersonasServicio {
    @Autowired
    PersonasRepositorio personasRepositorio;

    public String guardarPersonas(PersonasModelo personas){
        personas.setNombres(personas.getNombres().toLowerCase());
        personas.setApellidos(personas.getApellidos().toLowerCase());
        boolean estado=personas.getId()==null||!personasRepositorio.existsById(personas.getId());
        personasRepositorio.save(personas);
        if(estado){
            return "Se Guardo la Persona";
        }else{
            return"Se Actualizo la Persona";
        }
    }
        
    public List<PersonasModelo> getListPersonasOrder(){
        List<PersonasModelo> listaPersonas = personasRepositorio.findAll();
        listaPersonas.sort(Comparator.comparing(PersonasModelo::getNombres));
        return listaPersonas;

    }

    public Optional<PersonasModelo> getPersonasById(String id) {
        return personasRepositorio.findById(id);
    }

    public List<PersonasModelo> getPersonasByApellidos(String apellidos){
        return personasRepositorio.findByApellidos(apellidos);
    }

    public String eliminarPersonasPorId(String id) {
        if (personasRepositorio.existsById(id)) {
            Optional<PersonasModelo> personas = personasRepositorio.findById(id);
            personasRepositorio.deleteById(id);
            return "Personas " + personas.get().getNombres() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }
}
