package Day5;

public class Map {
    private double destinationRange;

    private double sourceRange;

    private double rangeLength;

    public Map(double destinationRange, double sourceRange, double rangeLength) {
        this.destinationRange = destinationRange;
        this.sourceRange = sourceRange;
        this.rangeLength = rangeLength;
    }

    public double convertToDestination(double input) {

        if (input >= this.sourceRange && input <= (sourceRange+rangeLength)) {
            Double numberFromRange = input - sourceRange;
            System.out.println("seed in: " + input);
            System.out.println("seed out " + (destinationRange+numberFromRange));
            return destinationRange+numberFromRange;

        }
        return input;
    }

    public double getSourcePlusRangeLength() {
        return sourceRange + rangeLength;
    }

    public boolean isWithinRange(double seednumber) {
        return seednumber >= sourceRange && seednumber <= getSourcePlusRangeLength();

    }

    public double getDestinationRange() {
        return destinationRange;
    }

    public void setDestinationRange(double destinationRange) {
        this.destinationRange = destinationRange;
    }

    public double getSourceRange() {
        return sourceRange;
    }

    public void setSourceRange(double sourceRange) {
        this.sourceRange = sourceRange;
    }

    public double getRangeLength() {
        return rangeLength;
    }

    public void setRangeLength(double rangeLength) {
        this.rangeLength = rangeLength;
    }
}
