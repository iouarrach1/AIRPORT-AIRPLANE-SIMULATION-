import java.util.*;
import java.io.*;

public class Airport 
{
    private String airportName;

    ArrayList<Airplane> atTerminal = new ArrayList<Airplane>();
    ArrayList<Boeing787> boeing787Runway = new ArrayList<Boeing787>();
    ArrayList<AirBus319> airBus319Runway = new ArrayList<AirBus319>();
    ArrayList<Airplane> departed = new ArrayList<Airplane>();


    public Airport(String name)
    {
        airportName = name;
    }

    public void initializeAirport()
    {
        for(int i =0; i<20 ;i++)
        {
            if(i%4 == 0)
            {
                atTerminal.add(new Boeing787(0));
            }
            else
            {
                atTerminal.add(new AirBus319(0));
            }
        }
    }

    public void runAirport(int simTime)
    {
        int minCounter =1;

        while(!(atTerminal.isEmpty()) || !(boeing787Runway.isEmpty()) || !(airBus319Runway.isEmpty()))
        {
            if(minCounter<= simTime && minCounter%5 == 0)
            {
                for(int i =0; i<7;i++)
                {
                    if(i%3 == 0)
                    {
                        atTerminal.add(new Boeing787(minCounter));
                    }
                    else
                    {
                        atTerminal.add(new AirBus319(minCounter));
                    }
                }
            }

            for(int i = 0; i<atTerminal.size();i++)
            {
                Airplane tempAirplane = atTerminal.get(i);
                if(tempAirplane.getEndTimeAtTerminal() == minCounter)
                {
                    if(tempAirplane instanceof Boeing787)
                    {
                        Boeing787 tempBoeing787 = (Boeing787)tempAirplane;
                        boeing787Runway.add(tempBoeing787);
                    }
                    else
                    {
                        AirBus319 tempAirBus319 = (AirBus319)tempAirplane;
                        airBus319Runway.add(tempAirBus319);
                    }
                    atTerminal.remove(tempAirplane);
                    i =i -1;
                }
            }


            if(!(boeing787Runway.isEmpty()) && minCounter%5==0)
            {
                Boeing787 tempBoeing787 = boeing787Runway.get(0);
                boeing787Runway.remove(0);
                tempBoeing787.setLiftOffTime(minCounter);
                departed.add(tempBoeing787);
            }

            if(!(airBus319Runway.isEmpty()) && minCounter%4==0)
            {
                AirBus319 tempAirBus319 = airBus319Runway.get(0);
                airBus319Runway.remove(0);
                tempAirBus319.setLiftOffTime(minCounter);
                departed.add(tempAirBus319);
            }
            minCounter = minCounter+1;
        }
    }

    public void generateAirportOutput(String fileName) throws IOException
    {
        File outputFile = new File(fileName);
        PrintWriter outputWriter = new PrintWriter(outputFile);
        outputWriter.printf("Takeoffs at %s\n", airportName);
        outputWriter.printf("%-23s %-15s %-10s %-15s\n", "Flight ID", "Lift Off Time", "Gallons",  "Ticket Price");
        int numTicketB = 0;
		double sumTicketPriceB =0; 
		int numTicketA=0;
		double sumTicketPriceA =0; 
		double averageticketPriceB, averageTicketPriceA;
		Iterator <Airplane> aiplaneIter = departed.iterator();
		while(aiplaneIter.hasNext())
		{
			Airplane tempAirplane = aiplaneIter.next();
			outputWriter.printf("%-23s %-15d %-11d %-11.2f \n", tempAirplane.getAirplaneID(), tempAirplane.getLiftOffTime(), tempAirplane.getGallonsFuelLoaded(), tempAirplane.getTicketPrice());
			if(tempAirplane instanceof Boeing787)
			{
				numTicketB++;
				sumTicketPriceB = sumTicketPriceB + tempAirplane.getTicketPrice();
			}
			else
			{
				numTicketA++;
				sumTicketPriceA = sumTicketPriceA + tempAirplane.getTicketPrice();
			}
		}
		averageticketPriceB = (double)sumTicketPriceB/numTicketB;
		averageTicketPriceA = (double)sumTicketPriceA/numTicketA;
		outputWriter.printf("Average Boeing787 ticket price is $%.2f\n", averageticketPriceB);
		outputWriter.printf("Average AirBus319 ticket price is $%.2f\n", averageTicketPriceA);
		outputWriter.close();
    }
}
