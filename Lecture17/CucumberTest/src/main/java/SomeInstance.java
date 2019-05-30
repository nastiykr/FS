import lombok.Getter;

@Getter
public class SomeInstance {

    private Integer x;

    public SomeInstance(Integer value) {
        this.x = value;
    }

    public void incrementX() {
        this.x++;
    }

    public void decrementX(){
        this.x--;
    }

    public int getX() {
        return x;
    }
}