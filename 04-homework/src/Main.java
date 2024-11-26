import ATM.*;
import Cipher.*;
import MusicalInstrument.*;
import HouseBuilder.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // ATM
        ATM atm1 = new ATM(10, 5);
        atm1.loadCash(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10});

        ATM atm2 = new ATM(20, 5);
        atm2.loadCash(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5});

        Bank bank = new Bank();
        bank.addATM(atm1);
        bank.addATM(atm2);

        System.out.println("Total money in bank: " + bank.getTotalCashInBank());

        int[] withdrawn = atm1.withdrawCash(40);
        System.out.println("Withdrawn from ATM1: " + Arrays.toString(withdrawn));

        System.out.println("Total money in bank after withdrawal: " + bank.getTotalCashInBank());

        System.out.println("\n------------------------------------------\n");

        // Cipher
        ICipher aCipher = new ACipher();
        String input1 = "Hello, World!";
        String encoded1 = aCipher.encode(input1);
        String decoded1 = aCipher.decode(encoded1);

        System.out.println("ACipher Encoding: " + encoded1);
        System.out.println("ACipher Decoding: " + decoded1);

        ICipher bCipher = new BCipher();
        String input2 = "Hello, World!";
        String encoded2 = bCipher.encode(input2);
        String decoded2 = bCipher.decode(encoded2);

        System.out.println("BCipher Encoding: " + encoded2);
        System.out.println("BCipher Decoding: " + decoded2);

        System.out.println("\n------------------------------------------\n");

        // Musical Instrument
        IInfo[] instruments = new IInfo[4];

        instruments[0] = new Violin("4 strings, wooden body, bow");
        instruments[1] = new Trombone("Brass, with a slide");
        instruments[2] = new Ukulele("Small, 4 strings, wood body");
        instruments[3] = new Cello("Large, 4 strings, played with a bow");

        for (IInfo instrument : instruments) {
            instrument.show();
            instrument.desc();
            instrument.history();
            instrument.sound();
        }

        System.out.println("\n------------------------------------------\n");

        // HouseBuilder
        House house = new House();

        Worker worker1 = new Worker(house);
        Worker worker2 = new Worker(house);
        Worker worker3 = new Worker(house);
        Worker worker4 = new Worker(house);
        Worker worker5 = new Worker(house);
        Worker worker6 = new Worker(house);
        Worker worker7 = new Worker(house);
        Worker worker8 = new Worker(house);
        Worker worker9 = new Worker(house);
        Worker worker10 = new Worker(house);
        Worker worker11 = new Worker(house);

        TeamLeader leader = new TeamLeader();

        Worker[] workers = {worker1, worker2, worker3, worker4, worker5, worker6, worker7, worker8, worker9, worker10, worker11};
        Team team = new Team(workers, leader);

        team.startWork(house);
    }
}