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
import co.edu.unab.apirestaa.Servicios.MarcaAutosServicio;
import co.edu.unab.apirestaa.modelos.MarcaAutosModelo;

@RestController
@RequestMapping("/MarcaAutos")
@CrossOrigin(origins = "*")
public class MarcaAutosControlador {
    
    @Autowired
    MarcaAutosServicio marcaAutosServicio;

    @GetMapping()
    public List<MarcaAutosModelo> getallMarcaAutosOrder(){
        return marcaAutosServicio.getListMarcaAutosOrder();
    }

    @GetMapping("/{id}")
    public Optional<MarcaAutosModelo> findMarcaAutosByID(@PathVariable("id") String id){
        return marcaAutosServicio.getMarcaAutosById(id);
    }

    @GetMapping("/query") 
    public List<MarcaAutosModelo> getMarcaAutosByNombreMarca(@RequestParam("nombremarca") String nombreMarca){
        return marcaAutosServicio.getMarcaAutosByNombreMarca(nombreMarca); 
    }

    @GetMapping("/estado/query")
    public List<MarcaAutosModelo> listMarcaAutosEstado(@PathVariable("estado") Boolean estado){
        return marcaAutosServicio.marcaAutosByEstado(estado);
    }
    
    @PostMapping()
    public String saveMarcaAutos(@RequestBody MarcaAutosModelo marcaAutos){
        return marcaAutosServicio.guardarMarcaAutos(marcaAutos);
    }

    @DeleteMapping("/{id}")
    public String deleteMarcaAutosById(@PathVariable("id")String id){
        return marcaAutosServicio.eliminarMarcaAutosPorId(id);
            
    }
}
