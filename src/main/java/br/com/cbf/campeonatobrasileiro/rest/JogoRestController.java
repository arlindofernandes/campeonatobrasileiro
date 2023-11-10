package br.com.cbf.campeonatobrasileiro.rest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.cbf.campeonatobrasileiro.dto.ClassificacaoDTO;
import br.com.cbf.campeonatobrasileiro.dto.JogoDTO;
import br.com.cbf.campeonatobrasileiro.dto.JogoFinalizadoDTO;
import br.com.cbf.campeonatobrasileiro.service.JogoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/jogos")
public class JogoRestController {

    @Autowired
    private JogoService jogoService;

    @ApiOperation(value = "Gera os jogos do campeonato!")
    @PostMapping
    public ResponseEntity<Void> gerarJogos() {
        jogoService.gerarJogos(LocalDateTime.now(), Arrays.asList());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<JogoDTO>> obterJogos() {
        return ResponseEntity.ok().body(jogoService.listarJogos());
    }

    @PostMapping(value = "/finalizar/{id}")
    public ResponseEntity<JogoDTO> finalizar(@PathVariable Integer id, @RequestBody JogoFinalizadoDTO dto)
            throws Exception {
        return ResponseEntity.ok().body(jogoService.finalizarJogo(id, dto));
    }

    @GetMapping(value = "/classificacao")
    public ResponseEntity<ClassificacaoDTO> classificacao() {
        return ResponseEntity.ok().body(jogoService.obterClassificacao());
    }

    @GetMapping(value = "/jogo/{id}")
    public ResponseEntity<JogoDTO> obterJogo(@PathVariable Integer id) {
        return ResponseEntity.ok().body(jogoService.obterJogo(id));
    }
}
