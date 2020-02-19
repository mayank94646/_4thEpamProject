import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
class calculateInterest
{
    int principal;
    int rate;
    int time;
    double simpleInterest;
    double compoundInterest;
    calculateInterest(int principal, int rate, int time)
    {
        this.principal=principal;
        this.rate=rate;
        this.time=time;
    }
    public double SimpleInterest()
    {
        simpleInterest=(principal*rate*time)/100;
        return simpleInterest;
    }
    public double CompoundInterest()
    {
        double value=Math.pow((1-rate/100),time);
        compoundInterest=principal*(value-1);
        return compoundInterest;
    }
}
public class getInterest
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int principal=s.nextInt();
        int rate=s.nextInt();
        int time=s.nextInt();
        calculateInterest cal=new calculateInterest(principal,rate,time);
        double si=cal.SimpleInterest();
        double ci=cal.CompoundInterest();
        try
        {
            FileOutputStream fileOutputStream=new FileOutputStream("E:\\Assignment4\\src\\main\\Output");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeDouble(si);
            objectOutputStream.writeDouble(ci);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }}
