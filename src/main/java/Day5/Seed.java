package Day5;

public class Seed {
    private double seedNumber;

    private double seedRange;

    public Seed(double seedNumber) {
        this.seedNumber = seedNumber;
    }

    public Seed(double seedNumber, double seedRange) {
        this.seedNumber = seedNumber;
        this.seedRange = seedRange;
    }

    public double getSeedRange() {
        return seedRange;
    }

    public void setSeedRange(double seedRange) {
        this.seedRange = seedRange;
    }

    public double getSeedNumber() {
        return seedNumber;
    }

    public void setSeedNumber(double seedNumber) {
        this.seedNumber = seedNumber;
    }
}
