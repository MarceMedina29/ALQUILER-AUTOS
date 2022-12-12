package co.edu.unab.apirestaa.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unab.apirestaa.modelos.UsuarioModelo;
import co.edu.unab.apirestaa.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public String guardarUsuario(UsuarioModelo usuario) {
        usuario.setId(usuario.getId());
        usuario.setEstado(usuario.getEstado());
        boolean estado=usuario.getId() == null || !usuarioRepositorio.existsById(usuario.getId());
        usuarioRepositorio.save(usuario);
        if (estado) {
            return "Se Guardo El Usuario";
        } else {
            return "Se Actualizo el Usuario";
        }
    }

    public List<UsuarioModelo> getListUsuarioOrden() {
        List<UsuarioModelo> listaUsuario = usuarioRepositorio.findAll();
        listaUsuario.sort(Comparator.comparing(UsuarioModelo::getUsuario));
        return listaUsuario;
    }

    public Optional<UsuarioModelo> getUsuarioById(String id) {
        return usuarioRepositorio.findById(id);
    }

    public List<UsuarioModelo> getUsuarioByEstado(Boolean estado){
        return usuarioRepositorio.findByEstado(estado);
    }

    public String eliminarUsuarioPorId(String id) {
        if (usuarioRepositorio.existsById(id)) {
            Optional<UsuarioModelo> usuario = usuarioRepositorio.findById(id);
            usuarioRepositorio.deleteById(id);
            return "Usuario " + usuario.get().getUsuario() + " Eliminado";
        } else {
            return "No Eliminado";
        }
    }

    public List<UsuarioModelo> usuarioByPersonaId(String personaId){
        return usuarioRepositorio.buscarPorPersonaId(personaId);
    }

    public List<UsuarioModelo>usuarioByRolId(String rolId){
        return usuarioRepositorio.buscarPorRolId(rolId);
    }

}
