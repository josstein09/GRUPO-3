package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.dtos.UsuarioCursoDTO;
import com.avance.avancetb.entities.Cursos;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.repositories.ICursosRepository;
import com.avance.avancetb.repositories.IUsuarioRepository;
import com.avance.avancetb.repositories.UsuarioCursoRepository;
import com.avance.avancetb.servicesinterfaces.IUsuarioCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioCursoServiceImplement implements IUsuarioCursoService {

    @Autowired
    private UsuarioCursoRepository UR;
    @Autowired
    private IUsuarioRepository IUR;
    @Autowired
    private ICursosRepository ICR;

    @Override
    public List<UsuarioCurso> list() {
        return UR.findAll();
    }

    @Override
    public UsuarioCurso Listid(int id) {
        return UR.findById(id).orElse(null);
    }

    @Override
    public UsuarioCurso Create(UsuarioCursoDTO us) {
        Usuario user = IUR.findById(us.getUsuario()).orElse(null);
        Cursos cr = ICR.findById(us.getCurso()).orElse(null);
        if (user == null || cr == null )
            throw new RuntimeException();
        UsuarioCurso newEntity = new UsuarioCurso( us.getIdUsuarioCurso(), user, cr, us.getFechaAsignacion(), us.getFechaUltimoAccesso());
        return UR.save(newEntity);
    }

    @Override
    public UsuarioCurso Delete( int id) {
        UsuarioCurso ur = this.Listid(id);
        if (ur == null)
            throw new RuntimeException();
        UR.delete(ur);
        return ur;
    }

    @Override
    public UsuarioCurso Update(int id, UsuarioCurso uu) {

        UsuarioCurso ur = this.Listid(id);

        if (ur == null)
            return null;

        ur.setCurso(uu.getCurso());
        ur.setUsuario(uu.getUsuario());
        ur.setFechaAsignacion(uu.getFechaAsignacion());
        ur.setFechaUltimoAccesso(uu.getFechaUltimoAccesso());

        return UR.save(ur);
    }
}
