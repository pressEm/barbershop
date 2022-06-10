package vsu.ru.astanina.barbershop.entities;

import javax.persistence.*;

@Entity
@Table(name = "master_app", schema = "public")
public class Master_App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne()
    @JoinColumn(name = "master_id", referencedColumnName = "master_id")
    MasterEntity master;

    @ManyToOne()
    @JoinColumn(name = "app_id", referencedColumnName = "app_id")
    ApplicationEntity app;

    public void setMaster(MasterEntity master) {
        this.master = master;
    }

    public void setApp(ApplicationEntity app) {
        this.app = app;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public MasterEntity getMaster() {
        return master;
    }

    public ApplicationEntity getApp() {
        return app;
    }
}
