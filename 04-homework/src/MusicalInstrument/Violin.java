package MusicalInstrument;

public class Violin extends MusicalInstrument implements IInfo {
    public Violin(String characteristics) {
        super("MusicalInstrument.Violin", characteristics);
    }

    @Override
    public void sound() {
        System.out.println("The violin produces a beautiful, resonant sound.");
    }

    @Override
    public void show() {
        System.out.println("Instrument: " + name);
    }

    @Override
    public void desc() {
        System.out.println("A violin is a string instrument, typically played with a bow.");
    }

    @Override
    public void history() {
        System.out.println("The violin originated in Italy in the early 16th century.");
    }

    @Override
    public void play() {
        System.out.println("Playing the violin...");
    }
}
