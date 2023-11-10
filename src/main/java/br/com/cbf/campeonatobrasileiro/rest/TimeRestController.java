package br.com.cbf.campeonatobrasileiro.rest;

import br.com.cbf.campeonatobrasileiro.dto.TimeDTO;
import br.com.cbf.campeonatobrasileiro.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping(value = "/times")
public class TimeRestController {

    @Autowired
    private TimeService timeService;

    @ApiOperation(value = "Obtém uma lista os dados de um time")
    @GetMapping
    public ResponseEntity<List<TimeDTO>> getTimes() {
        return ResponseEntity.ok().body(timeService.listarTimes());
    }

    @ApiOperation(value = "Obtém os dados de um time")
    @GetMapping(value = "{id}")
    public ResponseEntity<TimeDTO> getTime(@PathVariable Integer id) {
        return ResponseEntity.ok().body(timeService.getTime(id));

    }

    //@ApiOperation(value = "Cadastrar os dados de um time")
    @PostMapping
    public ResponseEntity<TimeDTO> cadastrarTime(@Validated @RequestBody  TimeDTO time) throws Exception {
        return ResponseEntity.ok().body(timeService.cadastrarTime(time));
        //
    }
}
