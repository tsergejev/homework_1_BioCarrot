import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static double averageAmountOfCarrotPerContract(int contracts, double tonsOfCarrot){

        if (contracts > 0){
            return tonsOfCarrot / contracts;
        }
        return 0;
    }

    //I was trying to create class for SPZ, checking second digit - should contains only landscape character, other chars should be digits or capital alphabetical. I only considered 7 chars long plate, not checking diplomatic plate, nor "war vehicles", veterans, sport cars, etc. (I was counting customer will only consider normal vehicles, no diplomats or generals will be delivering carrot :D  )
    public static class VehicleRegistrationPlate {
        String spz = "N/A";
        public VehicleRegistrationPlate(String spz){
            ArrayList<String> landscape = new ArrayList<>();
            landscape.add("A");
            landscape.add("B");
            landscape.add("C");
            landscape.add("E");
            landscape.add("H");
            landscape.add("J");
            landscape.add("K");
            landscape.add("L");
            landscape.add("M");
            landscape.add("P");
            landscape.add("S");
            landscape.add("T");
            landscape.add("U");
            landscape.add("Z");
            if(spz.length() != 7){
                System.out.println("Vehicle registration plate must contains 7 characters!");
            }
            else if(!landscape.contains(spz.substring(1,2))){
                System.out.println("Second character should contains landscape character");
            }
            else if(digitOrUpperCase(spz)){
                this.spz = spz;
            }

        }
        private boolean digitOrUpperCase(String registrationPlate){
            for(int i = 0; i<7; i++) {
                String oneChar = registrationPlate.substring(i, i + 1);
                if (!oneChar.matches("[A-Z]") && !oneChar.matches("[0-9]")){
                    System.out.println("Vehicle registration plate should contains only upper case alphabet chars [A-Z] or digits [0-9]");
                return false;
                }
            }
            return true;
        }
        public String getSpz(){
            return this.spz;
        }
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        String firstName = "Karel";
        String lastName = "Mrkva";
        LocalDate birthDate = LocalDate.of(1995, 12, 10);
        int contracts = 10;
        double tonsOfCarrot = 12345.6;
        String city = "Plzen";
        VehicleRegistrationPlate plate = new VehicleRegistrationPlate("1M2115A");
        double fuelConsumption = 10.2;
        //wanted to try the java class for IP, exception not handled correctly, I know...
        byte[] ipAddr = new byte[] { 127, 0, 0, 1 };
        try {
            Inet4Address IPaddress = (Inet4Address) Inet4Address.getByAddress(ipAddr);
            System.out.println(IPaddress);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(plate.getSpz());
        System.out.println(birthDate);
        System.out.println("Number of sold tons of carrot per contract: " + averageAmountOfCarrotPerContract(contracts, tonsOfCarrot));

    }
}