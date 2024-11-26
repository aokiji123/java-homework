package MusicalInstrument;

public class Ukulele extends MusicalInstrument implements IInfo {
    public Ukulele(String characteristics) {
        super("MusicalInstrument.Ukulele", characteristics);
    }

    @Override
    public void sound() {
        System.out.println("The ukulele produces a light, cheerful sound.");
    }

    @Override
    public void show() {
        System.out.println("Instrument: " + name);
    }

    @Override
    public void desc() {
        System.out.println("A ukulele is a small, four-stringed instrument from Hawaii.");
    }

    @Override
    public void history() {
        System.out.println("The ukulele was developed in Hawaii in the late 19th century.");
    }

    @Override
    public void play() {
        System.out.println("Playing the ukulele...");
    }
}

