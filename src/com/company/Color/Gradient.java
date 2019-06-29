package com.company.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class Gradient {
    ArrayList<Color> colors;
    ArrayList<Double> positions;

    public Gradient(ArrayList<Color> colors, ArrayList<Double> positions) {
        this.colors = colors;
        this.positions = positions;
    }

    public Gradient(ArrayList<Color> colors) {
        this.colors = colors;
        this.positions = new ArrayList<>();

        for (int i = 0; i < colors.size(); i++) {
            if (i == 0) {
                positions.add((double) 0);
                continue;
            }
            positions.add((double) i / (double) (colors.size() - 1));
        }
    }

    public Gradient(Color ... colors){
        this(new ArrayList<>(Arrays.asList(colors)));
    }

    public Color getAt(double x) {
        if (positions.size()<=0){
            return new Color();
        }
        if (positions.size()==1){
            return colors.get(0);
        }

        int i = 1;
        while (i < positions.size() && x > positions.get(i)) {
            i++;
        }

        double r = calculatePrimary(colors.get(i).getRed(), colors.get(i - 1).getRed(), positions.get(i), positions.get(i - 1), x);
        double g = calculatePrimary(colors.get(i).getGreen(), colors.get(i - 1).getGreen(), positions.get(i), positions.get(i - 1), x);
        double b = calculatePrimary(colors.get(i).getBlue(), colors.get(i - 1).getBlue(), positions.get(i), positions.get(i - 1), x);

        return new Color(r, g, b);
    }

    private double calculatePrimary(double c2, double c1, double p2, double p1, double p) {
        return c1 - (c1 - c2) * (p - p1) / (p2 - p1);
    }
}
