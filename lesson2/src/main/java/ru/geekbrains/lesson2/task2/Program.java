package ru.geekbrains.lesson2.task2;

import java.lang.reflect.Field;

public class Program {

    /**
     * Задача 2: Применение Reflection API в разработке
     * ================================================
     * <p>
     * Реализуйте обобщенный метод, который принимает объект и выводит в консоль значения всех его полей.
     * Создайте класс "Car" с различными полями (например, модель, цвет, год выпуска).
     * Примените Reflection API для вывода значений полей созданного объекта класса "Car"
     * с использованием ранее созданного метода.
     */
    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("Toyota", "Blue", 2022);
        task2(car);
    }

    private static <T> void task2 (T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();

        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true); // Разрешаем доступ к закрытому полю
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
    }

}
