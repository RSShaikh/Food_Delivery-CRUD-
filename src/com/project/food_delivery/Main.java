package com.project.food_delivery;

import com.project.food_delivery.dao.RestaurantDao;
import com.project.food_delivery.dao.UserDao;
import com.project.food_delivery.dao.impl.RestaurantDaoImpl;
import com.project.food_delivery.dao.impl.UserDaoImpl;
import com.project.food_delivery.models.Restaurant;
import com.project.food_delivery.models.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
        	System.out.println("\n=== Food Delivery App ==="); 
        	System.out.println("1. User Management"); 
        	System.out.println("2. Restaurant Management"); 
        	System.out.println("3. Exit"); 
        	System.out.print("Enter choice: "); 
        	int choice = sc.nextInt(); 
        	sc.nextLine();
        	switch (choice) {
        	case 1: 
        		userMenu(sc);
        	    break; 
        	case 2: 
        		restaurantMenu(sc); 
        	    break; 
        	case 3: 
        		System.out.println("👋 Exiting application..."); 
        		sc.close(); 
        		return; 
        		default: System.out.println("Invalid choice! Try again.");
        		}
        	}
        }
    
 // === USER MENU === 
    private static void userMenu(Scanner sc) {
        UserDao userDao = new UserDaoImpl();

        while (true) {
            System.out.println("\n=== Food Delivery App - User Management ===");
            System.out.println("1. Add User");
            System.out.println("2. Get User by ID");
            System.out.println("3. Get User by Email");
            System.out.println("4. Get All Users");
            System.out.println("5. Update User");
            System.out.println("6. Delete User");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    User newUser = new User(0, name, email, phone, address, null);
                    boolean added = userDao.addUser(newUser);
                    System.out.println(added ? "✅ User added successfully!" : "⚠️ Failed to add user.");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    User userById = userDao.getUserById(id);
                    System.out.println(userById != null ? userById : "⚠️ User not found.");
                    break;

                case 3:
                    System.out.print("Enter Email: ");
                    String searchEmail = sc.nextLine();
                    User userByEmail = userDao.getUserByEmail(searchEmail);
                    System.out.println(userByEmail != null ? userByEmail : "⚠️ User not found.");
                    break;

                case 4:
                    List<User> users = userDao.getAllUser();
                    if (users.isEmpty()) {
                        System.out.println("⚠️ No users found.");
                    } else {
                        users.forEach(System.out::println);
                    }
                    break;

                case 5:
                    System.out.print("Enter User ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = sc.nextLine();

                    User updatedUser = new User(uid, newName, newEmail, newPhone, newAddress, null);
                    boolean updated = userDao.updateUser(updatedUser);
                    System.out.println(updated ? "✅ User updated successfully!" : "⚠️ Failed to update user.");
                    break;

                case 6:
                    System.out.print("Enter User ID to delete: ");
                    int did = sc.nextInt();
                    boolean deleted = userDao.deleteUserById(did);
                    System.out.println(deleted ? "🗑️ User deleted successfully!" : "⚠️ Failed to delete user.");
                    break;

                case 7:
                    System.out.println("👋 Exiting application...");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
        
     // === RESTAURANT MENU === 
        private static void restaurantMenu(Scanner sc) {
                RestaurantDao restaurantDao = new RestaurantDaoImpl();

                while (true) {
                    System.out.println("\n=== Food Delivery App - Restaurant Management ===");
                    System.out.println("1. Add Restaurant");
                    System.out.println("2. Get Restaurant by ID");
                    System.out.println("3. Get All Restaurants");
                    System.out.println("4. Update Restaurant");
                    System.out.println("5. Delete Restaurant");
                    System.out.println("6. Exit");
                    System.out.print("Enter choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Address: ");
                            String address = sc.nextLine();
                            System.out.print("Enter Rating (0-5): ");
                            double rating = sc.nextDouble();
                            sc.nextLine();
                            Restaurant newR = new Restaurant(0, name, address, rating, true);
                            boolean added = restaurantDao.addRestaurant(newR);
                            System.out.println(added ? "✅ Restaurant added!" : "⚠️ Failed to add.");
                            break;

                        case 2:
                            System.out.print("Enter Restaurant ID: ");
                            int id = sc.nextInt();
                            Restaurant r = restaurantDao.getRestaurantById(id);
                            System.out.println(r != null ? r : "⚠️ Restaurant not found.");
                            break;

                        case 3:
                            List<Restaurant> restaurants = restaurantDao.getAllRestaurants();
                            if (restaurants.isEmpty()) {
                                System.out.println("⚠️ No restaurants found.");
                            } else {
                                restaurants.forEach(System.out::println);
                            }
                            break;

                        case 4:
                            System.out.print("Enter Restaurant ID: ");
                            int rid = sc.nextInt(); sc.nextLine();
                            System.out.print("New Name: ");
                            String newName = sc.nextLine();
                            System.out.print("New Address: ");
                            String newAddress = sc.nextLine();
                            System.out.print("New Rating: ");
                            double newRating = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Is Active (true/false): ");
                            boolean active = sc.nextBoolean();
                            sc.nextLine();

                            Restaurant updatedR = new Restaurant(rid, newName, newAddress, newRating, active);
                            boolean updated = restaurantDao.updateRestaurant(updatedR);
                            System.out.println(updated ? "✅ Restaurant updated!" : "⚠️ Failed to update.");
                            break;

                        case 5:
                            System.out.print("Enter Restaurant ID to delete: ");
                            int did = sc.nextInt();
                            boolean deleted = restaurantDao.deleteRestaurantById(did);
                            System.out.println(deleted ? "🗑️ Restaurant deleted!" : "⚠️ Failed to delete.");
                            break;

                        case 6:
                            System.out.println("👋 Exiting Restaurant Management...");
                            return;

                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                }
                
    }
}
