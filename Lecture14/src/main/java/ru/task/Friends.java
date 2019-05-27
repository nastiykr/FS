package ru.task;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Friends {
    private int count;

    public Friends(int count){
        this.count = count;
    }

    @Override
    public String toString() {
        return "count: " + this.count;
    }
}
