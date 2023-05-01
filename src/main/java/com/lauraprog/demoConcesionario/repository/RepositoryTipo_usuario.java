package com.lauraprog.demoConcesionario.repository;

import com.lauraprog.demoConcesionario.entity.Tipo_usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTipo_usuario extends JpaRepository<Tipo_usuario,Integer> {

    @Query(value = "SELECT u FROM Tipo_usuario u WHERE u.id=id")
    public Tipo_usuario encontrarporId(int id);
}
