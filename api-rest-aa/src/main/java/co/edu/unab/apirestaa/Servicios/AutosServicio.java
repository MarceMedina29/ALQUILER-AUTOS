package co.edu.unab.apirestaa.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.AutosModelo;
import co.edu.unab.apirestaa.repositorios.AutosRepositorio;

@Service
public class AutosServicio {
    @Autowired
    AutosRepositorio autosRepositorio;

    public String guardarAutos(AutosModelo autos){
        autos.setPlaca(autos.getPlaca().toLowerCase());
        autos.setNumeroPasajeros(autos.getNumeroPasajeros());
        boolean estado=autos.getId()==null||!autosRepositorio.existsById(autos.getId());
        autosRepositorio.save(autos);
        if(estado){
            return "Se Guardo el Auto";
        }else{
            return"Se Actualizo el Auto";
        }
    }
        
    public List<AutosModelo> getListAutosOrder(){
        List<AutosModelo> listaAutos = autosRepositorio.findAll();
        listaAutos.sort(Comparator.comparing(AutosModelo::getPlaca));
        return listaAutos;
    }

    public Optional<AutosModelo> getAutosById(String id) {
        return autosRepositorio.findById(id);
    }

    public List<AutosModelo> getAutosByPlaca(String placa){
        return autosRepositorio.findByPlaca(placa);
    }

    public String eliminarAutosPorId(String id) {
        if (autosRepositorio.existsById(id)) {
            Optional<AutosModelo> autos = autosRepositorio.findById(id);
            autosRepositorio.deleteById(id);
            return "Autos " + autos.get().getNumeroPasajeros() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

    public List<AutosModelo> autosByNumeroPasajeros(Integer numeroPasajeros){
        return autosRepositorio.buscarPorNumeroPasajeros(numeroPasajeros);
    }

    public List<AutosModelo> autosByEstado(Boolean estado){
        return autosRepositorio.buscarPorEstado(estado);
    }

    public List<AutosModelo>autosByEstadoPrestamo(Boolean estadoPrestamo){
        return autosRepositorio.buscarAutosPorEstadoPrestamo(estadoPrestamo);
    }
}
