package co.edu.unab.apirestaa.Servicios;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.RegistroAlquilerModelo;
import co.edu.unab.apirestaa.repositorios.RegistroAlquilerRepositorio;

@Service
public class RegistroAlquilerServicio {
    @Autowired
    RegistroAlquilerRepositorio registroAlquilerRepositorio;

    public String guardarRegistroAlquiler(RegistroAlquilerModelo registroAlquiler){
        registroAlquiler.setFechaSolicitud(registroAlquiler.getFechaSolicitud());
        registroAlquiler.setFechaEntrega(registroAlquiler.getFechaEntrega());
        registroAlquiler.setFechaRecibido(registroAlquiler.getFechaRecibido());
        boolean estado=registroAlquiler.getId()==null||!registroAlquilerRepositorio.existsById(registroAlquiler.getId());
        registroAlquilerRepositorio.save(registroAlquiler);
        if(estado){
            return "Se Guardo el Registro Alquiler";
        }else{
            return"Se Actualizo el Registro Alquiler";
        }
    }
        
    public List<RegistroAlquilerModelo> getListRegistroAlquilerOrder(){
        List<RegistroAlquilerModelo> listaRegistroAlquiler = registroAlquilerRepositorio.findAll();
        listaRegistroAlquiler.sort(Comparator.comparing(RegistroAlquilerModelo::getFechaSolicitud));
        return listaRegistroAlquiler;

    }

    public Optional<RegistroAlquilerModelo> getRegistroAlquilerById(String id) {
        return registroAlquilerRepositorio.findById(id);
    }

    public List<RegistroAlquilerModelo> getRegistroAlquilerByFechaSolicitud(LocalDate fechaSolicitud){
        return registroAlquilerRepositorio.findByFechaSolicitud(fechaSolicitud);
    }

    public String eliminarRegistroAlquilerPorId(String id) {
        if (registroAlquilerRepositorio.existsById(id)) {
            Optional<RegistroAlquilerModelo> registroAlquiler = registroAlquilerRepositorio.findById(id);
            registroAlquilerRepositorio.deleteById(id);
            return "Registro Alquiler " + registroAlquiler.get().getFechaSolicitud() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

    public List<RegistroAlquilerModelo> registroAlquilerByFechaEntrega(LocalDate fechaEntrega){
        return registroAlquilerRepositorio.buscarPorFechaEntrega(fechaEntrega);
    }

    public List<RegistroAlquilerModelo> registroAlquilerByFechaRecibido(LocalDate fechaRecibido){
        return registroAlquilerRepositorio.buscarRegistroAlquilerPorFechaRecibido(fechaRecibido);
    }

    public List<RegistroAlquilerModelo>registroAlquilerByEstadoPago(Boolean estadoPago){
        return registroAlquilerRepositorio.buscarRegistroAlquilerPorEstadoPago(estadoPago);
    }
}

