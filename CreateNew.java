package org.example;

import java.util.Scanner;

public class CreateNew {
    SmthToDo printSmth = new SmthToDo();

    public void newProductsAuto(String[][] prod){
        String[] names = {"Lambo", "Iphone", "Samsung", "House", "BMW", "Jet", "New wife", "Water", "XBox", "Shoes", "Shorts"} ;
        String[] price = {"50", "7", "6", "25", "28", "80", "4", "2", "5", "6", "18"};
        for(int i = 0; i < 11; i++){
            prod[i][0] = String.valueOf(i+1);
            prod[i][1] = names[i];
            prod[i][2] = price[i];
            prod[i][3] = "";
        }
        System.out.println("\n");
        printSmth.allProd(prod);
    }
    public String[][] newUser(int amount, int manAut){
        String[][] newUserArr =  new String[amount][5];

        do {
            Scanner in = new Scanner(System.in);
            if (manAut == 1) {
                String[] names = {"Mike", "Sasha", "Masha", "Den", "Maks", "Krysty", "Lem", "Ilon", "Gary", "Leo", "Jeff"};
                String[] surnames = {"Taison", "Lutsenko", "Sappy", "Komin", "Maks", "Lizniava", "Gordon", "Mask", "Potter", "Messi", "Bezos+"};
                int n = 0, n2 = 0;
                for (int i = 0; i < amount; i++) {
                    n = (int) (Math.random() * 11);
                    n2 = (int) (Math.random() * 11);
                    newUserArr[i][0] = String.valueOf(i+1);
                    newUserArr[i][3] = String.valueOf((int) (Math.random() * 150));
                    newUserArr[i][1] = names[n];
                    newUserArr[i][2] = surnames[n2];
                    newUserArr[i][4] = "";
                }
                printSmth.allUssers(newUserArr);
                return newUserArr;
            } else if (manAut == 0) {
                //String[][] users = new String[amount][4];
                for (int i = 1; i <= amount; i++) {
                    newUserArr[i-1][4] = "";
                    System.out.print("\nEnter surname of " + i + " user: ");
                    int is = 1;
                    do{
                        newUserArr[i - 1][2] = in.nextLine();
                        boolean bool = newUserArr[i - 1][2].isBlank();
                        is = 1;
                        if(bool || newUserArr[i - 1][2].contains("'") || newUserArr[i - 1][2].contains("$") || newUserArr[i - 1][2].contains("&") || newUserArr[i - 1][2].contains("%") || newUserArr[i - 1][2].contains("/") || newUserArr[i - 1][2].contains("\\")){
                            System.out.print("Enter right surname:");
                            is = 0;

                        }
                    }while(is == 0);

                    System.out.print("Enter name of " + i + " user: ");
                    do{
                        newUserArr[i - 1][1] = in.nextLine();
                        boolean bool = newUserArr[i - 1][1].isBlank();
                        is = 1;
                        if(bool || newUserArr[i - 1][1].contains("'") || newUserArr[i - 1][1].contains("$") || newUserArr[i - 1][1].contains("&") || newUserArr[i - 1][1].contains("%") || newUserArr[i - 1][1].contains("/") || newUserArr[i - 1][1].contains("\\")){
                            System.out.print("Enter right name:");
                            is = 0;
                        }
                    }while(is == 0);

                    System.out.print("Enter money of " + i + " user: ");
                    int x = 0;
                    do {
                        Scanner p = new Scanner(System.in);
                        if (p.hasNextInt()) {
                            newUserArr[i - 1][3]  = String.valueOf(p.nextInt());
                            x ++;
                            if(Integer.parseInt(newUserArr[i - 1][3]) < 0) {
                                System.out.println("Enter not minus price!:");
                                x--;
                            }
                        }
                        else System.out.println("Enter right price!:");

                    }while(x == 0);
                    newUserArr[i - 1][0] = String.valueOf(i);

                }
                printSmth.allProd(newUserArr);

                return newUserArr;
            }
            else{
                in = new Scanner(System.in);
                System.out.print("Enter 0 (manually) or 1 (automatically), please don't do errors here: ");
                manAut = in.nextInt();
               // in.close(); // закоментировано потому что при повторном вызов цыкла вылетает ошибка на этом моменте
            }
        }while(manAut != 1 && manAut != 0);
        return newUserArr;
    }

    public String[][] newProducts(int amount, int manAut){
        String[][] newProdArr =  new String[amount][4];
        do {
            Scanner in = new Scanner(System.in);
            if (manAut == 1) {
                String[] prod = {"Lambo", "Iphone", "Samsung", "House", "BMW", "Jet", "New wife", "Water", "XBox", "Shoes", "Shorts"};
                int n = 0;
                for (int i = 0; i < amount; i++) {
                    n = (int) (Math.random() * 11);
                    newProdArr[i][0] = String.valueOf(i+1);
                    newProdArr[i][2] = String.valueOf((int) (Math.random() * 20));
                    newProdArr[i][1] = prod[n];
                    newProdArr[i][3] = "";
                }
                printSmth.allProd(newProdArr);
                return newProdArr;
            } else if (manAut == 0) {
                //String[][] users = new String[amount][4];
                for (int i = 1; i <= amount; i++) {
                    System.out.print("\nEnter name of " + i + " product: ");
                    int is = 0;
                    do{
                        newProdArr[i - 1][1] = in.nextLine();
                        boolean bool = newProdArr[i - 1][1].isBlank();
                        is = 1;
                        if(bool || newProdArr[i - 1][1].contains("'") || newProdArr[i - 1][1].contains("$") || newProdArr[i - 1][1].contains("&") || newProdArr[i - 1][1].contains("%") || newProdArr[i - 1][1].contains("/") || newProdArr[i - 1][1].contains("\\")){
                            System.out.print("Enter right name:");
                            is = 0;
                        }
                    }while(is == 0);

                    System.out.print("Enter price of " + i + " product: ");
                    do {
                        Scanner p = new Scanner(System.in);
                        if (p.hasNextInt()) {
                            newProdArr[i - 1][2] = String.valueOf(p.nextInt());
                            manAut ++;
                        } else {
                            System.out.println("Enter right price!:");
                        }
                    }while(manAut == 0);
                    newProdArr[i - 1][0] = String.valueOf(i);
                }
                printSmth.allProd(newProdArr);

                return newProdArr;
            }
            else{
                in = new Scanner(System.in);
                System.out.print("Enter 0 (manually) or 1 (automatically), please don't do errors here: ");
                manAut = in.nextInt();
                //in.close();  закоментировано потому что при повторном вызов цыкла вылетает ошибка на этом моменте
            }
        }while(manAut != 1 && manAut != 0);
        return newProdArr;
    }
}
