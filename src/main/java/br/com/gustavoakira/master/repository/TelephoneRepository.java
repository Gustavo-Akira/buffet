package br.com.gustavoakira.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavoakira.master.model.Telephone;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long>{

}
