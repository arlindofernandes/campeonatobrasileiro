package br.com.cbf.campeonatobrasileiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cbf.campeonatobrasileiro.entity.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo,Integer> {
    
}
