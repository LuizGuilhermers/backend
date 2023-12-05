package com.EmpresaQTX.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmpresaQTX.Entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long>{

}
