package com.github.hardelele.yandextask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer stringTokenizer;

    int countDishes, countIngredientsInPriceCatalog, countIngredientsInEatCatalog, fullPrice;

    Dish[] dishes;

    IngredientPrice[] priceCatalog;

    IngredientEat[] eatCatalog;

    private A() {
        input();
        result();
    }

    private void input() {
        countDishes = Integer.parseInt(inputString());
        dishes = new Dish[countDishes];
        inputAllDishes();
        countIngredientsInPriceCatalog = Integer.parseInt(inputString());
        priceCatalog = new IngredientPrice[countIngredientsInPriceCatalog];
        inputAllPrices();
        countIngredientsInEatCatalog = Integer.parseInt(inputString());
        eatCatalog = new IngredientEat[countIngredientsInEatCatalog];
        inputAllEats();
    }

    private void result() {
        calcFullPrice();
        printFullPrice();
    }

    private void calcDishPerformance() {

    }

    private void calcCountPackagesToBuy() {

    }

    private void calcFullPrice() {
        for (int counter = 0; counter < countDishes; counter++) {
            dishes[counter].calcPrice();
            fullPrice += dishes[counter].getPrice();
        }
    }

    private void printFullPrice() {
        System.out.println(fullPrice);
    }

    private void inputAllEats() {
        for (int counter = 0; counter < countIngredientsInPriceCatalog; counter++) {
            eatCatalog[counter] = inputIngredientInEatCatalog(inputString());
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private IngredientEat inputIngredientInEatCatalog(String ingredientStr) {
        IngredientEat ingredient = new IngredientEat();
        ingredient.inputIngredient(ingredientStr);
        return ingredient;
    }

    private void inputAllPrices() {
        for (int counter = 0; counter < countIngredientsInPriceCatalog; counter++) {
            priceCatalog[counter] = inputIngredientInPriceCatalog(inputString());
        }
    }

    public static void main(String[] args) {
        A a = new A();
    }

    private void inputAllDishes() {
        for (int counter = 0; counter < countDishes; counter++) {
            dishes[counter] = inputDish(inputString());
        }
    }

    private Dish inputDish(String dishStr) {
        stringTokenizer = new StringTokenizer(dishStr);
        Dish dish = new Dish();
        dish.setDishName(stringTokenizer.nextToken());
        dish.setFriendsWanted(Integer.parseInt(stringTokenizer.nextToken()));
        dish.setCountIngredients(Integer.parseInt(stringTokenizer.nextToken()));
        dish.inputIngredientsInfo();
        return dish;
    }

    private IngredientPrice inputIngredientInPriceCatalog(String ingredientStr) {
        IngredientPrice ingredient = new IngredientPrice();
        ingredient.inputIngredient(ingredientStr);
        return ingredient;
    }

    /**
     * Method that get input String. Using bufferedReader.
     * @return string, that user write.
     */
    private String inputString() {
        String string = "";
        try {
            string = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Вы ввели не корректные данные, попробуйте ещё раз!");
            inputString();
        }
        return string;
    }

    /**
     * Class of dishes, that input user.
     */
    public class Dish {

        private Dish() {
        }

        private int price;
        private String dishName;
        private int friendsWanted;
        private int countIngredients;
        double proteins, fats, carbohydrates, energyValue;

        private IngredientInfo[] ingredientsInfo;

        public void calcPrice() {
            int counter = 0;
            while (counter < countIngredients) {
                price += ingredientsInfo[counter].getIngredientPrice() * ingredientsInfo[counter].getIngredientCount();
            }
        }

        public int getPrice() {
            return price;
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
            ingredientsInfo = new IngredientInfo[countIngredients];
            for (int counter = 0; counter < countIngredients; counter++) {
                ingredientsInfo[counter] = new IngredientInfo();
                ingredientsInfo[counter].inputIngredientInfo(inputString());
            }
        }

        /**
         * Information about ingredients of current dish
         */
        public class IngredientInfo {

            private String ingredientName;
            private int required;
            private String unitName;
            int ingredientCountToBuy;
            int ingredientPrice;

            public IngredientInfo() {
            }

            public void inputIngredientInfo(String infoStr) {
                stringTokenizer = new StringTokenizer(infoStr);
                setIngredientName(stringTokenizer.nextToken());
                setRequired(Integer.parseInt(stringTokenizer.nextToken()));
                setUnitName(stringTokenizer.nextToken());
            }

            public int getIngredientPrice() {
                return ingredientPrice;
            }

            public void findIngredientPrice() {

            }

            public void calcIngredientCountToBuy(IngredientPrice ingredientFromCatalog) {

                int ingredientCountToBuy = 0;

                if(unitName.equals("kg")) {
                    setRequired(getRequired()*1000);
                    setUnitName("g");
                }

                if (ingredientFromCatalog.ingredientUnitName.equals("kg")) {
                    ingredientFromCatalog.setIngredientCount(ingredientFromCatalog.getIngredientCount()*1000);
                    ingredientFromCatalog.setIngredientUnitName("g");
                }

                if(unitName.equals("tens")) {
                    setRequired(getRequired()*10);
                    setUnitName("cnt");
                }

                if (ingredientFromCatalog.ingredientUnitName.equals("tens")) {
                    ingredientFromCatalog.setIngredientCount(ingredientFromCatalog.getIngredientCount()*10);
                    ingredientFromCatalog.setIngredientUnitName("cnt");
                }

                if(unitName.equals("l")) {
                    setRequired(getRequired()*1000);
                    setUnitName("ml");
                }

                if (ingredientFromCatalog.ingredientUnitName.equals("l")) {
                    ingredientFromCatalog.setIngredientCount(ingredientFromCatalog.getIngredientCount()*1000);
                    ingredientFromCatalog.setIngredientUnitName("ml");
                }

                while (required > 0) {
                    ingredientCountToBuy++;
                    required -= ingredientFromCatalog.getIngredientCount();
                }

                this.ingredientCountToBuy = ingredientCountToBuy;
            }

            public int getIngredientCount() {
                return ingredientCountToBuy;
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

            public String getUnitName() {
                return unitName;
            }

            public void setUnitName(String unitName) {
                this.unitName = unitName;
            }
        }
    }

    /**
     * Class of ingredients that we will contain in catalogs
     */
    public class IngredientPrice {

        String ingredientName;
        int ingredientPrice;
        int ingredientCount;
        String ingredientUnitName;

        public IngredientPrice() {
        }

        public void inputIngredient(String ingredientStr) {
            stringTokenizer = new StringTokenizer(ingredientStr);
            setIngredientName(stringTokenizer.nextToken());
            setIngredientPrice(Integer.parseInt(stringTokenizer.nextToken()));
            setIngredientCount(Integer.parseInt(stringTokenizer.nextToken()));
            setIngredientUnitName(stringTokenizer.nextToken());
        }

        public String getIngredientName() {
            return ingredientName;
        }

        public void setIngredientName(String ingredientName) {
            this.ingredientName = ingredientName;
        }

        public int getIngredientPrice() {
            return ingredientPrice;
        }

        public void setIngredientPrice(int ingredientPrice) {
            this.ingredientPrice = ingredientPrice;
        }

        public int getIngredientCount() {
            return ingredientCount;
        }

        public void setIngredientCount(int ingredientCount) {
            this.ingredientCount = ingredientCount;
        }

        public String getIngredientUnitName() {
            return ingredientUnitName;
        }

        public void setIngredientUnitName(String ingredientUnitName) {
            this.ingredientUnitName = ingredientUnitName;
        }
    }

    public class IngredientEat {

        String ingredientName;
        int ingredientCount;
        String ingredientUnitName;
        double proteins, fats, carbohydrates, energyValue;

        public IngredientEat() {
        }

        public void inputIngredient(String ingredientStr) {
            stringTokenizer = new StringTokenizer(ingredientStr);
            setIngredientName(stringTokenizer.nextToken());
            setIngredientCount(Integer.parseInt(stringTokenizer.nextToken()));
            setIngredientUnitName(stringTokenizer.nextToken());
            setProteins(Double.parseDouble(stringTokenizer.nextToken()));
            setFats(Double.parseDouble(stringTokenizer.nextToken()));
            setCarbohydrates(Double.parseDouble(stringTokenizer.nextToken()));
            setEnergyValue(Double.parseDouble(stringTokenizer.nextToken()));
        }

        public String getIngredientName() {
            return ingredientName;
        }

        public void setIngredientName(String ingredientName) {
            this.ingredientName = ingredientName;
        }

        public int getIngredientCount() {
            return ingredientCount;
        }

        public void setIngredientCount(int ingredientCount) {
            this.ingredientCount = ingredientCount;
        }

        public String getIngredientUnitName() {
            return ingredientUnitName;
        }

        public void setIngredientUnitName(String ingredientUnitName) {
            this.ingredientUnitName = ingredientUnitName;
        }

        public double getProteins() {
            return proteins;
        }

        public void setProteins(double proteins) {
            this.proteins = proteins;
        }

        public double getFats() {
            return fats;
        }

        public void setFats(double fats) {
            this.fats = fats;
        }

        public double getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(double carbohydrates) {
            this.carbohydrates = carbohydrates;
        }

        public double getEnergyValue() {
            return energyValue;
        }

        public void setEnergyValue(double energyValue) {
            this.energyValue = energyValue;
        }
    }
}
