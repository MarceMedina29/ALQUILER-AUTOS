package co.edu.unab.apirestaa.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.MarcaAutosModelo;
import co.edu.unab.apirestaa.repositorios.MarcaAutosRepositorio;

@Service
public class MarcaAutosServicio {
    @Autowired
    MarcaAutosRepositorio marcaAutosRepositorio;

    public String guardarMarcaAutos(MarcaAutosModelo marcaAutos){
        marcaAutos.setNombreMarca(marcaAutos.getNombreMarca().toLowerCase());
        boolean estado=marcaAutos.getId()==null||!marcaAutosRepositorio.existsById(marcaAutos.getId());
        marcaAutosRepositorio.save(marcaAutos);
        if(estado){
            return "Se Guardo la Marca Autos";
        }else{
            return"Se Actualizo la Marca Autos";
        }
    }
        
    public List<MarcaAutosModelo> getListMarcaAutosOrder(){
        List<MarcaAutosModelo> listaMarcaAutos = marcaAutosRepositorio.findAll();
        listaMarcaAutos.sort(Comparator.comparing(MarcaAutosModelo::getNombreMarca));
        return listaMarcaAutos;

    }

    public Optional<MarcaAutosModelo> getMarcaAutosById(String id) {
        return marcaAutosRepositorio.findById(id);
    }

    public List<MarcaAutosModelo> getMarcaAutosByNombreMarca(String nombreMarca){
        return marcaAutosRepositorio.findByNombreMarca(nombreMarca);
    }

    public String eliminarMarcaAutosPorId(String id) {
        if (marcaAutosRepositorio.existsById(id)) {
            Optional<MarcaAutosModelo> marcaAutos = marcaAutosRepositorio.findById(id);
            marcaAutosRepositorio.deleteById(id);
            return "Marca Autos " + marcaAutos.get().getNombreMarca() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

    public List<MarcaAutosModelo> marcaAutosByEstado(Boolean estado){
        return marcaAutosRepositorio.buscarPorEstado(estado);
    }
}
