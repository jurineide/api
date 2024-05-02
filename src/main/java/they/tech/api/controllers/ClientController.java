package they.tech.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import they.tech.api.dtos.ClientDTO;
import they.tech.api.services.ClientService;

import java.util.List;

@RestController
public class ClientController{
    @Autowired
    private ClientService clientService;
    @PostMapping("/customers")
    public ClientDTO save(@RequestBody ClientDTO dto){
        return this.clientService.save(dto);
    }

    @GetMapping("/customers")
    public List<ClientDTO>findAll(){
        return this.clientService.findAll();
    }

    @GetMapping("/customers/{id}")
    public  ClientDTO findById(@PathVariable Long id){
        return this.clientService.findByID(id);
    }

    @PutMapping("/customers/{id}")
    public ClientDTO updateById(@PathVariable Long id, @RequestBody ClientDTO dto){
        return this.clientService.updateById(id, dto);
    }
    @DeleteMapping("/customers/{id}")
    public String deleteById(@PathVariable Long id){
        return this.clientService.deleteById(id);
    }
}
