package ua.kiev.prog;

import javax.persistence.*;
import java.util.List;
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
                    addNewDish();
                    break;
                case 2:
                    selectDishesFromRange();
                    break;
                case 3:
                    justWithDiscount();
                    break;
                case 4:
                    selectOneKg();
                    break;
            }
        }
    }

    public void addNewDish(){
        System.out.println();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter weight: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Is discount (y/n): ");
        boolean isDiscount = false;
        String answer = scanner.nextLine();
        if(answer.equals("y"))
            isDiscount = true;

        em.getTransaction().begin();
        try{
            Dish dish = new Dish(name, price, weight, isDiscount);
            em.persist(dish);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    public void selectDishesFromRange(){
        System.out.println();
        System.out.print("Enter min price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter max price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());
        List<Dish> result = null;

        Query query = em.createQuery("SELECT dish FROM Dish dish WHERE dish.price BETWEEN :minPrice AND :maxPrice", Dish.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        result = (List<Dish>) query.getResultList();
        for (Dish dish : result) {
            System.out.println(dish);
        }
    }

    public void justWithDiscount(){
        System.out.println();
        List<Dish> result = null;

        Query query = em.createQuery("SELECT dish FROM Dish dish WHERE dish.isDiscount = 1", Dish.class);
        result = (List<Dish>) query.getResultList();
        for (Dish dish : result) {
            System.out.println(dish);
        }
    }

    public void selectOneKg(){
        System.out.println();
        List<Dish> result = null;

        Query query = em.createQuery("SELECT dish FROM Dish dish WHERE dish.weight < 1000", Dish.class);
        int sum = 0;
        for (Dish dish : result) {
            if(sum + dish.getWeight() <= 1000) {
                sum += dish.getWeight();
                System.out.println(dish);
            }
        }
    }
}
