//package com.github.hardelele.it.yandextask;
//
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class A {
//
//    Receiver receiver = new Receiver();
//
//    int countDishes, countIngredientsInPriceCatalog, countIngredientsInEatCatalog, fullPrice;
//
//    Dish[] dishes;
//
//    private A() {
//        input();
//        result();
//    }
//
//    private void input() {
//        this.countDishes = receiver.inputInt();
//        fillArrayOfDishes();
//    }
//
//    private void fillArrayOfDishes() {
//        dishes = new Dish[countDishes];
//        for (int counter = 0; counter < countDishes; counter++) {
//            dishes[counter] = new Dish();
//        }
//    }
//
//    private void inputPrices() {
//
//    }
//
//    private void result() {
//
//    }
//
//    public static void main(String[] args) {
//        A a = new A();
//    }
//}
//
///*
//-------------------------------------------------------------------
// */
//
//class Receiver {
//    Scanner scanner = new Scanner(System.in);
//
//    public String inputString() {
//        return scanner.nextLine();
//    }
//
//    public int inputInt() {
//        return scanner.nextInt();
//    }
//
//    public double inputDouble() {
//        return scanner.nextDouble();
//    }
//}
//
///*
//-------------------------------------------------------------------
// */
//
//class IngredientInfo {
//
//    Receiver receiver = new Receiver();
//
//    StringTokenizer stringTokenizer;
//
//    public IngredientInfo() {
//        stringTokenizer = new StringTokenizer(receiver.inputString());
//        setIngredientName(stringTokenizer.nextToken());
//        setRequired(Integer.parseInt(stringTokenizer.nextToken()));
//        setUnitName(stringTokenizer.nextToken());
//        if (unitName.equals("kg")) {
//            setRequired(required*1000);
//            setUnitName("g");
//        } else if (unitName.equals("l")) {
//            setRequired(required*1000);
//            setUnitName("ml");
//        } else if (unitName.equals("tens")) {
//            setRequired(required*10);
//            setUnitName("cnt");
//        }
//    }
//
//    private int shouldBuy;
//    private String ingredientName;
//    private int required;
//    private String unitName;
//    private int ingredientPrice;
//    private double proteins, fats, carbohydrates, energyValue;
//
//    public void setIngredientName(String ingredientName) {
//        this.ingredientName = ingredientName;
//    }
//
//    public void setRequired(int required) {
//        this.required = required;
//    }
//
//    public void setUnitName(String unitName) {
//        this.unitName = unitName;
//    }
//
//    public String getIngredientName() {
//        return ingredientName;
//    }
//
//    public void setPrice(int price, int count, String unitName) {
//        if (unitName.equals("kg")) {
//            count = count*1000;
//            unitName = "g";
//        } else if (unitName.equals("l")) {
//            count = count*1000;
//            unitName = "ml";
//        } else if (unitName.equals("tens")) {
//            count = count*10;
//            unitName = "cnt";
//        }
//
//        while (required > 0) {
//            shouldBuy++;
//            required -= ingredientFromCatalog.getIngredientCount();
//        }
//    }
//}
//
///*
//-------------------------------------------------------------------
// */
//
//class Dish {
//
//    Receiver receiver = new Receiver();
//
//    StringTokenizer stringTokenizer;
//
//    public Dish() {
//        stringTokenizer = new StringTokenizer(receiver.inputString());
//        setDishName(stringTokenizer.nextToken());
//        setFriendsWanted(Integer.parseInt(stringTokenizer.nextToken()));
//        setCountIngredients(Integer.parseInt(stringTokenizer.nextToken()));
//        ingredientsInfo = new IngredientInfo[countIngredients];
//        for (int counter = 0; counter < countIngredients; counter++) {
//            ingredientsInfo[counter] = new IngredientInfo();
//        }
//    }
//
//    private int price;
//    private String dishName;
//    private int friendsWanted;
//    private int countIngredients;
//    private double proteins, fats, carbohydrates, energyValue;
//
//    public void setDishName(String dishName) {
//        this.dishName = dishName;
//    }
//
//    public void setFriendsWanted(int friendsWanted) {
//        this.friendsWanted = friendsWanted;
//    }
//
//    public void setCountIngredients(int countIngredients) {
//        this.countIngredients = countIngredients;
//    }
//
//    private void setPriceOfIngredientByName(String name, int price, int count, String unitName) {
//        for (int counter = 0; counter < countIngredients; counter++) {
//           if (ingredientsInfo[counter].getIngredientName().equals(name)) {
//               ingredientsInfo[counter].setPrice(price, count, unitName);
//           }
//        }
//    }
//
//    private IngredientInfo[] ingredientsInfo;
//}