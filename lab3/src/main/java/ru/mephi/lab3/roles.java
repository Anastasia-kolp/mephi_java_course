package ru.mephi.lab3;

public enum Roles {
    STAFF(0.1), MANAGER(0.2), EXECUTIVE(0.3);
    private final double premium;

    Roles(double v) {
        this.premium = v;
    }

    public double getProcent() {
        return premium;
    }
}
