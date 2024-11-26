package MusicalInstrument;

public class Cello extends MusicalInstrument implements IInfo {
    public Cello(String characteristics) {
        super("MusicalInstrument.Cello", characteristics);
    }

    @Override
    public void sound() {
        System.out.println("The cello produces a deep, rich sound.");
    }

    @Override
    public void show() {
        System.out.println("Instrument: " + name);
    }

    @Override
    public void desc() {
        System.out.println("A cello is a large string instrument, played with a bow.");
    }

    @Override
    public void history() {
        System.out.println("The cello evolved in Italy in the early 16th century.");
    }

    @Override
    public void play() {
        System.out.println("Playing the cello...");
    }
}

