package com.avance.avancetb.controllers;


import com.avance.avancetb.dtos.FormQuery01;
import com.avance.avancetb.dtos.FormularioDTO;
import com.avance.avancetb.dtos.PerfilProfesionalDTO;
import com.avance.avancetb.entities.Formulario;
import com.avance.avancetb.entities.PerfilProfesional;
import com.avance.avancetb.servicesinterfaces.IFormularioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Formulario")
public class FormularioController {

    @Autowired
    private IFormularioService service;

    @GetMapping
    public ResponseEntity<List<FormularioDTO>> listar(){
        ModelMapper mapper = new ModelMapper();
        List<FormularioDTO> listarForm = service.list().stream().map(x->mapper.map(x, FormularioDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listarForm);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<FormularioDTO> registrar(@RequestBody FormularioDTO dto){
        ModelMapper mapper=new ModelMapper();
        Formulario p=mapper.map(dto,Formulario.class);
        Formulario srv=service.insert(p);
        FormularioDTO respondeDTO = mapper.map(srv, FormularioDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(respondeDTO);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> BuscarPorId(@PathVariable int id){
        ModelMapper mapper = new ModelMapper();
        Optional<Formulario> formulario = service.listId(id);

        if(formulario.isPresent()){
            FormularioDTO dto = mapper.map(formulario.get(), FormularioDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No encontrado");
        }
    }


    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar (@RequestBody FormularioDTO dto){
        Optional<Formulario> existente = service.listId(dto.getId_Formulario());

        if (existente.isEmpty()) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("perfil no encontrado");
           }


        Formulario formulario = existente.get();
        formulario.setNombre(dto.getNombre());
        formulario.setCorreo(dto.getCorreo());
        formulario.setMensaje(dto.getMensaje());
        service.uptade(formulario);

        return ResponseEntity.ok("actualizado correctamente");
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Formulario> formulario = service.listId(id);

        if (formulario.isPresent()) {
            service.delete(id);
            return ResponseEntity.ok("perfil eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("no encontrado");
        }
    }


    @GetMapping("/query1")
    public ResponseEntity<?> QueryData(){
        List<String[]> fila = service.FormData();
        List<FormQuery01> listDTO = new ArrayList<>();

        if (fila.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        for (String[] columna : fila){
            FormQuery01 dto = new FormQuery01();
            dto.setID_Formulario(Integer.parseInt(columna[0]));
            dto.setCorreo((columna[1]));
            listDTO.add(dto);
        }
        return  ResponseEntity.ok((listDTO));
    }

}


