package com.EmpresaQTX.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmpresaQTX.Entities.Cliente;
import com.EmpresaQTX.Entities.Departamento;
import com.EmpresaQTX.Entities.Empresa;
import com.EmpresaQTX.Entities.Fornecedor;
import com.EmpresaQTX.Entities.Funcionario;
import com.EmpresaQTX.Entities.Projeto;
import com.EmpresaQTX.Service.ClienteService;
import com.EmpresaQTX.Service.DepartamentoService;
import com.EmpresaQTX.Service.EmpresaService;
import com.EmpresaQTX.Service.FornecedorService;
import com.EmpresaQTX.Service.FuncionarioService;
import com.EmpresaQTX.Service.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/ApiExterno")
public class ApiExternoController {
	
	private final ClienteService clienteService;
	private final EmpresaService empresaService;
	private final FornecedorService fornecedorService;
	private final FuncionarioService funcionarioService;
	private final DepartamentoService departamentoService;
	private final ProjetoService ProjetoService;
	
	@Autowired
	public ApiExternoController(ProjetoService ProjetoService, ClienteService clienteService , EmpresaService empresaService,FornecedorService fornecedorService, FuncionarioService funcionarioService,DepartamentoService departamentoService) {
		this.ProjetoService = ProjetoService;
		this.clienteService = clienteService;
		this.empresaService = empresaService;
		this.fornecedorService = fornecedorService;
		this.funcionarioService = funcionarioService;
		this.departamentoService = departamentoService;
		
	}
	
	@GetMapping("/clientes")
	@Operation(summary = "Apresenta todos os clientes")
	public ResponseEntity<List<Cliente>> buscaTodosClienteCOntrol(){
		List<Cliente> Cliente = clienteService.buscaTodosCliente();
		return ResponseEntity.ok(Cliente);
	}
	@GetMapping("/empresa")
	@Operation(summary = "Apresenta todos as Empresas")
	public ResponseEntity<List<Empresa>> buscaTodosEmpresasControl(){
		List<Empresa> Empresa = empresaService.buscaTodosEmpresa();
		return ResponseEntity.ok(Empresa);
	}
	@GetMapping("/fornecedor")
	@Operation(summary = "Apresenta todos os fornecedores")
	public ResponseEntity<List<Fornecedor>> buscaTodosFornecedorCOntrol(){
		List<Fornecedor> Fornecedor = fornecedorService.buscaTodosFornecedor();
		return ResponseEntity.ok(Fornecedor);
	}
	@GetMapping("/funcionarios")
	@Operation(summary = "Apresenta todos os Funcionarios")
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionarioControl(){
		List<Funcionario> Funcionario = funcionarioService.buscaTodosFuncionarios();
		return ResponseEntity.ok(Funcionario);
	}
	@GetMapping("/departamentos")
	@Operation(summary = "Apresenta todos os Departamentos")
	public ResponseEntity<List<Departamento>> buscaTodosDepartamentoControl(){
		List<Departamento> Departamento = departamentoService.buscaTodosDepartamentos();
		return ResponseEntity.ok(Departamento);
	}
	@GetMapping("/projetos")
	@Operation(summary = "Apresenta todos os Projetos")
	public ResponseEntity<List<Projeto>> buscaTodosProjetosControl(){
		List<Projeto> Projeto = ProjetoService.buscaTodosProjeto();
		return ResponseEntity.ok(Projeto);
	}
}
