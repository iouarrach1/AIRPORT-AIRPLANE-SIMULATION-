import java.util.*;

public class AirBus319 extends Airplane implements TimeAtTerminal
{
    public static Random randy = new Random(6);

    private int startTimeAtTerminal;
    private int endTimeAtTerminal;
    private int gallonsOfFuelLoaded;
    private double ticketPrice;
    private int liftOffTime;

    @Override
    public int getStartTimeAtTerminal() {
        return startTimeAtTerminal;
    }
    @Override
    public int getEndTimeAtTerminal() {
        return endTimeAtTerminal;
    }
    public int getGallonsFuelLoaded() {
        return gallonsOfFuelLoaded;
    }
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }
    @Override
    public int getLiftOffTime() {
        return liftOffTime;
    }

    public AirBus319(int startTimeAtTerminalee)
    {
        super("AirBus319");
        setGallonsFuelLoaded();
        setTicketPrice();
        setStartTimeAtTerminal(startTimeAtTerminalee);
        setEndTimeAtTerminal();
    }

    public void setGallonsFuelLoaded()
    {
        gallonsOfFuelLoaded = randy.nextInt(151)+350;
    }

    public void setTicketPrice()
    {
        ticketPrice = gallonsOfFuelLoaded*0.80;
    }

    public void setStartTimeAtTerminal(int a)
    {
        startTimeAtTerminal =a;
    }

    public void setEndTimeAtTerminal()
    {
        endTimeAtTerminal = startTimeAtTerminal + (randy.nextInt(16) + 15);
    }

    public void setLiftOffTime(int a)
    {
        liftOffTime = a;
    }
    
}
