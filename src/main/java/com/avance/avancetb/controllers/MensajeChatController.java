package com.avance.avancetb.controllers;

import com.avance.avancetb.dtos.MensajeChatDTO;
import com.avance.avancetb.entities.MensajeChat;
import com.avance.avancetb.entities.Usuario;
import com.avance.avancetb.servicesinterfaces.IMensajeChatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mensajes-chat")
public class MensajeChatController {

    @Autowired
    private IMensajeChatService mS;

    @GetMapping
    public ResponseEntity<List<MensajeChatDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<MensajeChatDTO> lista = mS.list().stream()
                .map(x -> m.map(x, MensajeChatDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<MensajeChatDTO> registrar(@RequestBody MensajeChatDTO dto) {
        ModelMapper m = new ModelMapper();
        MensajeChat mc = m.map(dto, MensajeChat.class);

        Usuario emisor = new Usuario();
        emisor.setIdUsuario(dto.getIdUsuarioEmisor());
        mc.setUsuarioEmisor(emisor);

        Usuario receptor = new Usuario();
        receptor.setIdUsuario(dto.getIdUsuarioReceptor());
        mc.setUsuarioReceptor(receptor);

        MensajeChat nuevo = mS.insert(mc);
        MensajeChatDTO responseDTO = m.map(nuevo, MensajeChatDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<MensajeChat> mensaje = mS.listId(id);

        if (mensaje.isPresent()) {
            MensajeChatDTO dto = m.map(mensaje.get(), MensajeChatDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mensaje no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<?> actualizar(@RequestBody MensajeChatDTO dto) {
        Optional<MensajeChat> existente = mS.listId(dto.getIdMensaje());

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede actualizar: el mensaje no existe.");
        }

        ModelMapper m = new ModelMapper();
        MensajeChat mc = m.map(dto, MensajeChat.class);

        Usuario emisor = new Usuario();
        emisor.setIdUsuario(dto.getIdUsuarioEmisor());
        mc.setUsuarioEmisor(emisor);

        Usuario receptor = new Usuario();
        receptor.setIdUsuario(dto.getIdUsuarioReceptor());
        mc.setUsuarioReceptor(receptor);

        mS.update(mc);
        return ResponseEntity.ok("Mensaje actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<MensajeChat> mensaje = mS.listId(id);

        if (mensaje.isPresent()) {
            mS.delete(id);
            return ResponseEntity.ok("Mensaje eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mensaje no encontrado");
        }
    }

    @GetMapping("/top10/usuario/{idUsuario}")
    public ResponseEntity<List<MensajeChatDTO>> listarTop10PorUsuario(@PathVariable int idUsuario) {
        ModelMapper m = new ModelMapper();
        List<MensajeChatDTO> lista = mS.listarTop10MensajesRecientesPorUsuario(idUsuario)
                .stream().map(x -> m.map(x, MensajeChatDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
}