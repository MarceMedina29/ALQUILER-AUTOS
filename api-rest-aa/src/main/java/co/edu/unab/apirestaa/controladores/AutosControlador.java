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
import co.edu.unab.apirestaa.Servicios.AutosServicio;
import co.edu.unab.apirestaa.modelos.AutosModelo;

@RestController
@RequestMapping("/Autos")
@CrossOrigin(origins = "*")
public class AutosControlador {
    
    @Autowired
    AutosServicio autosServicio;

    @GetMapping()
    public List<AutosModelo> getallAutosOrder(){
        return autosServicio.getListAutosOrder();
    }

    @GetMapping("/{id}")
    public Optional<AutosModelo> findAutosByID(@PathVariable("id") String id){
        return autosServicio.getAutosById(id);
    }

    @GetMapping("/query") 
    public List<AutosModelo> getAutosByPlaca(@RequestParam("placa") String placa){
        return autosServicio.getAutosByPlaca(placa); 
    }

    @GetMapping("/numeropasajeros/query")
    public List<AutosModelo> listPersonasNumeroPasajeros(@PathVariable("numeropasajeros") Integer numeroPasajeros){
        return autosServicio.autosByNumeroPasajeros(numeroPasajeros);
    }

    @GetMapping("/estado/query")
    public List<AutosModelo> listPersonasEstado(@PathVariable("estado") Boolean estado){
        return autosServicio.autosByEstado(estado);
    }

    @GetMapping("/estadoprestamo/{numerodelicencia}")
    public List<AutosModelo> listAutosEstadoPrestamo(@PathVariable("estadoprestamo") Boolean estadoPrestamo){
        return autosServicio.autosByEstadoPrestamo(estadoPrestamo);
    }
    
    @PostMapping()
    public String saveAutos(@RequestBody AutosModelo autos){
        return autosServicio.guardarAutos(autos);
    }

    @DeleteMapping("/{id}")
    public String deleteAutosById(@PathVariable("id")String id){
        return autosServicio.eliminarAutosPorId(id);
            
    }
}
