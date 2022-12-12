package co.edu.unab.apirestaa.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.CategoriaAutosModelo;
import co.edu.unab.apirestaa.repositorios.CategoriaAutosRepositorio;

@Service
public class CategoriaAutosServicio {
    @Autowired
    CategoriaAutosRepositorio categoriaAutosRepositorio;

    public String guardarCategoriaAutos(CategoriaAutosModelo categoriaAutos){
        categoriaAutos.setNombreCategoria(categoriaAutos.getNombreCategoria().toLowerCase());
        boolean estado=categoriaAutos.getId()==null||!categoriaAutosRepositorio.existsById(categoriaAutos.getId());
        categoriaAutosRepositorio.save(categoriaAutos);
        if(estado){
            return "Se Guardo la Categoria Autos";
        }else{
            return"Se Actualizo la Categoria Autos";
        }
    }
        
    public List<CategoriaAutosModelo> getListCategoriaAutosOrder(){
        List<CategoriaAutosModelo> listaCategoriaAutos = categoriaAutosRepositorio.findAll();
        listaCategoriaAutos.sort(Comparator.comparing(CategoriaAutosModelo::getNombreCategoria));
        return listaCategoriaAutos;

    }

    public Optional<CategoriaAutosModelo> getCategoriaAutosById(String id) {
        return categoriaAutosRepositorio.findById(id);
    }

    public List<CategoriaAutosModelo> getCategoriaAutosByNombreCategoria(String nombreCategoria){
        return categoriaAutosRepositorio.findByNombreCategoria(nombreCategoria);
    }

    public String eliminarCategoriaAutosPorId(String id) {
        if (categoriaAutosRepositorio.existsById(id)) {
            Optional<CategoriaAutosModelo> categoriaAutos = categoriaAutosRepositorio.findById(id);
            categoriaAutosRepositorio.deleteById(id);
            return "Categoria Autos " + categoriaAutos.get().getNombreCategoria() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

    public List<CategoriaAutosModelo> categoriaAutosByEstado(Boolean estado){
        return categoriaAutosRepositorio.buscarPorEstado(estado);
    }
}
