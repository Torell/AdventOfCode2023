package Day9;


import java.util.*;

public class HandPart2 {

    private LinkedHashMap<Integer, Integer> cards;

    private double handPower;
    private int bid;
    private double rank;

    private double equalScoreSettler;

    public HandPart2(LinkedHashMap<Integer, Integer> cards, int bid, double equalScoreSettler) {
        this.cards = cards;
        this.bid = bid;
        this.equalScoreSettler = equalScoreSettler;
    }

    public void calculateHandPower() {
       // System.out.println("-----------------------");
        Set<Map.Entry<Integer, Integer>> cardPairs = new LinkedHashSet<>();

        for (Map.Entry<Integer, Integer> entry : cards.entrySet()) {

            if (entry.getValue() > 1) {
                System.out.println("--------");
                System.out.println("Card " + entry.getKey() + " Value: " +  entry.getValue());
                cardPairs.add(entry);
                System.out.println("--------");
            }
        }

        Iterator <Map.Entry<Integer, Integer>> iterator = cardPairs.iterator();



        if (!cardPairs.isEmpty()) {
            Map.Entry<Integer, Integer> firstPair = iterator.next();
            setHandPower(firstPair.getValue());
        }
         if (cardPairs.size() == 2) {
            Map.Entry<Integer, Integer> secondPair = iterator.next();
            setHandPower(getHandPower() + secondPair.getValue());
            if (getHandPower() == 5) {
                setHandPower(getHandPower() -1.5);
            } else if (getHandPower() == 4) {
                setHandPower(getHandPower() - 1.5);
            }
        }


        setHandPower(getHandPower() + equalScoreSettler);

    }

    public void setHandPower(double handPower) {
        this.handPower = handPower;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public double getHandPower() {
        return handPower;
    }

    public double getBid() {
        return bid;
    }

    public double getRank() {
        return rank;
    }

    public LinkedHashMap<Integer, Integer> getCards() {
        return cards;
    }

    public double getEqualScoreSettler() {
        return equalScoreSettler;
    }
}
