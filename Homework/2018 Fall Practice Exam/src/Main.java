import javax.swing.*;
import java.io.*;

import static javax.swing.JOptionPane.*;

public class Main {
    static MushroomRegister register;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filnavn = "soppregister.ser";
        try {
           register = readFromFile(filnavn);
        }
        catch(Exception e){
            e.printStackTrace();
            register = null;
        }
        if (register == null) {
            register = new MushroomRegister(); // metode som opppretter ett tomt register }
            String[] muligheter = {"List alle", "List matsopper", "Legg til ny", "Søk", "Avslutt"};
            final int LIST_ALLE = 0;
            final int LIST_MATSOPPER = 1;
            final int REG_SOPP = 2;
            final int SOK = 3;
            final int AVSLUTT = 4;
            int valg = showOptionDialog(null, "Velg", "Eksamen des 2018", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
            while (valg != AVSLUTT) {
                try {
                    switch (valg) {
                        case LIST_ALLE:
                            System.out.println(register.toString());
                            break;
                        case LIST_MATSOPPER:
                            System.out.println("These are all the edible mushrooms currently in the register: ");
                            for (Mushroom edibleMush : register.edibleMushrooms()) {
                                if(edibleMush != null) {
                                    System.out.println(edibleMush.toString());
                                }
                            }
                            break;
                        case REG_SOPP:
                            String name = JOptionPane.showInputDialog("What is the name of the mushroom?");
                            String description = JOptionPane.showInputDialog("Describe the mushroom");
                            boolean poisonous = Boolean.parseBoolean(JOptionPane.showInputDialog("Write true if poisonous and false if not"));
                            if (register.registerNewMushroom(name, description, poisonous)) {
                                System.out.println("The mushroom has successfully been registered!");
                            } else {
                                System.out.println("It seems this mushroom has already been registered!");
                            }
                            break;
                        case SOK:
                            String desc = JOptionPane.showInputDialog("How would you describe the mushroom?");
                            System.out.println(register.findMushroomByDesc(desc));
                            break;
                        default:
                            break;
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                valg = showOptionDialog(null, "Velg", "Eksamen des 2018", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
            }
            writeToFile(filnavn, register);
        }
    }

    public static MushroomRegister readFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream readerMushReg = new FileInputStream(fileName);
        ObjectInputStream mushObjRead = new ObjectInputStream(readerMushReg);
        MushroomRegister mushroomReg = (MushroomRegister) mushObjRead.readObject();
        mushObjRead.close();
        readerMushReg.close();
        return mushroomReg;
    }

    public static void writeToFile(String fileName, MushroomRegister register) throws IOException {
        FileOutputStream writerReg = new FileOutputStream(fileName);
        ObjectOutputStream mushObjWrite = new ObjectOutputStream(writerReg);
        mushObjWrite.writeObject(register);
        mushObjWrite.close();
        writerReg.close();
    }

    


}



