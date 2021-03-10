package ru.job4j.oop;

import static java.lang.Math.*;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double halfPeriod(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean existOfTriangle(double ab, double ac, double bc) {
        return ab + ac > bc && ab + bc > ac && bc + ac > ab;
    }

    public double area() {
        double sum = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = halfPeriod(ab, ac, bc);
        if (this.existOfTriangle(ab, ac, bc)) {
            sum = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return sum;
    }
}
