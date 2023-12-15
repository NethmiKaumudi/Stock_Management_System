import java.util.*;

class Stock {
    static Scanner input = new Scanner(System.in);
    static String[] user = {"Nethmi", "1234"};
    static String[][] suppliers = new String[0][2];
    static String[] categories = new String[0];
    // static String[][] suppliers = {{"S001", "Sunil"}, {"S002", "Nimal"}, {"S003", "Kamal"}, {"S004", "Nimali"}};
    //static String[] categories = {"Food","Fruit","Gift"};
    static String[][] items = new String[0][6];
    //  static String[][] items = {{"I001","Rice","200","2","Food","S001"},{"I002","Daal","2000","8","Food","S002"}};

    public static void main(String args[]) {
        login();

    }

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }

    public static String[][] grow(String[][] arr, int arrayLength) {
        String[][] temp = new String[arr.length + 1][arrayLength];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }


    public static int findIndex(String id, String[][] arr) {
        int index = 0;
        for (String[] ar : arr) {
            if (ar[0].equals(id)) {
                return index;
            }
            index++;
        }
        return -1;
    }


    public static boolean checkDuplicate(String id, String[][] arr) {
        for (String[] ar : arr) {
            if (ar[0].equals(id)) {
                return false;
            }
        }
        return true;
    }

    public static String[][] remove(int index, String[][] arr) {
        String[][] temp = new String[arr.length - 1][2];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                temp[j++] = arr[i];
            }
        }
        return temp;
    }

    public static String[] removeCategory(int index, String[] arr) {
        String[] temp = new String[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                temp[j++] = arr[i];
            }
        }
        return temp;
    }

    //////////////////////
    public static int findIndexOneDimensional(String category, String[] categories) {
        for (int i = 0; i < categories.length; i++) {
            if (category.equals(categories[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void growOneDimensional() {
        String[] newArray = new String[categories.length + 1];
        System.arraycopy(categories, 0, newArray, 0, categories.length);
        categories = newArray;
    }

    //Logout From the system
    public static void logOut() {
        clearConsole();
        login();
    }

    //exit from the system
    public static void existSystem() {
        clearConsole();
        System.exit(0);
    }

    //Login page
    public static void login() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("|                    Login Page                             |");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println();
        do {
            System.out.print("user name : ");
            String userName = input.next();
            if (user[0].equals(userName)) {
                do {
                    System.out.print("password : ");
                    String password = input.next();
                    if (user[1].equals(password)) {
                        dashBoard();
                        break;


                    } else {
                        System.out.println("password is incorrect.please try again! ");
                    }
                } while (true);

            } else {
                System.out.println("user name is invalid.please try again! ");

            }
        } while (true);
    }

    //Update PassWord
    public static void credentialManage() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                     CREDENTIAL MANAGE                    |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();

        do {
            System.out.print("Please enter the user name to verify it's you : ");
            String userName = input.next();
            if (user[0].equals(userName)) {
                System.out.println(" Hey " + userName + "!!!!!!!");
                do {
                    System.out.print("Enter your current password : ");
                    String password = input.next();
                    if (user[1].equals(password)) {
                        System.out.print("enter your new password : ");
                        String newpw = input.next();
                        user[1] = newpw;
                        System.out.println();
                        System.out.print("password changed successfully! Do you want to go home page (Y/N) : ");
                        char op = input.next().charAt(0);
                        return;
                        //}

                    } else {
                        System.out.println("incorrect password. try again! ");
                        System.out.println();
                    }
                } while (true);
            } else {
                System.out.println("invalid user name. try again! ");
                System.out.println();
            }
        } while (true);

    }

    //DashBoard
    public static void dashBoard() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|         WELCOME TO IJSE STOCK MANAGEMENT SYSTEM          |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        System.out.println("[1] Change the Credentials\t\t[2] Supplier Manage\n[3] Stock Manage\t\t\t[4] Log Out\n[5] Exist the system ");
        System.out.println();
        do {
            System.out.print("Enter an option to continue >  ");
            char op = input.next().charAt(0);
            switch (op) {
                case '1':
                    credentialManage();
                    break;
                case '2':
                    supplierManage();
                    break;
                case '3':
                    stockManage();
                    break;
                case '4':
                    logOut();
                    break;
                case '5':
                    existSystem();
                    break;
            }
        } while (true);
    }

    public static void homePage() {
        clearConsole();
    }

    //Manage Suppliers
    public static void supplierManage() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                     SUPPLIER MANAGE                      |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        System.out.println("[1] Add Supplier\t\t[2] Update supplier\n[3] Delete Supplier\t\t[4] View Supplier\n[5] Search Supplier\t\t[6] Home Page");
        System.out.println();
        do {
            System.out.print("Enter an option to countinue > ");
            char op = input.next().charAt(0);
            switch (op) {
                case '1':
                    addSupplier();
                    break;
                case '2':
                    updateSupplier();
                    break;
                case '3':
                    deleteSupplier();
                    break;
                case '4':
                    viewSupplier();
                    break;
                case '5':
                    searchSupplier();
                    break;
                case '6':
                    dashBoard();
                    break;
            }
        } while (true);
    }

    public static void addSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                    ADD SUPPLIER                          |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        do {
            System.out.print("Supplier ID : ");
            String id = input.next();
            if (checkDuplicate(id, suppliers)) {
                suppliers = grow(suppliers, 2);
                System.out.print("Supplier Name : ");
                String name = input.next();
                suppliers[suppliers.length - 1][0] = id;
                suppliers[suppliers.length - 1][1] = name;
                //stock[stock.length-1][i]={"id","name"};
                System.out.print("Added successfully! Do you want to add another supplier(Y/N)");
                char op = input.next().charAt(0);
                if (op == 'Y' | op == 'y') {
                    continue;
                } else if (op == 'N' | op == 'n') {
                    supplierManage();
                    break;
                }
            } else {
                System.out.println("already exsists. try another supplier id! ");
            }
        } while (true);
    }

    public static void updateSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                     UPDATE SUPPLIER                      |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        do {
            System.out.print("Supplier ID ");
            String id = input.next();
            if (findIndex(id, suppliers) == -1) {
                System.out.print("Can't find supplier id. try again! ");
            } else {
                System.out.println("Supplier Name " + suppliers[findIndex(id, suppliers)][1]);
                System.out.print("Enter the new supplier name : ");
                suppliers[findIndex(id, suppliers)][1] = input.next();
                System.out.print("Updated successfully! Do you want to update another supplier?(Y/N) ");
                do {
                    char op = input.next().charAt(0);
                    if (op == 'Y' | op == 'y') {
                        continue;
                    } else if (op == 'N' | op == 'n') {
                        stockManage();
                        break;
                    }
                } while (true);
            }
        } while (true);
    }


    public static void deleteSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                     DELETE SUPPLIER                      |");
        System.out.println("+----------------------------------------------------------+");

        do {
            System.out.println();
            System.out.print("Supplier ID: ");
            String id = input.next();

            int index = findIndex(id, suppliers);

            if (index == -1) {
                System.out.println("Can't find supplier ID.\n");
            } else {
                // Create a new array with size suppliers.length - 1
                String[][] newSuppliers = new String[suppliers.length - 1][2];

                // Copy all elements except for the supplier at the found index
                int newIndex = 0;
                for (int i = 0; i < suppliers.length; i++) {
                    if (i != index) {
                        newSuppliers[newIndex] = suppliers[i];
                        newIndex++;
                    }
                }

                // Update the suppliers array reference to point to the newSuppliers array
                suppliers = newSuppliers;

                System.out.print("Deleted successfully! Do you want to delete another supplier (Y/N)? ");
                char option = input.next().charAt(0);
                if (option == 'N' || option == 'n') {
                    stockManage();
                    break;
                }
            }
        } while (true);
    }

    public static void viewSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                      VIEW SUPPLIER                       |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        System.out.println("+---------------------+------------------- --+");
        System.out.println("|     SUPPLIER ID     |     SUPPLIER NAME    |");
        System.out.println("+---------------------+----------------------+");
        for (String[] supplier : suppliers) {
            System.out.printf("|        %-13s|         %-13s|%n", supplier[0], supplier[1]);
        }
        System.out.println("+--------------------------------------------+");
        System.out.print("Do you want to go supplier manage page(Y/N)? ");
        do {
            char op = input.next().charAt(0);
            if (op == 'Y' | op == 'y') {
                supplierManage();
            } else if (op == 'N' | op == 'n') {
                stockManage();
                break;
            }
        } while (true);
    }

    public static void searchSupplier() {
        L1:
        do {
            clearConsole();
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                     SEARCH SUPPLIER                      |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println();
            System.out.println("Supplier ID ");
            String id = input.next();
            if (findIndex(id, suppliers) == -1) {
                System.out.print("can't find supplier id. try again! ");
            } else {
                System.out.println("Supplier: " + suppliers[findIndex(id, suppliers)][1]);
                System.out.print("Added successfully! Do you want to search for another supplier (Y/N)? ");
                char option;
                do {
                    char op = input.next().charAt(0);
                    if (op == 'Y' | op == 'y') {
                        continue L1;
                    } else if (op == 'N' | op == 'n') {
                        supplierManage();
                        break L1;
                    }
                } while (true);
            }
        } while (true);
    }

