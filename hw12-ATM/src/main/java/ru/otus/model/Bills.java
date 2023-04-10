package ru.otus.model;


public enum Bills {
    RUB_100(100),
    RUB_200(200),
    RUB_500(500),
    RUB_1000(1000),
    RUB_2000(2000),
    RUB_5000(5000);

    Bills(int banknoteDenomination) {
        this.banknoteDenomination = banknoteDenomination;
    }

    private final int banknoteDenomination;

}
