package co.edu.unab.apirestaa.Iservicios;

import java.util.List;
import java.util.Optional;

import co.edu.unab.apirestaa.modelos.PersonasModelo;

public interface IPersonasServicio {
    
    public List<PersonasModelo> all();
    public Optional <PersonasModelo> findById(String id);
    public PersonasModelo save (PersonasModelo personas);
    public void delete (String Id);
} 
