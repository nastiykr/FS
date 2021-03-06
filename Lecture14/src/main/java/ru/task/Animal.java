package ru.task;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Animal {
    @SerializedName("animal_type")
    private String animalType;
    private String name;
    private int age;
    private boolean hasTail;
    private List<String> colors;
    @SerializedName("friends")
    private Friends friends;


    public Animal(String animalType, String name, int age, boolean hasTail, List<String> colors, Friends friends) {
        this.animalType = animalType;
        this.name = name;
        this.age = age;
        this.hasTail = hasTail;
        this.colors = colors;
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "animalType: " + this.animalType + "\nname: "+ this.name +"\nage: " +this.age + "\nhasTail: "+this.hasTail + "\ncolors: "+this.colors + "\nfriends: "+this.friends;
    }
}
