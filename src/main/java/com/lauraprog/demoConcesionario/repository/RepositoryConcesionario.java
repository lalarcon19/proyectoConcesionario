package com.lauraprog.demoConcesionario.repository;

import com.lauraprog.demoConcesionario.entity.Concesionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryConcesionario extends JpaRepository<Concesionario,Integer> {

    @Query(value = "SELECT u FROM Concesionario u WHERE u.id=id")
    public Concesionario encontrarporId(int id);
}
