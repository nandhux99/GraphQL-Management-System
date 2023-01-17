package com.example.demo.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(unique = true, nullable = false)
private int Id;

//@OneToMany
//@JoinColumns( {
//        @JoinColumn(name = "latitude", nullable = false, updatable = false),
//        @JoinColumn(name = "longitude", nullable = false, updatable = false),
//
//}
//)

//private List<Location> location;


}
