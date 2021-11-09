package ru.mephi.lab3;

public enum roles {
    STAFF(0.1), MANAGER(0.2), EXECUTIVE(0.3);
    private final double premium;

    roles(double v) {
        this.premium = v;
    }

    public double getProcent() {
        return premium;
    }
}
