package vsu.ru.astanina.barbershop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client", schema = "public")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    int client_id;

    @Column(name = "client_name")
    @NotEmpty(message = "Name can not be empty")
    @Size(max = 50, message = "Name length should be between 1 an 100 characters")
    private String client_name;

    @Column(name = "phone_num")
    @NotEmpty(message = "phone_num can not be empty")
    @Size(max = 20, message = "phone_num length should be between 1 an 100 characters")
    private String phone_num;

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getPhone_num() {
        return phone_num;
    }
}

