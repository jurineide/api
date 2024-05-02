package they.tech.api.services;

import they.tech.api.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import they.tech.api.dtos.ClientDTO;
import they.tech.api.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO save(ClientDTO dto) {
      Client client = ClientDTO.convert(dto);
      client = this.clientRepository.save(client);
      return new ClientDTO(client);
    }

    public List<ClientDTO> findAll() {
        List<Client>client = this.clientRepository.findAll();
        return client.stream().map(ClientDTO::new).collect(Collectors.toList());
    }

    public String deleteById(Long id) {
        ClientDTO dto = findByID(id);
        this.clientRepository.deleteById(id);
        return ( " O cliente de número " + dto.getId() + " foi excluído");
    }

    public ClientDTO findByID(Long id) {
        Optional<Client> cliente = this.clientRepository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }else{
            return new ClientDTO(cliente.get());
        }
    }

    public ClientDTO updateById(Long id, ClientDTO dto) {
        this.findByID(id);
        Client client = ClientDTO.convert(dto);
        client.setId(id);
        this.clientRepository.save(client);
        return new ClientDTO(client);
    }
}
