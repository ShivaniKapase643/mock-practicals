
import java.util.*;

class Knapsack {
    public static void main(String[] args) {
        int[] weight = {5, 10, 15, 22, 25};
        int[] value = {30, 40, 45, 77, 90};
        int capacity = 60;

        double[] ratio = new double[weight.length];

        for (int i = 0; i < weight.length; i++) {
            ratio[i] = (double) value[i] / weight[i];
        }

        // Sort items by value/weight ratio in decreasing order
        for (int i = 0; i < weight.length - 1; i++) {
            for (int j = i + 1; j < weight.length; j++) {
                if (ratio[i] < ratio[j]) {
                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    int t = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t;

                    t = value[i];
                    value[i] = value[j];
                    value[j] = t;
                }
            }
        }

        double totalValue = 0;

        for (int i = 0; i < weight.length; i++) {
            if (capacity >= weight[i]) {
                capacity -= weight[i];
                totalValue += value[i];
            } else {
                totalValue += ratio[i] * capacity;
                break;
            }
        }

        System.out.println("Maximum value = " + totalValue);
    }
}
