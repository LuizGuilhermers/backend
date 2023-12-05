package com.EmpresaQTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmpresaQTX.Entities.Empresa;

public interface EmpresaRepository extends JpaRepository <Empresa, Long>{

}