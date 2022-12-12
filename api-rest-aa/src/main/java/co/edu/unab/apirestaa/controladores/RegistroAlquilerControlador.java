package co.edu.unab.apirestaa.controladores;

import java.time.LocalDate;
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
import co.edu.unab.apirestaa.Servicios.RegistroAlquilerServicio;
import co.edu.unab.apirestaa.modelos.RegistroAlquilerModelo;

@RestController
@RequestMapping("/RegistroAlquiler")
@CrossOrigin(origins = "*")
public class RegistroAlquilerControlador {
    
    @Autowired
    RegistroAlquilerServicio registroAlquilerServicio;

    @GetMapping()
    public List<RegistroAlquilerModelo> getallRegistroAlquilerOrder(){
        return registroAlquilerServicio.getListRegistroAlquilerOrder();
    }

    @GetMapping("/{id}")
    public Optional<RegistroAlquilerModelo> findRegistroAlquilerByID(@PathVariable("id") String id){
        return registroAlquilerServicio.getRegistroAlquilerById(id);
    }

    @GetMapping("/query") 
    public List<RegistroAlquilerModelo> getRegistroAlquilerByFechaSolicitud(@RequestParam("apellidos") LocalDate fechaSolicitud){
        return registroAlquilerServicio.getRegistroAlquilerByFechaSolicitud(fechaSolicitud); 
    }

    @GetMapping("/fechaentrega/query")
    public List<RegistroAlquilerModelo> listRegistroAlquilerFechaEntrega(@PathVariable("fechaentrega") LocalDate fechaEntrega){
        return registroAlquilerServicio.registroAlquilerByFechaEntrega(fechaEntrega);
    }
    @GetMapping("/fecharecibido/{fecharecibido}")
    public List<RegistroAlquilerModelo> listRegistroAlquilerFechaRecibido(@PathVariable("fecharecibido") LocalDate fechaRecibido){
        return registroAlquilerServicio.registroAlquilerByFechaRecibido(fechaRecibido);
    }
    @GetMapping("/estadopago/{estadopago}")
    public List<RegistroAlquilerModelo> listRegistroAlquilerEstadoPago(@PathVariable("estadopago") Boolean estadoPago){
        return registroAlquilerServicio.registroAlquilerByEstadoPago(estadoPago);
    }
    
    @PostMapping()
    public String saveRegistroAlquiler(@RequestBody RegistroAlquilerModelo registroAlquiler){
        return registroAlquilerServicio.guardarRegistroAlquiler(registroAlquiler);
    }

    @DeleteMapping("/{id}")
    public String deletePersonasById(@PathVariable("id")String id){
        return registroAlquilerServicio.eliminarRegistroAlquilerPorId(id);
            
    }
}
