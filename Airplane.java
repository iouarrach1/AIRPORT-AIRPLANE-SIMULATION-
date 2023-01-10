public abstract class Airplane {
    private String airplaneID;
    public static int airplaneCounter =0;

    public Airplane()
    {
        setAirplaneID("Unknown");
    }
    public Airplane(String airplaneTypee)
    {
        setAirplaneID(airplaneTypee);
    }

    public String getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(String airplaneTypee) {
        airplaneCounter = airplaneCounter +1;
        airplaneID = airplaneTypee + " Flight: " + airplaneCounter;
    }

    public abstract void setGallonsFuelLoaded();
    public abstract int getGallonsFuelLoaded();
    public abstract void setTicketPrice();
    public abstract double getTicketPrice();
    public abstract void setEndTimeAtTerminal();
    public abstract int getEndTimeAtTerminal();
    public abstract void setLiftOffTime(int a);
    public abstract int getLiftOffTime();
}
