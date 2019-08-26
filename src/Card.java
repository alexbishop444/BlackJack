public class Card {
    String name;
    Integer value;
    boolean drawn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isDrawn() {
        return drawn;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", value=" + value +
//                ", drawn=" + drawn +
                '}';
    }

    public Card(String name, Integer value, boolean drawn) {
        this.name = name;
        this.value = value;
        this.drawn = drawn;
    }
}
