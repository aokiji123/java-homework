package MusicalInstrument;

public abstract class MusicalInstrument {
    protected String name;
    protected String characteristics;

    public MusicalInstrument(String name, String characteristics) {
        this.name = name;
        this.characteristics = characteristics;
    }

    public abstract void play();
}