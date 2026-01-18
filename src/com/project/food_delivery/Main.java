package com.project.food_delivery;

import com.project.food_delivery.dao.CartDao;
import com.project.food_delivery.dao.CartItemDao;
import com.project.food_delivery.dao.DeliveryAgentDao;
import com.project.food_delivery.dao.DeliveryDao;
import com.project.food_delivery.dao.MenuItemDao;
import com.project.food_delivery.dao.OrderDao;
import com.project.food_delivery.dao.PaymentDao;
import com.project.food_delivery.dao.RestaurantDao;
import com.project.food_delivery.dao.UserDao;
import com.project.food_delivery.dao.impl.CartDaoImpl;
import com.project.food_delivery.dao.impl.CartItemDaoImpl;
import com.project.food_delivery.dao.impl.DeliveryAgentDaoImpl;
import com.project.food_delivery.dao.impl.DeliveryDaoImpl;
import com.project.food_delivery.dao.impl.MenuItemDaoImpl;
import com.project.food_delivery.dao.impl.OrderDaoImpl;
import com.project.food_delivery.dao.impl.PaymentDaoImpl;
import com.project.food_delivery.dao.impl.RestaurantDaoImpl;
import com.project.food_delivery.dao.impl.UserDaoImpl;
import com.project.food_delivery.models.Cart;
import com.project.food_delivery.models.CartItem;
import com.project.food_delivery.models.Delivery;
import com.project.food_delivery.models.DeliveryAgent;
import com.project.food_delivery.models.MenuItem;
import com.project.food_delivery.models.Order;
import com.project.food_delivery.models.Payment;
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
        	System.out.println("3. MenuItem Management");
        	System.out.println("4. Cart Management");
        	System.out.println("5. Cart Item Management");
        	System.out.println("6. Order Management");
        	System.out.println("7. Delivery_Agent Management");
        	System.out.println("8. Delivery Management");
        	System.out.println("9. Payment Management");
        	System.out.println("10.Exit"); 
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
        	    menuItemMenu(sc);
        	    break;
        	case 4:
        		cartMenu(sc); 
        		break;
        	case 5: 
        		cartItemMenu(sc); 
        	break;
        	case 6: 
        		orderMenu(sc); 
        	break;
        	case 7: 
        		deliveryAgentMenu(sc);
        	break;
        	case 8: 
        		deliveryMenu(sc);
        	break;
        	case 9: 
        		paymentMenu(sc); 
        	break;
        	case 10: 
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
        
     // === RESTAURANT MENU_ITEM === 
        private static void menuItemMenu(Scanner sc) {
            MenuItemDao menuItemDao = new MenuItemDaoImpl();

            while (true) {
            System.out.println("\n--- Menu Item Management ---");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Get Menu Item by ID");
            System.out.println("3. Get Menu Items by Restaurant");
            System.out.println("4. Get All Menu Items");
            System.out.println("5. Update Menu Item");
            System.out.println("6. Delete Menu Item");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble(); sc.nextLine();
                    MenuItem newItem = new MenuItem(0, rid, name, price, true);
                    boolean added = menuItemDao.addMenuItem(newItem);
                    System.out.println(added ? "✅ Item added!" : "⚠️ Failed to add.");
                    break;

                case 2:
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    MenuItem item = menuItemDao.getMenuItemById(id);
                    System.out.println(item != null ? item : "⚠️ Item not found.");
                    break;

                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int restId = sc.nextInt();
                    sc.nextLine();
                    List<MenuItem> itemsByRestaurant = menuItemDao.getMenuItemsByRestaurant(restId);
                    if (itemsByRestaurant.isEmpty()) {
                        System.out.println("⚠️ No items found for this restaurant.");
                    } else {
                        itemsByRestaurant.forEach(System.out::println);
                    }
                    break;

                case 4:
                    List<MenuItem> allItems = menuItemDao.getAllMenuItems();
                    if (allItems.isEmpty()) {
                        System.out.println("⚠️ No menu items available.");
                    } else {
                        allItems.forEach(System.out::println);
                    }
                    break;

                case 5:
                    System.out.print("Enter Item ID to update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Restaurant ID: ");
                    int newRestId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Item Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble(); sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean available = sc.nextBoolean(); sc.nextLine();

                    MenuItem updatedItem = new MenuItem(updateId, newRestId, newName, newPrice, available);
                    boolean updated = menuItemDao.updateMenuItem(updatedItem);
                    System.out.println(updated ? "✅ Item updated!" : "⚠️ Failed to update.");
                    break;

                case 6:
                    System.out.print("Enter Item ID to delete: ");
                    int deleteId = sc.nextInt(); sc.nextLine();
                    boolean deleted = menuItemDao.deleteMenuItemById(deleteId);
                    System.out.println(deleted ? "🗑️ Item deleted!" : "⚠️ Failed to delete.");
                    break;
                case 7:
                    System.out.println("👋 Exiting Menu_Item Management...");
                    return;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
          }
        }
        
     // === CART MANAGEMENT === 
        private static void cartMenu(Scanner sc) {
            CartDao cartDao = new CartDaoImpl();

            while (true) {
            System.out.println("\n--- Cart Management ---");
            System.out.println("1. Create Cart");
            System.out.println("2. Get Cart by User ID");
            System.out.println("3. Get All Carts");
            System.out.println("4. Delete Cart");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    Cart newCart = new Cart(0, uid);
                    boolean created = cartDao.createCart(newCart);
                    System.out.println(created ? "✅ Cart created!" : "⚠️ Failed to create.");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt(); sc.nextLine();
                    Cart cart = cartDao.getCartByUserId(userId);
                    System.out.println(cart != null ? cart : "⚠️ Cart not found.");
                    break;

                case 3:
                    List<Cart> carts = cartDao.getAllCarts();
                    if (carts.isEmpty()) System.out.println("⚠️ No carts available.");
                    else carts.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter Cart ID to delete: ");
                    int cid = sc.nextInt(); sc.nextLine();
                    boolean deleted = cartDao.deleteCart(cid);
                    System.out.println(deleted ? "🗑️ Cart deleted!" : "⚠️ Failed to delete.");
                    break;
                case 5:
                	 System.out.println("👋 Exiting Cart Management...");
                     return;
                	
                default:
                    System.out.println("❌ Invalid choice.");
            }
            }
        }

     // === CART_ITEM MANAGEMENT === 
        
        private static void cartItemMenu(Scanner sc) {
            CartItemDao cartItemDao = new CartItemDaoImpl();

            while (true) {
            System.out.println("\n--- Cart Item Management ---");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Get Cart Item by ID");
            System.out.println("3. Get Items by Cart ID");
            System.out.println("4. Update Cart Item");
            System.out.println("5. Delete Cart Item");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Cart ID: ");
                    int cartId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    int itemId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt(); sc.nextLine();

                    CartItem newItem = new CartItem(0, cartId, itemId, qty);
                    boolean added = cartItemDao.addCartItem(newItem);
                    System.out.println(added ? "✅ Item added to cart!" : "⚠️ Failed to add.");
                    break;

                case 2:
                    System.out.print("Enter Cart Item ID: ");
                    int ciid = sc.nextInt(); sc.nextLine();
                    CartItem item = cartItemDao.getCartItemById(ciid);
                    System.out.println(item != null ? item : "⚠️ Cart item not found.");
                    break;

                case 3:
                    System.out.print("Enter Cart ID: ");
                    int cid = sc.nextInt(); sc.nextLine();
                    List<CartItem> items = cartItemDao.getItemsByCartId(cid);
                    if (items.isEmpty()) System.out.println("⚠️ No items in this cart.");
                    else items.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter Cart Item ID to update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Cart ID: ");
                    int newCartId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Item ID: ");
                    int newItemId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt(); sc.nextLine();

                    CartItem updatedItem = new CartItem(updateId, newCartId, newItemId, newQty);
                    boolean updated = cartItemDao.updateCartItem(updatedItem);
                    System.out.println(updated ? "✅ Cart item updated!" : "⚠️ Failed to update.");
                    break;

                case 5:
                    System.out.print("Enter Cart Item ID to delete: ");
                    int delId = sc.nextInt(); sc.nextLine();
                    boolean deleted = cartItemDao.deleteCartItem(delId);
                    System.out.println(deleted ? "🗑️ Cart item deleted!" : "⚠️ Failed to delete.");
                    break;
                case 6:
                	System.out.println("👋 Exiting Cart_Item Management...");
                	return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
            }
        }
        
        //====ORDER MENU====
        
        private static void orderMenu(Scanner sc) {
            OrderDao orderDao = new OrderDaoImpl();

            while (true) { 
            System.out.println("\n--- Order Management ---");
            System.out.println("1. Place Order");
            System.out.println("2. Get Order by ID");
            System.out.println("3. Get Orders by User");
            System.out.println("4. Get All Orders");
            System.out.println("5. Update Order Status");
            System.out.println("6. Delete Order");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Total Amount: ");
                    double amount = sc.nextDouble(); sc.nextLine();
                    System.out.print("Enter Order Status (PENDING/ACCEPTED/PREPARING/ON_ROUTE/DELIVERED/CANCELLED): ");
                    String status = sc.nextLine();

                    Order newOrder = new Order(0, uid, rid, amount, status, null);
                    boolean placed = orderDao.placeOrder(newOrder);
                    System.out.println(placed ? "✅ Order placed!" : "⚠️ Failed to place order.");
                    break;

                case 2:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt(); sc.nextLine();
                    Order order = orderDao.getOrderById(oid);
                    System.out.println(order != null ? order : "⚠️ Order not found.");
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt(); sc.nextLine();
                    List<Order> userOrders = orderDao.getOrdersByUser(userId);
                    if (userOrders.isEmpty()) System.out.println("⚠️ No orders for this user.");
                    else userOrders.forEach(System.out::println);
                    break;

                case 4:
                    List<Order> allOrders = orderDao.getAllOrders();
                    if (allOrders.isEmpty()) System.out.println("⚠️ No orders available.");
                    else allOrders.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Order ID to update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Status: ");
                    String newStatus = sc.nextLine();
                    boolean updated = orderDao.updateOrderStatus(updateId, newStatus);
                    System.out.println(updated ? "✅ Order status updated!" : "⚠️ Failed to update.");
                    break;

                case 6:
                    System.out.print("Enter Order ID to delete: ");
                    int delId = sc.nextInt(); sc.nextLine();
                    boolean deleted = orderDao.deleteOrder(delId);
                    System.out.println(deleted ? "🗑️ Order deleted!" : "⚠️ Failed to delete.");
                    break;
                case 7:
                	System.out.println("👋 Exiting Order Management...");
                	return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
            }
        }
        
        
        
        private static void deliveryMenu(Scanner sc) {
            DeliveryDao deliveryDao = new DeliveryDaoImpl();

            while(true) {
            System.out.println("\n--- Delivery Management ---");
            System.out.println("1. Assign Delivery");
            System.out.println("2. Get Delivery by ID");
            System.out.println("3. Get Delivery by Order ID");
            System.out.println("4. Get All Deliveries");
            System.out.println("5. Update Delivery Status");
            System.out.println("6. Mark as Delivered");
            System.out.println("7. Delete Delivery");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Agent ID: ");
                    int aid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Delivery Status (Assigned/PickedUp/OnTheWay/Delivered): ");
                    String status = sc.nextLine();

                    Delivery newDelivery = new Delivery(0, oid, aid, status, null);
                    boolean assigned = deliveryDao.assignDelivery(newDelivery);
                    System.out.println(assigned ? "✅ Delivery assigned!" : "⚠️ Failed to assign.");
                    break;

                case 2:
                    System.out.print("Enter Delivery ID: ");
                    int did = sc.nextInt(); sc.nextLine();
                    Delivery delivery = deliveryDao.getDeliveryById(did);
                    System.out.println(delivery != null ? delivery : "⚠️ Delivery not found.");
                    break;

                case 3:
                    System.out.print("Enter Order ID: ");
                    int orderId = sc.nextInt(); sc.nextLine();
                    Delivery orderDelivery = deliveryDao.getDeliveryByOrderId(orderId);
                    System.out.println(orderDelivery != null ? orderDelivery : "⚠️ No delivery for this order.");
                    break;

                case 4:
                    List<Delivery> deliveries = deliveryDao.getAllDeliveries();
                    if (deliveries.isEmpty()) System.out.println("⚠️ No deliveries available.");
                    else deliveries.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Delivery ID to update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Status: ");
                    String newStatus = sc.nextLine();
                    boolean updated = deliveryDao.updateDeliveryStatus(updateId, newStatus);
                    System.out.println(updated ? "✅ Delivery status updated!" : "⚠️ Failed to update.");
                    break;

                case 6:
                    System.out.print("Enter Delivery ID to mark delivered: ");
                    int markId = sc.nextInt(); sc.nextLine();
                    boolean marked = deliveryDao.markDelivered(markId);
                    System.out.println(marked ? "✅ Delivery marked as completed!" : "⚠️ Failed to mark.");
                    break;

                case 7:
                    System.out.print("Enter Delivery ID to delete: ");
                    int delId = sc.nextInt(); sc.nextLine();
                    boolean deleted = deliveryDao.deleteDelivery(delId);
                    System.out.println(deleted ? "🗑️ Delivery deleted!" : "⚠️ Failed to delete.");
                    break;
                case 8:
                	System.out.println("👋 Exiting Delivery Management...");
                	return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
            }
        }
        
        //######DeliveryAgent Management#####
        
        private static void deliveryAgentMenu(Scanner sc) {
            DeliveryAgentDao agentDao = new DeliveryAgentDaoImpl();

            while(true) {
            System.out.println("\n--- Delivery Agent Management ---");
            System.out.println("1. Add Agent");
            System.out.println("2. Get Agent by ID");
            System.out.println("3. Get All Agents");
            System.out.println("4. Get Available Agents");
            System.out.println("5. Update Agent");
            System.out.println("6. Update Availability");
            System.out.println("7. Delete Agent");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Agent Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean available = sc.nextBoolean(); sc.nextLine();

                    DeliveryAgent newAgent = new DeliveryAgent(0, name, phone, available);
                    boolean added = agentDao.addAgent(newAgent);
                    System.out.println(added ? "✅ Agent added!" : "⚠️ Failed to add.");
                    break;

                case 2:
                    System.out.print("Enter Agent ID: ");
                    int aid = sc.nextInt(); sc.nextLine();
                    DeliveryAgent agent = agentDao.getAgentById(aid);
                    System.out.println(agent != null ? agent : "⚠️ Agent not found.");
                    break;

                case 3:
                    List<DeliveryAgent> agents = agentDao.getAllAgents();
                    if (agents.isEmpty()) System.out.println("⚠️ No agents available.");
                    else agents.forEach(System.out::println);
                    break;

                case 4:
                    List<DeliveryAgent> availableAgents = agentDao.getAvailableAgents();
                    if (availableAgents.isEmpty()) System.out.println("⚠️ No agents available right now.");
                    else availableAgents.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Agent ID to update: ");
                    int updateId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean newAvailable = sc.nextBoolean(); sc.nextLine();

                    DeliveryAgent updatedAgent = new DeliveryAgent(updateId, newName, newPhone, newAvailable);
                    boolean updated = agentDao.updateAgent(updatedAgent);
                    System.out.println(updated ? "✅ Agent updated!" : "⚠️ Failed to update.");
                    break;

                case 6:
                    System.out.print("Enter Agent ID to update availability: ");
                    int availId = sc.nextInt(); sc.nextLine();
                    System.out.print("Is Available (true/false): ");
                    boolean availStatus = sc.nextBoolean(); sc.nextLine();
                    boolean availUpdated = agentDao.updateAvailability(availId, availStatus);
                    System.out.println(availUpdated ? "✅ Availability updated!" : "⚠️ Failed to update.");
                    break;

                case 7:
                    System.out.print("Enter Agent ID to delete: ");
                    int delId = sc.nextInt(); sc.nextLine();
                    boolean deleted = agentDao.deleteAgent(delId);
                    System.out.println(deleted ? "🗑️ Agent deleted!" : "⚠️ Failed to delete.");
                    break;
                    
                case 8:
                	System.out.println("👋 Exiting Delivery_Agent Management...");
                	return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
            }
        }
        
        
        private static void paymentMenu(Scanner sc) {
            PaymentDao paymentDao = new PaymentDaoImpl();

            while (true) {
                System.out.println("\n=== Food Delivery App - Payment Management ===");
                System.out.println("1. Add Payment");
                System.out.println("2. Get Payment by ID");
                System.out.println("3. Get Payment by Order ID");
                System.out.println("4. Get All Payments");
                System.out.println("5. Update Payment Status");
                System.out.println("6. Delete Payment");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Order ID: ");
                        int orderId = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble(); sc.nextLine();
                        System.out.print("Enter Payment Method (UPI/Card/Cash/NetBanking): ");
                        String method = sc.nextLine();
                        System.out.print("Enter Payment Status (Success/Pending/Failed): ");
                        String status = sc.nextLine();

                        Payment newPayment = new Payment(0, orderId, amount, method, status, null);
                        boolean added = paymentDao.addPayment(newPayment);
                        System.out.println(added ? "✅ Payment added!" : "⚠️ Failed to add.");
                        break;

                    case 2:
                        System.out.print("Enter Payment ID: ");
                        int pid = sc.nextInt(); sc.nextLine();
                        Payment p = paymentDao.getPaymentById(pid);
                        System.out.println(p != null ? p : "⚠️ Payment not found.");
                        break;

                    case 3:
                        System.out.print("Enter Order ID: ");
                        int oid = sc.nextInt(); sc.nextLine();
                        Payment po = paymentDao.getPaymentByOrderId(oid);
                        System.out.println(po != null ? po : "⚠️ No payment found for this order.");
                        break;

                    case 4:
                        List<Payment> payments = paymentDao.getAllPayments();
                        if (payments.isEmpty()) {
                            System.out.println("⚠️ No payments found.");
                        } else {
                            payments.forEach(System.out::println);
                        }
                        break;

                    case 5:
                        System.out.print("Enter Payment ID to update: ");
                        int upid = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter New Status: ");
                        String newStatus = sc.nextLine();
                        boolean updated = paymentDao.updatePaymentStatus(upid, newStatus);
                        System.out.println(updated ? "✅ Payment status updated!" : "⚠️ Failed to update.");
                        break;

                    case 6:
                        System.out.print("Enter Payment ID to delete: ");
                        int delId = sc.nextInt(); sc.nextLine();
                        boolean deleted = paymentDao.deletePayment(delId);
                        System.out.println(deleted ? "🗑️ Payment deleted!" : "⚠️ Failed to delete.");
                        break;

                    case 7:
                        System.out.println("👋 Exiting Payment Management...");
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
}