//    =========================== Manage Stock =============================================

    public static void stockManage() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                     STOCK MANAGE                         |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        System.out.println("[1] Manage Item Categories\t\t[2] Add Item\n[3] Get Items Supplier Wise\t\t[4] View Items\n[5] Rank Items Per Unit Price\t\t[6] Home Page ");
        System.out.println();
        do {
            System.out.print("Enter an option to continue > ");
            char op = input.next().charAt(0);
            switch (op) {
                case '1':
                    manageItemCategories();
                    break;
                case '2':
                    addItem();
                    break;
                case '3':
                    getItemsSupplierWise();
                    break;
                case '4':
                    viewItems();
                    break;
                case '5':
                    RankItemsPerUnitPrice();
                    break;
                case '6':
                    dashBoard();
                    break;
            }
        } while (true);
    }

    public static void addItem() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                         ADD ITEM                         |");
        System.out.println("+----------------------------------------------------------+");

        L1:
        do {
            System.out.println();

            if (categories.length == 0) {
                System.out.println("OOPS! It seems that you don't have any item categories in the system");
                System.out.print("Do you want to add a new item category? (Y/N) ");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    addNewItemCategory();
                }
            } else if (suppliers.length == 0) {
                System.out.println("OOPS! It seems that you don't have any suppliers in the system");
                System.out.print("Do you want to add new suppliers? (Y/N) ");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    addSupplier();
                    //stockManage();
                }
            } else {
                System.out.print("Item Code: ");
                String code = input.next();

                if (findIndex(code, items) != -1) {
                    System.out.println("Your item already exists. Please try again.\n");
                } else {
                    items = grow(items, 6);
                    items[items.length - 1][0] = code;

                    System.out.println("\nSuppliers List:");
                    viewSupplierForAddItems();

                    System.out.print("Enter the Supplier Number > ");
                    int supplier_number = input.nextInt();

                    System.out.println("\nItem Categories:");
                    viewItemCategoriesForAddItems();

                    System.out.print("Enter the Category Number > ");
                    int category_number = input.nextInt();

                    System.out.print("\nDescription: ");
                    String description = input.next();

                    System.out.print("Unit Price: ");
                    double price = input.nextDouble();

                    System.out.print("QTY on Hand: ");
                    int qty = input.nextInt();

                    items[items.length - 1][1] = description;
                    items[items.length - 1][2] = Double.toString(price);
                    items[items.length - 1][3] = Integer.toString(qty);
                    items[items.length - 1][4] = categories[category_number - 1];
                    items[items.length - 1][5] = suppliers[supplier_number - 1][0];

                    System.out.println("Added successfully!");
                }
            }

            System.out.print("Do you want to add another item (Y/N)? ");
            do {
                char option = input.next().charAt(0);
                if (option == 'N' || option == 'n') {
                    stockManage();
                    break L1;
                } else if (option == 'Y' || option == 'y') {
                    continue L1;
                } else {
                    System.out.print("Invalid input. Try again: ");
                }
            } while (true);
        } while (true);
    }

    public static void viewItemCategoriesForAddItems() {
        System.out.println("+---------------------+--------------------------------+");
        System.out.println("|           #         |          Category              |");
        System.out.println("+---------------------+--------------------------------+");
        int i = 0;
        for (String category : categories) {
            System.out.printf("|        %-13d|        %-24s|%n", (i++) + 1, category);
        }
        System.out.println("+------------------------------------------------------+");
    }

    public static void viewSupplierForAddItems() {
        System.out.println("+---------------------+---------------------+------------------- --+");
        System.out.println("|           #         |     SUPPLIER ID     |     SUPPLIER NAME    |");
        System.out.println("+---------------------+---------------------+----------------------+");
        int i = 0;
        for (String[] supplier : suppliers) {
            System.out.printf("|          %-11d|        %-13s|         %-13s|%n", (i++) + 1, supplier[0], supplier[1]);
        }
        System.out.println("+------------------------------------------------------------------+");
    }

    //    ++++++++++++++++++++++++++++


    public static void getItemsSupplierWise() {
        clearConsole();
        System.out.println("+------------------------------------------------------------+");
        System.out.println("|              GET ITEMS SUPPLIER-WISE                       |");
        System.out.println("+------------------------------------------------------------+");
        System.out.println();

        if (suppliers.length == 0) {
            System.out.println("No suppliers available. Please add suppliers first.");
            System.out.print("Do you want to add another item (Y/N)? ");
            do {
                char option = input.next().charAt(0);
                if (option == 'N' || option == 'n') {
                    stockManage();
                    return;
                } else if (option == 'Y' || option == 'y') {
                    addSupplier();
                    break;
                } else {
                    System.out.print("Invalid input. Try again: ");
                }
            } while (true);

        } else {

            System.out.println("Suppliers:");
            System.out.println("+---------------------+----------------------------+");
            System.out.println("|     SUPPLIER ID     |     SUPPLIER NAME          |");
            System.out.println("+---------------------+----------------------------+");
            for (String[] supplier : suppliers) {
                System.out.printf("|        %-13s|         %-17s|%n", supplier[0], supplier[1]);
            }
            System.out.println("+--------------------------------------------------+");

            System.out.print("Enter the Supplier ID: ");
            String supplierId = input.next();

            int supplierIndex = findIndex(supplierId, suppliers);

            if (supplierIndex == -1) {
                System.out.println("Supplier not found. Please enter a valid Supplier ID.");
                input.nextLine();
                input.nextLine();
                stockManage();
                return;
            }

            String supplierName = suppliers[supplierIndex][1];

            System.out.println("Items supplied by: " + supplierName);
            System.out.println("+---------------+-----------------------+------------+-------------------+---------------+");
            System.out.println("| ITEM CODE     |      DESCRIPTION      | UNIT PRICE | QUANTITY ON HAND  |   CATEGORY    |");
            System.out.println("+---------------+-----------------------+------------+-------------------+---------------+");
            int itemCount = 0;
            for (String[] item : items) {
                if (item[5].equals(supplierId)) {
                    System.out.printf("|    %-11s| %-22s| $%-8s |     %-10s | %-12s |%n", item[0], item[1], item[2], item[3], item[4]);
                    itemCount++;
                }
            }
            System.out.println("+----------------------------------------------------------------------------------------+");

            if (itemCount == 0) {
                System.out.println("No items available from this supplier.");
            }

            System.out.print("Successfylly searched!!.. Do you want to do another Search (Y/N)? ");
            do {
                char option = input.next().charAt(0);
                if (option == 'N' || option == 'n') {
                    stockManage();
                    return;
                } else if (option == 'Y' || option == 'y') {
                    break;
                } else {
                    System.out.print("Invalid input. Try again: ");
                }
            } while (true);

            input.nextLine();
            input.nextLine();
            getItemsSupplierWise(); // Call the method recursively for another search
        }
    }

    public static void viewItems() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                    VIEW ITEMS                            |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();

        // Get unique categories
        Set<String> categories = new HashSet<>();
        for (String[] item : items) {
            categories.add(item[4]);
        }

        // Iterate over categories and display items in each category
        for (String category : categories) {
            System.out.printf("+----------------- %s -----------------+%n", category);
            System.out.println("+--------------+------------------+--------------+-------------------+");
            System.out.println("|   ITEM CODE  |   DESCRIPTION    | UNIT PRICE   | QUANTITY ON HAND  |");
            System.out.println("+--------------+------------------+--------------+-------------------+");
            for (String[] item : items) {
                if (item[4].equals(category)) {
                    System.out.printf("|    %-11s| %-22s| $%-8s |     %-10s |%n", item[0], item[1], item[2], item[3]);
                }
            }
            System.out.println("+--------------------------------------------------------------------+");
            System.out.println();
        }

        System.out.println("Press Enter to go back to the Stock Manage page...");
        input.nextLine();
        input.nextLine();
        stockManage();
    }

    public static void RankItemsPerUnitPrice() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                   RANKED UNIT PRICE                      |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();

        // Sort items based on unit price
        Arrays.sort(items, Comparator.comparingDouble(item -> Double.parseDouble(item[2])));

        System.out.println("+---------------+-----------------------+--------------+-------------------+------------------+");
        System.out.println("| ITEM CODE     |      DESCRIPTION      | UNIT PRICE   | QUANTITY ON HAND  |   CATEGORY       |");
        System.out.println("+---------------+-----------------------+--------------+-------------------+------------------+");
        for (String[] item : items) {
            System.out.printf("|    %-11s| %-22s| $%-8s |     %-10s | %-12s |%n", item[0], item[1], item[2], item[3], item[4]);
        }
        System.out.println("+---------------------------------------------------------------------------------------------+");

        System.out.print("Do you want to go back to the Stock Manage Page (Y/N)? ");
        do {
            char option = input.next().charAt(0);
            if (option == 'Y' || option == 'y') {
                stockManage();
                return;
            } else if (option == 'N' || option == 'n') {
                break;
            } else {
                System.out.print("Invalid input. Try again: ");
            }
        } while (true);

        input.nextLine();
        input.nextLine();
        stockManage();
    }

