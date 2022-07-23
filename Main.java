package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SmthToDo func = new SmthToDo();
        CreateNew cr = new CreateNew();
        System.out.print("Enter a number of users you want to create: ");
        int amountUser = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                amountUser = scanner.nextInt();
            } else {
                System.out.println("Enter right amount!:");
            }
            //scanner.close();
        }while(amountUser == 0);
        System.out.print("Enter 0 if you want to fill it manually or enter 1 if you want to fill it automatically: ");
        byte manAut = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextByte()) {
                manAut = scanner.nextByte();
            } else {
                System.out.println("Enter right choice!:");
            }
        }while(manAut == -1);
        String[][] dataUser = cr.newUser( amountUser, manAut);
        byte toDo = 0;
        //System.out.print("\nEnter a number of products you want to create: ");
        //int prodAmount = scanner.nextInt();
        //System.out.print("Enter 0 if you want to create products manually or enter 1 if you want to fill it automatically: ");
        //manAut = scanner.nextByte();
        //String[][] dataProd = cr.newProducts(prodAmount, manAut);
        String[][] dataProd = new String[11][4];
        cr.newProductsAuto(dataProd);

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose:\n\t1. Add user\n\t2. Add product\n\t3. Delete user\n\t4. Delete product\n\t5. Buy\n\t6. Show all users and products\n\t7. Exit");
            if(scanner.hasNextByte()){
                toDo = scanner.nextByte();
                if(toDo<1 || toDo>7){
                    System.out.println("Enter the right number! ");
                    continue;
                }
            }
            else {
                System.out.println("Enter the right number! ");
                continue;
            }
            if (toDo == 1) {
                dataUser = func.smthToDo(dataUser, toDo);
            }

            else if (toDo == 2){
                dataProd = func.smthToDo(dataProd, toDo);
            }

            else if(toDo == 3){
                int id = 0;
                int i = 0;

                System.out.print("Enter the ID of the user you want do delete: ");
                do {
                    Scanner y = new Scanner(System.in);
                    if(y.hasNextInt()){
                        id = y.nextInt();
                        i = func.searchID(dataUser, id);
                    }
                    if(i == 0) System.out.println("Enter the right ID: ");
                    else if(i== -1){
                        System.out.println("There are not any user, add some");
                        break;
                    }
                }while(i == 0);
                if(i>0) {
                    func.clearIdProd(dataProd, dataUser, id);
                    dataUser = func.delUser(dataUser, id);
                }
            }

            else if (toDo ==4){
                int id = 0;
                int i = 0;
                System.out.print("Enter the ID of the product you want do delete: ");
                do {
                    Scanner y = new Scanner(System.in);
                    if(y.hasNextInt()){
                        id = y.nextInt();
                        i = func.searchID(dataProd, id);
                    }
                    if(i==0) System.out.println("Enter the right ID: ");
                    else if(i== -1){
                        System.out.println("There are not any products, add some");
                        break;
                    }
                }while(i==0);
                if(i>0){
                    func.clearIdUser(dataUser, dataProd, id);
                    dataProd = func.delProd(dataProd, id);
                }
            }

            else if(toDo == 5) {
                int id = 0;
                int i = 0;
                int is = 1;
                System.out.print("Enter the ID of the user you want do buy something: ");
                do {
                    Scanner y = new Scanner(System.in);
                    if (y.hasNextInt()) {
                        id = y.nextInt();
                        i = func.searchID(dataUser, id);

                    }
                    if (i == 0) System.out.println("Enter the right ID: ");
                    else if (i == -1) {
                        System.out.println("There are not any user, add some");
                        is = 0;
                        break;
                    }
                } while (i == 0);
                if (is != 0) {
                    if (i == -1) break;
                    int id2 = 0;
                    i = 0;
                    System.out.print("Enter the ID of the product you want do buy: ");
                    do {
                        Scanner y = new Scanner(System.in);
                        if (y.hasNextInt()) {
                            id2 = y.nextInt();
                            i = func.searchID(dataProd, id2);
                        }
                        if (i == 0) System.out.println("Enter the right ID: ");
                        else if (i == -1) {
                            System.out.println("There are not any products, add some");
                            break;
                        }
                    } while (i == 0);
                    if (i > 0) SmthToDo.buyProd(dataUser, dataProd, id, id2);
                }
            }

            else if(toDo == 6){
                SmthToDo.allUssers(dataUser);
                System.out.println("\n");
                SmthToDo.allProd(dataProd);

            }
        }while(toDo != 7);

    }
}