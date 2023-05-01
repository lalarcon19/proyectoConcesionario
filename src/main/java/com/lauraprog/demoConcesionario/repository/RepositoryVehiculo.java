package com.lauraprog.demoConcesionario.repository;

import com.lauraprog.demoConcesionario.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehiculo extends JpaRepository<Vehiculo,Integer> {
    @Query(value = "SELECT u FROM Vehiculo u WHERE u.id=id")
    public Vehiculo encontrarporId(int id);
}