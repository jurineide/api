package they.tech.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import they.tech.api.models.Client;
import they.tech.api.models.Pizza;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClientDTO{
    private Long id;
    private String name;
    private String phone;
    private String login;
    private String password;
    private String address;
    public  ClientDTO(Long id){

    }
    //construtor que recebe  a entidade Client que será convertido em dto
    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.phone = client.getPhone();
        this.login = client.getLogin();
        this.password = client.getPassword();
        this.address = client.getAddress();

    }

    public ClientDTO(Optional<Pizza> pizza) {
    }

    //converti ClientDTO para Client
    public static Client convert(ClientDTO clientDTO){

        Client client = new Client(clientDTO.getId());

        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setPhone(clientDTO.getPhone());
        client.setLogin(clientDTO.getLogin());
        client.setPassword(clientDTO.getPassword());
        client.setAddress(clientDTO.getAddress());

        return client;
    }

    public Long getId() {
        return id;
    }


}
