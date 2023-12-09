package ru.geekbrains.lesson1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food>{

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;



    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancing()
    {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodstuffs)
        {
            if (!proteins && food.getProteins())
                proteins = true;
            else
            if (!fats && food.getFats())
                fats = true;
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
        {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        for (var thing : market.getThings(Food.class))
        {
            if (!proteins && thing.getProteins())
            {
                proteins = true;
                foodstuffs.add((T)thing);
            }
            else if (!fats && thing.getFats())
            {
                fats = true;
                foodstuffs.add((T)thing);
            }
            else if (!carbohydrates && thing.getCarbohydrates())
            {
                carbohydrates = true;
                foodstuffs.add((T)thing);
            }
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }
    public void streamBalance(){
        if(!foodstuffs.stream().anyMatch(Food::getFats)){
            foodstuffs.add(
                    (T) market.getThings(Food.class).stream()
                            .filter(s -> clazz.isAssignableFrom(s.getClass()))
                            .filter(Food::getFats).toList().get(0));
        }
        if(!foodstuffs.stream().anyMatch(Food::getProteins)){
            foodstuffs.add(
                    (T) market.getThings(Food.class).stream()
                            .filter(s -> clazz.isAssignableFrom(s.getClass()))
                            .filter(Food::getProteins).toList().get(0));

        }
        if(!foodstuffs.stream().anyMatch(Food::getCarbohydrates)){
            foodstuffs.add(
                    (T) market.getThings(Food.class).stream()
                            .filter(s -> clazz.isAssignableFrom(s.getClass()))
                            .filter(Food::getCarbohydrates).toList().get(0));
        }
    }

    public void PrintTtype(){

    }



}
