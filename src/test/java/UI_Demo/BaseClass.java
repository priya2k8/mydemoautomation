package UI_Demo;

public class BaseClass {
    static String cnote = "" + (long) (Math.random() * 100000 + 3333300000L);
    static String cnotebarcode = "" + (long) (Math.random() * 100000 + 3333300000L);
    public static String VehicleNo(){
        int alpha1 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int alpha2 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int alpha3 = 'A' + (int)(Math.random() * ('Z' - 'A'));
        int digit1 = (int)(Math.random() * 10);
        int digit2 = (int)(Math.random() * 10);
        int digit3 = (int)(Math.random() * 10);
        int digit4 = (int)(Math.random() * 10);
        String vehicleNum = (""+(char)(alpha1) + ((char)(alpha2)) +digit1+digit4+
                ((char)(alpha3)) +(char)(alpha1)+ digit1 + digit2 + digit3 + digit4);
        return vehicleNum;
    }

}
