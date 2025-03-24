package Autofinanzi.controllers;

import Autofinanzi.dtos.EstoqueDto;
import Autofinanzi.models.Estoque;
import Autofinanzi.services.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;


    @GetMapping
    @Operation(description = "Lista todos os estoques")
    public ResponseEntity<List<Estoque>> findAll(){
        return  ResponseEntity.status(HttpStatus.OK).body(estoqueService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(description = "Lista estoque pelo ID")
    public ResponseEntity<Estoque> findById(@PathVariable(name = "id") UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(estoqueService.findById(id));
    }

    @PostMapping
    @Operation(description = "Cria um estoque")
    public  ResponseEntity<Estoque> createEstoque(@RequestBody EstoqueDto estoqueDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.createEstoque(estoqueDto));
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualiza um estoque")
    public ResponseEntity<Estoque> updateEstoque(@PathVariable(name = "id")UUID id,
                                                 @RequestBody EstoqueDto estoqueDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.updateEstoque(id, estoqueDto));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta um estoque")
    public ResponseEntity<Estoque> deleteEstoque(@PathVariable(name =  "id")UUID id){
        estoqueService.deleteEstoque(id);
        return ResponseEntity.noContent().build();
    }
}
