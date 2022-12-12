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
import co.edu.unab.apirestaa.Servicios.CategoriaAutosServicio;
import co.edu.unab.apirestaa.modelos.CategoriaAutosModelo;

@RestController
@RequestMapping("/CategoriaAutos")
@CrossOrigin(origins = "*")
public class CategoriaAutosControlador {
    
    @Autowired
    CategoriaAutosServicio categoriaAutosServicio;

    @GetMapping()
    public List<CategoriaAutosModelo> getallCategoriaAutosOrder(){
        return categoriaAutosServicio.getListCategoriaAutosOrder();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaAutosModelo> findCategoriaAutosByID(@PathVariable("id") String id){
        return categoriaAutosServicio.getCategoriaAutosById(id);
    }

    @GetMapping("/query")
    public List<CategoriaAutosModelo> getCategoriaAutosByNombreCategoria(@RequestParam("nombrecategoria") String nombreCategoria){
        return categoriaAutosServicio.getCategoriaAutosByNombreCategoria(nombreCategoria); 
    }

    @GetMapping("/estado/query")
    public List<CategoriaAutosModelo> listCategoriaAutosEstado(@PathVariable("estado") Boolean estado){
        return categoriaAutosServicio.categoriaAutosByEstado(estado);
    }
    
    @PostMapping()
    public String saveCategoriaAutos(@RequestBody CategoriaAutosModelo categoriaAutos){
        return categoriaAutosServicio.guardarCategoriaAutos(categoriaAutos);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoriaAutosById(@PathVariable("id")String id){
        return categoriaAutosServicio.eliminarCategoriaAutosPorId(id);
            
    }
}
