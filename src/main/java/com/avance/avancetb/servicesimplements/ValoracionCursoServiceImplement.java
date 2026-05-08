package com.avance.avancetb.servicesimplements;

import com.avance.avancetb.dtos.ValoracionCursoDTO;
import com.avance.avancetb.entities.UsuarioCurso;
import com.avance.avancetb.entities.ValoracionCurso;
import com.avance.avancetb.repositories.IValoracionCursoRepository;
import com.avance.avancetb.repositories.UsuarioCursoRepository;
import com.avance.avancetb.servicesinterfaces.IValoracionCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionCursoServiceImplement implements IValoracionCursoService {

    @Autowired
    private IValoracionCursoRepository VCR;

    @Autowired
    private UsuarioCursoRepository UCR;

    @Override
    public List<ValoracionCurso> list() {
        return VCR.findAll();
    }

    @Override
    public ValoracionCurso listId(int id) {  // ← Corregido: listId (no Listid)
        return VCR.findById(id).orElse(null);
    }

    @Override
    public ValoracionCurso Create(ValoracionCursoDTO vc) {
        UsuarioCurso uc = UCR.findById(vc.getIdUsuarioCurso()).orElse(null);

        if (uc == null) {
            throw new RuntimeException("El registro Usuario-Curso no existe con ID: " + vc.getIdUsuarioCurso());
        }

        ValoracionCurso newEntity = new ValoracionCurso(
                vc.getIdValoracion(),
                uc,
                vc.getFechaValoracion(),
                vc.getCalificacion(),
                vc.getComentario()
        );

        return VCR.save(newEntity);
    }

    @Override
    public ValoracionCurso Delete(int id) {
        ValoracionCurso vc = this.listId(id);  // ← Corregido: listId
        if (vc == null) {
            throw new RuntimeException("La valoración no existe.");
        }
        VCR.delete(vc);
        return vc;
    }

    @Override
    public ValoracionCurso Update(int id, ValoracionCurso vcActualizada) {
        ValoracionCurso vcExistente = this.listId(id);  // ← Corregido: listId

        if (vcExistente == null) {
            return null;
        }

        vcExistente.setFechaValoracion(vcActualizada.getFechaValoracion());
        vcExistente.setCalificacion(vcActualizada.getCalificacion());
        vcExistente.setComentario(vcActualizada.getComentario());

        return VCR.save(vcExistente);
    }
}