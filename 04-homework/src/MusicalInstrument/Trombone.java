package MusicalInstrument;

public class Trombone extends MusicalInstrument implements IInfo {
    public Trombone(String characteristics) {
        super("MusicalInstrument.Trombone", characteristics);
    }

    @Override
    public void sound() {
        System.out.println("The trombone produces a deep, brassy sound.");
    }

    @Override
    public void show() {
        System.out.println("Instrument: " + name);
    }

    @Override
    public void desc() {
        System.out.println("A trombone is a brass instrument, typically played with a slide.");
    }

    @Override
    public void history() {
        System.out.println("The trombone evolved in the 15th century from earlier brass instruments.");
    }

    @Override
    public void play() {
        System.out.println("Playing the trombone...");
    }
}
