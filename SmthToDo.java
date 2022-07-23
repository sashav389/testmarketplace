package org.example;
import java.util.Scanner;

public class SmthToDo {
    public String[][] smthToDo (String[][] start, byte  number){
        if(number == 1) {
            String[][] mas = new String[start.length + 1][5];
            for(int i = 0;i< start.length;i++)
                for(int j= 0 ;j<5;j++)
                    mas[i][j] = start[i][j];
            Scanner in = new Scanner(System.in);
            System.out.print("Enter name of new user: ");
            int is = 1;
            do{
                mas[mas.length - 1][1] = in.nextLine();
                boolean bool = mas[mas.length - 1][1].isBlank();
                is = 1;
                if(bool || mas[mas.length - 1][1].contains("'") || mas[mas.length - 1][1].contains("$") || mas[mas.length - 1][1].contains("&") || mas[mas.length - 1][1].contains("%") || mas[mas.length - 1][1].contains("/") || mas[mas.length - 1][1].contains("\\")){
                    System.out.print("Enter right surname:");
                    is = 0;

                }
            }while(is == 0);
            if(start.length != 0) {
                mas[mas.length - 1][0] = String.valueOf(Integer.parseInt(start[start.length - 1][0]) + 1);
            }
            else  mas[mas.length - 1][0] = "1";
            System.out.print("Enter surname of new user: ");
            do{
                mas[mas.length - 1][2] = in.nextLine();
                boolean bool = mas[mas.length - 1][2].isBlank();
                is = 1;
                if(bool || mas[mas.length - 1][2].contains("'") || mas[mas.length - 1][2].contains("$") || mas[mas.length - 1][2].contains("&") || mas[mas.length - 1][2].contains("%") || mas[mas.length - 1][2].contains("/") || mas[mas.length - 1][2].contains("\\")){
                    System.out.print("Enter right surname:");
                    is = 0;

                }
            }while(is == 0);

            System.out.print("Enter money of new user: ");
            int x = 0;
            do {
                Scanner p = new Scanner(System.in);
                if (p.hasNextInt()) {
                    mas[mas.length - 1][3] = String.valueOf(p.nextInt());
                    x ++;
                    if(Integer.parseInt(mas[mas.length - 1][3]) < 0) {
                        System.out.println("Enter not minus price!:");
                        x--;
                    }
                } else {
                    System.out.print("Enter right amount!:");
                }
            }while(x == 0);
            mas[mas.length - 1][4] = "";
            allUssers(mas);
            //in.close();
            return mas;
        }
        else if (number == 2){
            String[][] mas = new String[start.length + 1][4];
            for(int i = 0;i< start.length;i++)
                for(int j= 0 ;j<4;j++)
                    mas[i][j] = start[i][j];
            Scanner in = new Scanner(System.in);
            System.out.print("Enter name of new product: ");
            int is = 0;
            do{
                mas[mas.length - 1][1] = in.nextLine();
                boolean bool = mas[mas.length - 1][1].isBlank();
                is = 1;
                if(bool || mas[mas.length - 1][1].contains("'") || mas[mas.length - 1][1].contains("$") || mas[mas.length - 1][1].contains("&") || mas[mas.length - 1][1].contains("%") || mas[mas.length - 1][1].contains("/") || mas[mas.length - 1][1].contains("\\")){
                    System.out.print("Enter right name:");
                    is = 0;
                }
            }while(is == 0);

            mas[mas.length - 1][0] = String.valueOf(Integer.parseInt(start[start.length - 1][0]) + 1);
            mas[mas.length - 1][3] = "";
            System.out.print("Enter price of new product: ");
            int x = 0;
            do {
                Scanner p = new Scanner(System.in);
                if (p.hasNextInt()) {
                    mas[mas.length - 1][2] = String.valueOf(p.nextInt());
                    x ++;
                    if(Integer.parseInt(mas[mas.length - 1][2]) < 0) {
                        System.out.print("Enter not minus price!:");
                        x--;
                    }
                } else {
                    System.out.print("Enter right price!:");
                }
            }while(x == 0);
            allProd(mas);
            //in.close();
            return mas;
        }
        String[][] r = new String[0][0];
        return r;
    }

