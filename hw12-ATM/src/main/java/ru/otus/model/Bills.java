package ru.otus.model;

import lombok.Getter;

@Getter
public enum Bills {
    RUB_100(100),
    RUB_200(200),
    RUB_500(500),
    RUB_1000(1000),
    RUB_2000(2000),
    RUB_5000(5000);

    public static final int ZERO = 0;
    private final int par;

    Bills(int par) {
        this.par = par;
    }

    public int getPar() {
        return par;
    }

}
