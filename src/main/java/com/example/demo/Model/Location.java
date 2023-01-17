package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location  {
    @Id
    private int Id;

    private float Longitude;

    private float Latitude;



// @OneToMany(mappedBy = "location", fetch = FetchType.EAGER)
//    private List<Coordinates> Coordinates;

//    public Location(int Id, float Latitude, float Longitude) {
//        this.Id = Id;
//        this.Latitude = Latitude;
//        this.Longitude = Longitude;
//    }


}
