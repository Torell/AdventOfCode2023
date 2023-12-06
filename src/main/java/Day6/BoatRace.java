package Day6;

public class BoatRace {

    private double time;

    private double recordDistance;

    public BoatRace(double time, double recordDistancedistance) {
        this.time = time;
        this.recordDistance = recordDistancedistance;
    }

    public boolean raceWin(double buttonPushed) {

        double distance = (time - buttonPushed) * (buttonPushed);

        return distance > recordDistance;

        // distance = time x velocity
        // velocity = 1 x n
        // time = time - n
        //distance = (time - n) x (1 x n)
        // distance = time x n - n2

        // distance = recordDistance
        // record distance - time x n - n2 = 0;


        // lowest possible n

    }

    public double solveForX() {
        //distance = (time - n) x (1 x n)
        // distance = time x n - n2
        // 0 = time * n - n2 + distance
        // -n2 + time * n-distance = 0;

        // distanceTraveled = (time - n) * n
        // distanceTraveled = time * n - n2
        // when is time * n - n2 = recordDistance

        //LOWEST VALUE
        // -x2 + time * x-recorDistance = 0;

        //HIGEST VALUE

        // 7637313 * n = recordDistance


        //When is nFormula > Lowest value && n < nFormula
        return (time - Math.sqrt(Math.pow(time, 2) - 4 * (recordDistance))) / 2;
    }

    public double solveForX2() {
        return (time + Math.sqrt(Math.pow(time, 2) - 4 * (recordDistance))) / 2;
    }

    public double maxPoint() {
        return (time / 2.0);
    }

    public int calculatePart2() {
        //Castar till int för att runda ner
        int x = (int) solveForX();
        int x2 = (int)solveForX2();

        return x2 - x;



    }


    public double getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getRecordDistance() {
        return recordDistance;
    }

    public void setRecordDistance(long recordDistance) {
        this.recordDistance = recordDistance;
    }
}
