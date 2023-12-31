package com.EmpresaQTX.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmpresaQTX.Entities.Projeto;
import com.EmpresaQTX.Service.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "Projeto", description = "API REST DE GERENCIAMENTO  DO PROJETO")
@RestController
@RequestMapping("/projeto")
 public class ProjetoController {
	private final ProjetoService ProjetoService;

	@Autowired
	public ProjetoController(ProjetoService ProjetoService) {
		this.ProjetoService = ProjetoService;
	}
	@GetMapping("/{id}")
	@Operation(summary = "Localiza pedido por ID")
	public ResponseEntity<Projeto> buscaProjetoControlId(@PathVariable Long id){
		Projeto Projeto = ProjetoService.buscaProjetoId(id);
		if(Projeto !=null) {
			return ResponseEntity.ok(Projeto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	@Operation(summary = "Apresenta todos os Projetos")
	public ResponseEntity<List<Projeto>> buscaTodosProjetosControl(){
		List<Projeto> Projeto = ProjetoService.buscaTodosProjeto();
		return ResponseEntity.ok(Projeto);
	}
	@PostMapping
	@Operation(summary = "Cadastra um Projeto")
	public ResponseEntity<Projeto> salvaProjetoControl(@RequestBody @Valid Projeto Projeto){
		Projeto salvaProjeto =ProjetoService.salvaProjeto(Projeto);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProjeto);
}
	@PutMapping("/{id}")
	@Operation(summary= "Altera Projeto")
	public ResponseEntity<Projeto> alteraProjetoControl(@PathVariable Long id, @RequestBody @Valid Projeto Projeto){
		Projeto alteraProjeto = ProjetoService.alterarProjeto(id, Projeto);
		if(alteraProjeto !=null) {
			return ResponseEntity.ok(Projeto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	@DeleteMapping("/{id}")
	@Operation (summary = "Deleta Projeto")
	public ResponseEntity<Projeto> apagaProjetoControl(@PathVariable Long id){
		boolean apagar = ProjetoService.apagarProjeto(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

}