package ru.geekbrains.lesson1.task2;

/**
 * Чебурек
 */
public class Cheburek implements SemiFinishedFood{
    @Override
    public boolean getProteins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Чебурек";
    }


}
