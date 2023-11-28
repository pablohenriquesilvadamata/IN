package controllers;

import dtos.ServicoDtos;
import jakarta.validation.Valid;
import model.UsuarioModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/erro", produces = {"application/json"})
public class ErroControllers {

    @Autowired
    UsuarioRepository erroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> ErroServico() {
        return ResponseEntity.status(HttpStatus.OK).body(erroRepository.findAll());
    }

    @GetMapping("/{idServico}")
    public ResponseEntity<Object> exibirErro(@PathVariable(value = "idErro") UUID id) {
        Optional<UsuarioModel> servicoBuscado = erroRepository.findById(id);

        if (servicoBuscado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro nao encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(servicoBuscado.get());
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarErro(@RequestBody @Valid ServicoDtos servicoDto) {
        UsuarioModel sericoModel = new UsuarioModel();

        BeanUtils.copyProperties(servicoDto, sericoModel);

        var erro = usuarioRepository.findById(servicoDto.id_erro());

        if (erro.isPresent()) {
            sericoModel.setErro(erro.get());
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id_erro nao encontrado");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(erroRepository.save(sericoModel));
    }

}
