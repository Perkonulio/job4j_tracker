package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare zayac = new Hare();
        Wolf volk = new Wolf();
        Fox lisa = new Fox();
        kolobok.tryRun();
        zayac.tryEat(kolobok);
        kolobok.tryRun();
        volk.tryEat(kolobok);
        kolobok.tryRun();
        lisa.tryEat(kolobok);
    }
}
