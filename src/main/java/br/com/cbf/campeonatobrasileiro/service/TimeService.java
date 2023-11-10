package br.com.cbf.campeonatobrasileiro.service;

import br.com.cbf.campeonatobrasileiro.dto.TimeDTO;
import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;
import static java.util.stream.Collectors.toList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TimeService {
    @Autowired
    private TimeRepository repository;

    public TimeDTO cadastrarTime(TimeDTO time) throws Exception {
        Time entity =toEntity(time);
        if (time.getId()==null){
           entity = repository.save(entity);
            return toDto(entity);
        }else {
            throw new Exception("time ja existente");
        }

    }
    public List<TimeDTO> listarTimes(){
         return  repository.findAll().stream().map(entity-> toDto(entity)).collect(toList());
    }
     private TimeDTO toDto(Time entity) {
        TimeDTO dto = new TimeDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSigla(entity.getSigla());
        dto.setUf(entity.getUf());
        dto.setEstadio(entity.getEstadio());
        return dto;
    }
    public TimeDTO getTime(Integer id){
         return  toDto(repository.findById(id).get());
    }

    private Time toEntity(TimeDTO timeDTO){
        Time time = new Time();
        time.setId(timeDTO.getId());
        time.setNome(timeDTO.getNome());
        time.setSigla(timeDTO.getSigla());
        time.setUf(timeDTO.getUf());
        time.setEstadio(timeDTO.getEstadio());
        return time;
    }
}
