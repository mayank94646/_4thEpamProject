import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
class Cost
{
    String material;
    int area;
    String automation;
    int price;
    Cost(String material,int area,String automation)
    {
        this.material=material;
        this.area=area;
        this.automation=automation;
        this.price=0;
    }
    int calculateCost()
    {
        if(material.equalsIgnoreCase("standard"))
        {
            if(automation.equalsIgnoreCase("fully"))
                price+=2000*area;//1200->standard&&700->fully
            else
                price+=1500*area;
        }
        else if(material.equalsIgnoreCase("above standard"))
        {
            if(automation.equalsIgnoreCase("fully"))
                price+=2100*area;//1500->high standard&&700->fully
            else
                price+=900*area;
        }
        else if(material.equalsIgnoreCase("high standard"))
        {
            if(automation.equalsIgnoreCase("fully"))
                price+=3500*area;//1800->high standard&&700->fully
            else
                price+=2000*area;
        }
        return price;
    }
}
public class consHouse
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Your material");
        String m= scanner.nextLine();
        System.out.println("your area");
        int a= scanner.nextInt();
        System.out.println("your automation type");
        String automation=scanner.next();
        Cost cost=new Cost(m,a,automation);
        int finalPrice=cost.calculateCost();
        try
        {
            FileOutputStream fileOutputStream=new FileOutputStream("E:\\Assignment4\\src\\main\\Output");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.write(finalPrice);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
