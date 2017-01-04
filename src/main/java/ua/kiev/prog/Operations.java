package ua.kiev.prog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

/**
 * Created by User on 04.01.2017.
 */
public class Operations {
    private EntityManagerFactory emf;
    private EntityManager em;
    private Scanner scanner;

    public Operations() {
        emf = Persistence.createEntityManagerFactory("Menu");
        em = emf.createEntityManager();
        scanner = new Scanner(System.in);

        while(true) {
            System.out.println();
            System.out.println("Choice an operation.");
            System.out.println("1. Add new dish");
            System.out.println("2. Select dishes from range of prices");
            System.out.println("3. Select dishes just with discount");
            System.out.println("4. Select set of dishes with weight to 1 kg");
            System.out.print("Your choice:");

            int check = Integer.parseInt(scanner.nextLine());
            switch (check){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }


}
