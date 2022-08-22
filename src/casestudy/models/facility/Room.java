package casestudy.models.facility;

public class Room extends Facility {
    private String freeStuff;

    public Room() {
    }

    public Room(String id, String name, double area, double price, int amountOfPeople, String freeStuff) {
        super(id, name, area, price, amountOfPeople);
        this.freeStuff = freeStuff;
    }

    public String getFreeStuff() {
        return freeStuff;
    }

    public void setFreeStuff(String freeStuff) {
        this.freeStuff = freeStuff;
    }

    @Override
    public String toString() {
        return "Room " + super.toString() +
                "freeStuff= " + freeStuff;
    }
}
