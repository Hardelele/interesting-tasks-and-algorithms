package com.github.hardelele.yandextask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer;

    int countDishes, countIngredientsInPriceCatalog, countIngredientsInEatCatalog;

    Dish[] dishes;

    private A() {
        countDishes = inputCountOfDishes();
        dishes = inputDishesInfo();
        inputIngredientsInfoOfAllDishes();
        countIngredientsInPriceCatalog = inputCountIngredientsInPriceCatalog();
        // code
        countIngredientsInEatCatalog = inputCountIngredientsInEatCatalog();
        // code
    }

    public static void main(String[] args) {
        A a = new A();
    }

    private void printException() {
        System.out.println("Вы ввели не корректные данные, попробуйте снова!");
    }

    /**
     * User setting countDishes value
     */
    private int inputCountOfDishes() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            printException();
            inputCountOfDishes();
            return -1;
        }
    }

    private int inputCountIngredientsInPriceCatalog() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            printException();
            inputCountIngredientsInPriceCatalog();
            return -1;
        }
    }

    private int inputCountIngredientsInEatCatalog() {
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            printException();
            inputCountIngredientsInEatCatalog();
            return -1;
        }
    }

    private void inputIngredientsInfoOfAllDishes(){
        for (int counter = 0; counter < countDishes; counter++) {
            dishes[counter].inputIngredientsInfo();
        }
    }

    private Dish[] inputDishesInfo() {

        Dish[] dishes = new Dish[countDishes];

        int counter = 0;
        while (counter < countDishes) {

            dishes[counter] = new Dish();
            try {
                dishes[counter].setDishName(bufferedReader.readLine());
                dishes[counter].setFriendsWanted(Integer.parseInt(bufferedReader.readLine()));
                dishes[counter].setCountIngredients(Integer.parseInt(bufferedReader.readLine()));

                counter++;
            } catch (IOException e) {
                printException();
            }
        }

        return dishes;
    }

    private class Ingredient {

    }

    private class IngredientInfo {

        private String ingredientName;
        private int required;
        private String unitName;

        public IngredientInfo() {
        }

        public IngredientInfo(String ingredientName, int required, String unitName) {
            this.ingredientName = ingredientName;
            this.required = required;
            this.unitName = unitName;
        }

        public String getIngredientName() {
            return ingredientName;
        }

        public void setIngredientName(String ingredientName) {
            this.ingredientName = ingredientName;
        }

        public int getRequired() {
            return required;
        }

        public void setRequired(int required) {
            this.required = required;
        }

        public String getUnit() {
            return unitName;
        }

        public void setUnit(String unitName) {
            this.unitName = unitName;
        }
    }

    private class Dish {

        private String dishName;
        private int friendsWanted;
        private int countIngredients;


        IngredientInfo[] ingredientsInfo = new IngredientInfo[countIngredients];

        public Dish() {
        }

        public Dish(String dishName, int friendsWanted, int countIngredients) {
            this.dishName = dishName;
            this.friendsWanted = friendsWanted;
            this.countIngredients = countIngredients;
        }

        public String getDishName() {
            return dishName;
        }

        public void setDishName(String dishName) {
            this.dishName = dishName;
        }

        public int getFriendsWanted() {
            return friendsWanted;
        }

        public void setFriendsWanted(int friendsWanted) {
            this.friendsWanted = friendsWanted;
        }

        public int getCountIngredients() {
            return countIngredients;
        }

        public void setCountIngredients(int countIngredients) {
            this.countIngredients = countIngredients;
        }

        public void inputIngredientsInfo() {

            int counter = 0;
            while (counter < countIngredients) {
                ingredientsInfo[counter] = new IngredientInfo();
                try {
                    ingredientsInfo[counter].setIngredientName(bufferedReader.readLine());
                    ingredientsInfo[counter].setRequired(Integer.parseInt(bufferedReader.readLine()));
                    ingredientsInfo[counter].setUnit(bufferedReader.readLine());

                    counter++;
                } catch (IOException e) {
                    printException();
                }
            }
        }

        public IngredientInfo[] getIngredientsInfo() {
            return ingredientsInfo;
        }
    }
}
