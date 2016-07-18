package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private int lowerBorder;
    private int upperBorder;
    private int secretValue;
    /**
     * a variable for saving user statistic.
     */
    private List<Integer> statistic;

    public Model() {
        statistic = new ArrayList<>();
    }

    /**
     *
     * @param min lower border of random value.
     * @param max upper border of random value.
     * @return random value from min to max. Don't include borders.
     */
    private int rand(int min, int max) {
        return min + (int)(Math.random() * ((max - min - 1)) + 1);
    }

    /**
     *
     * @return return random value from zero to max integer. Don't include borders.
     */
    private int rand() {
        return (int)(Math.random() * (Integer.MAX_VALUE - 1) + 1);
    }

    /**
     * Method checks the coincidence between user's number and the hidden number.
     * If values are not equal set proper lower or upper border depends on value of user's number.
     * @param userNumber the number which user input in console.
     * @return true if user's number is equal to the hidden number. False if not.
     */
    public boolean checkUserNumber(int userNumber) {
        this.addTurn(userNumber);
        if(userNumber < this.getSecretValue()) {
            this.setLowerBorder(userNumber);
        }
        else
            if(userNumber > this.getSecretValue()) {
                this.setUpperBorder(userNumber);
            }
            else //if user's number is equal to the hidden number.
                return true;

        return false;
    }

    /**
     * Set upper and lower borders
     * @param lowerBorder lower border
     * @param upperBorder upper border
     */
    public void setBorders(int lowerBorder, int upperBorder) {
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
    }

    /**
     * Initialize secretValue with a random number
     */
    public void setSecretValue() {
        this.secretValue = rand(lowerBorder, upperBorder);
    }

    /**
     * Method for saving user's turns.
     * @param userNumber a number which user input the last time.
     */
    public void addTurn(int userNumber) {
        statistic.add(userNumber);
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getUpperBorder() {
        return upperBorder;
    }

    public void setUpperBorder(int upperBorder) {
        this.upperBorder = upperBorder;
    }

    public int getLowerBorder() {
        return lowerBorder;
    }

    public void setLowerBorder(int lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    public List<Integer> getStatistic() {
        return statistic;
    }
}
