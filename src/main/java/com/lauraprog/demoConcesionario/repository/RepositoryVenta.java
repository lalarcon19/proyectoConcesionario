package com.lauraprog.demoConcesionario.repository;

import com.lauraprog.demoConcesionario.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVenta extends JpaRepository<Venta,Integer> {
    @Query(value = "SELECT u FROM Usuario u WHERE u.id=id")
    public Venta encontrarporId(int id);

}
