import java.util.*;

public class Boeing787 extends Airplane implements TimeAtTerminal {
    public static Random randy = new Random(4);

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

    public Boeing787(int startTimeAtTerminalee)
    {
        super("Boeing787");
        setGallonsFuelLoaded();
        setTicketPrice();
        setStartTimeAtTerminal(startTimeAtTerminalee);
        setEndTimeAtTerminal();
    }

    public void setGallonsFuelLoaded()
    {
        gallonsOfFuelLoaded = randy.nextInt(1501)+500;
    }

    public void setTicketPrice()
    {
        ticketPrice = gallonsOfFuelLoaded*0.65;
    }

    public void setStartTimeAtTerminal(int a)
    {
        startTimeAtTerminal =a;
    }

    public void setEndTimeAtTerminal()
    {
        endTimeAtTerminal = startTimeAtTerminal + (randy.nextInt(11) + 30);
    }

    public void setLiftOffTime(int a)
    {
        liftOffTime = a;
    }

}