//    =============================== Manage Categories =======================================

    public static void manageItemCategories() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                    MANAGE ITEM CATEGORY                  |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("[1] Add New Item Category\t\t[2] Delete Item Category\n[3] Update Item Category\t\t[4] Stock Management ");
        System.out.println();
        do {
            System.out.print("Enter an option to continue > ");
            char op = input.next().charAt(0);
            switch (op) {
                case '1':
                    addNewItemCategory();
                    break;
                case '2':
                    deleteItemCategory();
                    break;
                case '3':
                    updateItemCategory();
                case '4':
                    stockManage();
                    break;
            }
        } while (true);
    }


    public static void addNewItemCategory() {
        clearConsole();
        L1:
        do {
            System.out.println("+----------------------------------------------------------+");
            System.out.println("|                    ADD ITEM CATEGORY                     |");
            System.out.println("+----------------------------------------------------------+");
            System.out.println();

            System.out.print("Enter the new item category: ");
            String category = input.next();

            if (findIndexOneDimensional(category, categories) != -1) {
                System.out.println("Your category already exists. Try again!\n");
            } else {
                growOneDimensional();
                categories[categories.length - 1] = category;
                System.out.println("Added successfully!");
            }

            System.out.print("Do you want to add another category (Y/N)? ");
            do {
                char option = input.next().charAt(0);
                if (option == 'N' || option == 'n') {
                    //return;
                    manageItemCategories();
                    break L1;

                } else if (option == 'Y' || option == 'y') {
                    continue L1;
                    // break;
                } else {
                    System.out.print("Invalid input. Try again: ");
                }
            } while (true);
        } while (true);
    }


    public static void deleteItemCategory() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                 DELETE ITEM CATEGORY                     |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        L1:
        do {
            System.out.print("Enter the item category : ");
            String category = input.next();

            if (findIndexOneDimensional(category, categories) == -1) {
                System.out.println("can't find  Category .try again ! ");
            } else {
                categories = removeCategory(findIndexOneDimensional(category, categories), categories);
                System.out.print("Deleted Successfully ! Do you want Delete to another Categories ? (Y/N) ");
                do {
                    char op = input.next().charAt(0);
                    if (op == 'Y' | op == 'y') {
                        clearConsole();
                        continue L1;
                    } else if (op == 'N' | op == 'n') {
                        stockManage();
                        break L1;
                    } else {
                        System.out.println("invalid character . try again ! ");
                    }
                } while (true);
            }
        } while (true);

    }

    public static void updateItemCategory() {
        clearConsole();
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                 UPDATE ITEM CATEGORY                     |");
        System.out.println("+----------------------------------------------------------+");
        System.out.println();
        L1:
        do {
            System.out.print("Enter the item category : ");
            String category = input.next();

            if (findIndexOneDimensional(category, categories) == -1) {
                System.out.println("can't find  Category .try again ! ");
            } else {
                System.out.println("Category  " + categories[findIndexOneDimensional(category, categories)]);
                System.out.print("Enter the new Category : ");
                categories[findIndexOneDimensional(category, categories)] = input.next();
                System.out.print("Updated successfully! ");
            }
            System.out.print("Do you want to update another Category?(Y/N) ");
            do {
                char op = input.next().charAt(0);
                if (op == 'Y') {
                    clearConsole();
                    continue L1;
                } else if (op == 'N') {
                    stockManage();
                    break L1;
                }
            } while (true);
        } while (true);
    }


}





