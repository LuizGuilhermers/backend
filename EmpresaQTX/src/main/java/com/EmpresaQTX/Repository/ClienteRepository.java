package com.EmpresaQTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmpresaQTX.Entities.Cliente;


public interface ClienteRepository extends JpaRepository <Cliente , Long>{

}
