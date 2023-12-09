package com.esprit.microservice.projet_microservice.entite;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ServiceE implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idService;
    private String title;
    private String description;
    private  double tarif;
    private int dure;
    private String image;
   /* public long getId(){return idService;}
    public void setId(long idService){this.idService=idService;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public double getTarif(){return tarif;}
    public void setTarif(double tarif){this.tarif=tarif;}
    public int getDure(){return dure;}
    public void setDure(int dure){this.dure=dure;}
    public String getImage(){return image;}
    public void setImage(String image){this.image=image;}
    public ServiceE() {}
    public ServiceE(long idService, String title, String description,double tarif,int dure,String image) {
        this.idService=idService;
        this.description = description;
        this.title = title;
        this.dure = dure;
        this.image=image;
        this.tarif=tarif;
    }*/

}