    public String[][] delUser (String[][] data, int id){
            String[][] mas = new String[data.length - 1][5];
            int j = 0;
            for (int i = 0; i < data.length - 1; i++) {
                if (Integer.parseInt(data[j][0]) != id) {
                    mas[i][0] = data[j][0];
                    mas[i][1] = data[j][1];
                    mas[i][2] = data[j][2];
                    mas[i][3] = data[j][3];
                    mas[i][4] = data[j][4];
                } else {
                    j++;
                    mas[i][0] = data[j][0];
                    mas[i][1] = data[j][1];
                    mas[i][2] = data[j][2];
                    mas[i][3] = data[j][3];
                    mas[i][4] = data[j][4];
                }
                j++;
            }
            allUssers(mas);
            return mas;
    }
    public void clearIdProd(String[][] pr, String[][] us,  int id) {

        for (int i = 0; i < pr.length; i++) {
            String[] x = pr[i][3].split(" ");
            pr[i][3] = "";
            int b;
            for(b = 0; b<us.length; b++){
                if(Integer.parseInt(us[b][0]) == id) break;
            }
            String res = us[b][1];
            for (int j = 0; j < x.length; j++) {
                if (res.equals(x[j])){
                }
                else {
                    pr[i][3] += (x[j] + " ");
                }
            }
        }
    }


    public String[][] delProd (String[][] data, int id){
        String[][] mas = new String[data.length - 1][4];
        int j = 0;
        for(int i = 0; i < data.length - 1; i++) {
            if (Integer.parseInt(data[j][0]) != id) {
                mas[i][0] = data[j][0];
                mas[i][1] = data[j][1];
                mas[i][2] = data[j][2];
                mas[i][3] = data[j][3];
            }
            else {
                System.out.println(data[j][0]);
                j++;
                mas[i][0] = data[j][0];
                mas[i][1] = data[j][1];
                mas[i][2] = data[j][2];
                mas[i][3] = data[j][3];
            }
            j++;
        }
        allProd(mas);
        return mas;
    }

    public void clearIdUser(String[][] pr, String[][] us, int id) {

        for (int i = 0; i < pr.length; i++) {
            String[] x = pr[i][4].split(" ");
            pr[i][4] = "";
            int b;
            for(b = 0; b<us.length; b++){
                if(Integer.parseInt(us[b][0]) == id) break;
            }
            String res = us[b][1];
            for (int j = 0; j < x.length; j++) {
                if (res.equals(x[j])){
                }
                else {
                    pr[i][4] += (x[j] + " ");
                }
            }
        }
    }

    public int searchID(String[][] mas, int id){
        if(mas.length != 0) {
            int res = 0;
            for (int i = 0; i < mas.length; i++) {
                if (Integer.parseInt(mas[i][0]) == id) {
                    res = id;
                    return res;
                }
            }
            return res;
        }
        else {
            return -1;
        }
    }


    public static void allUssers(String[][] data){
        System.out.println("All users: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print("Id:" + data[i][0] + ", name: " + data[i][1] + ", surname: " + data[i][2] + ", has " + data[i][3] + " money ");
            if(data[i][4] != "") System.out.println(" and products: " + data[i][4] );
            else System.out.println(", has no products");
        }
    }

    public static void allProd(String[][] data){
        System.out.println("All products: ");
        for(int i = 0; i < data.length; i++){
            System.out.print("Id:" + data[i][0] + ", name: " + data[i][1] + ", price " + data[i][2] +" money. Owners: ");
            if(data[i][3] != "") System.out.println(data[i][3] );
            else System.out.println("nobody");
        }
    }


    public static void buyProd(String[][] user, String[][] prod, int id1, int id2){
        int i = 0, j = 0;
        for(i = 0; i<user.length; i++){
            if(Integer.parseInt(user[i][0]) == id1) {
                break;}
        }
        for(j = 0; j<prod.length; j++){
            if(Integer.parseInt(prod[j][0]) == id2) {
                break;
            }
            }
        int beta = Integer.parseInt(user[i][3]);
        int alpha = Integer.parseInt(prod[j][2]);
        if( beta < alpha){
            System.out.println("Not enough money :(");
            pause();
        }
        else{
            user[i][3] = String.valueOf(Integer.parseInt(user[i][3])- Integer.parseInt(prod[j][2]));
            user[i][4] += (prod[j][1] + " ");
            prod[j][3] += (user[i][1] + " ");
            System.out.println("Success");
        }
    }
    public static void pause() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
    }
}




