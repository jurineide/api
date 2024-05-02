package they.tech.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import they.tech.api.dtos.PizzaDTO;
import they.tech.api.services.PizzaService;

import java.util.List;

@RestController
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;
    @PostMapping("/pizza")
    public PizzaDTO save(@RequestBody PizzaDTO dto){
        return this.pizzaService.save(dto);
    }

    @GetMapping("/pizza")
    public List<PizzaDTO>findAll(){
        return this.pizzaService.findAll();
    }

    @GetMapping("/pizza/{id}")
    public  PizzaDTO findById(@PathVariable Long id){
        return this.pizzaService.findByID(id);
    }

    @PutMapping("/pizza/{id}")
    public PizzaDTO updateById(@PathVariable Long id, @RequestBody PizzaDTO dto){
        return this.pizzaService.updateById(id, dto);
    }
    @DeleteMapping("/pizza/{id}")
    public String deleteById(@PathVariable Long id){
        return this.pizzaService.deleteById(id);
    }
}
