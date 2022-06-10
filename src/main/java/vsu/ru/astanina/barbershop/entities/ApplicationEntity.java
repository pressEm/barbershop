package vsu.ru.astanina.barbershop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "application", schema = "public")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    int app_id;

    @NotEmpty(message = "Date  can not be empty")
    @Column(name = "date_")
    private Date date;

    @Column(name = "cost")
    @NotEmpty(message = "cost can not be empty")
    private int cost;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    @NotNull(message = "client_id can not be empty")
    private ClientEntity client_id;

    public int getApp_id() {
        return app_id;
    }

    public Date getDate() {
        return date;
    }

    public int getCost() {
        return cost;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

