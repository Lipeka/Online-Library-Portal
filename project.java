import java.sql.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LibraryPortal {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/Lib", "root", "chitra1969");
            stmt = con.createStatement();
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss yyyy");
            LocalDateTime now = LocalDateTime.now();
            String date = dtf.format(now);
            String day = date.substring(0, 3);
            String month = date.substring(4, 7);
            int date1 = Integer.parseInt(date.substring(8, 10));
            String time1 = date.substring(11, 19);
            int year = Integer.parseInt(date.substring(20, 24));
            String day1 = "";
            if (day.equals("Mon")) {
                day1 = "Monday";
            } else if (day.equals("Tue")) {
                day1 = "Tuesday";
            } else if (day.equals("Wed")) {
                day1 = "Wednesday";
            } else if (day.equals("Thu")) {
                day1 = "Thursday";
            } else if (day.equals("Fri")) {
                day1 = "Friday";
            } else if (day.equals("Sat")) {
                day1 = "Saturday";
            } else if (day.equals("Sun")) {
                day1 = "Sunday";
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to our Library's Online Portal");
            System.out.print("Do you have an account with us?[Y/N]: ");
            String user_input1 = scanner.nextLine().toUpperCase();
            if (user_input1.equals("Y")) {
                System.out.print("Enter your name: ");
                String userName = scanner.nextLine();
                String query = "SELECT * FROM nameList";
                rs = stmt.executeQuery(query);
                boolean found = false;
                while (rs.next()) {
                    String uName = rs.getString("name");
                    if (userName.equals(uName)) {
                        found = true;
                        System.out.println("Welcome Back " + userName);
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Username Not Found");
                    System.out.println("Please Register with us to proceed");
                    System.out.println("You will be creating an account with us.");
                    System.out.print("Enter your name: ");
                    String uName = scanner.nextLine();
                    System.out.print("Enter your E-Mail ID: ");
                    String eMail = scanner.nextLine();
                    System.out.print("Enter your Mobile Number: ");
                    String mob = scanner.nextLine();
                    while (mob.length() != 10) {
                        System.out.println("Please Enter your mobile number correctly");
                        System.out.print("Enter your Mobile Number: ");
                        mob = scanner.nextLine();
                    }
                    System.out.println("Successfully connected to Database");
                    String query1 = "";
                    stmt.executeUpdate(query1);
                    String query2 = "INSERT INTO nameList VALUES (?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(query2);
                    pstmt.setString(1, uName);
                    pstmt.setString(2, mob);
                    pstmt.setString(3, eMail);
                    pstmt.executeUpdate();
                    System.out.println("Account Created Successfully");
                    System.out.println("Welcome " + uName);
                }
            } else {
                System.out.println("You will be creating an account with us.");
                System.out.print("Enter your name: ");
                String uName = scanner.nextLine();
                System.out.print("Enter your E-Mail ID: ");
                String eMail = scanner.nextLine();
                System.out.print("Enter your Mobile Number: ");
                String mob = scanner.nextLine();
                while (mob.length() != 10) {
                    System.out.println("Please Enter your mobile number correctly");
                    System.out.print("Enter your Mobile Number: ");
                    mob = scanner.nextLine();
                }
                System.out.println("Successfully connected to Database");
                String query1 = "";
                stmt.executeUpdate(query1);
                String query2 = "INSERT INTO nameList VALUES (?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query2);
                pstmt.setString(1, uName);
                pstmt.setString(2, mob);
                pstmt.setString(3, eMail);
                pstmt.executeUpdate();
                System.out.println("Account Created Successfully");
                System.out.println("Welcome " + uName);
            }
            
            String mainmenu = "Y";
            while (mainmenu.equals("Y")) {
                System.out.println("Would you like to");
                System.out.println("1. View All the Books");
                System.out.println("2. Buy Books");
                System.out.println("3. Exit");
                System.out.print("Enter your choice[1/2/3]: ");
                int user_input2 = scanner.nextInt();
                if (user_input2 == 1) {
                    System.out.println("We have a state of the art database with a large variety of books");
                    String user_input3 = "Y";
                    while (user_input3.equals("Y")) {
                        System.out.println("Available Genres:");
                        System.out.println("1. Fiction");
                        System.out.println("2. Mystery");
                        System.out.println("3. Children Literature");
                        System.out.println("4. Action");
                        System.out.println("5. Horror");
                        System.out.println("6. Romance");
                        System.out.println("7. History");
                        System.out.println("8. Educational");
                        System.out.println("9. Warfare");
                        System.out.println("10. Comedy");
                        System.out.print("Enter the appropriate choice: ");
                        int genre = scanner.nextInt();
                        System.out.println();
                        System.out.println("--------------------------------------");

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String user_input2 = input.nextLine();
        if (user_input2.equals("1")) {
            String user_input3 = "Y";
            while (user_input3.equals("Y")) {
                System.out.println("Available Genres: \n1.Fiction\n2.Mystery\n3.Children Literature\n4.Action\n5.Horror\n6.Romance\n7.History\n8.Educational\n9.Warfare\n10.Comedy\n");
                int genre = input.nextInt();
                if (genre > 10 || genre < 1) {
                    System.out.println("Invalid Entry");
                    System.out.print("Would you like to try again[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 1) {
                    System.out.println(Fiction.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 2) {
                    System.out.println(Mystery.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 3) {
                    System.out.println(childrenLiterature.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 4) {
                    System.out.println(Action.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 5) {
                    System.out.println(Horror.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 6) {
                    System.out.println(Romance.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 7) {
                    System.out.println(History.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 8) {
                    System.out.println(Educational.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 9) {
                    System.out.println(Warfare.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 10) {
                    System.out.println(Comedy.getName());
                    System.out.print("\nWould you like look at a different genre?[Y/N]: ");
                    user_input3 = input.next();
                }
            }
            System.out.print("Would you like to go back to the main-menu?[Y/N]");
            String mainmenu = input.next();
        } else if (user_input2.equals("2")) {
            System.out.println("You can now buy your favourite books from our portal.");
            String user_input3 = "Y";
            String[] bookList = new String[100];
            int[] costList = new int[100];
            int cost = 0;
            int count = 0;
            while (user_input3.equals("Y")) {
                System.out.println("Available Genres: \n1.Fiction\n2.Mystery\n3.Children Literature\n4.Action\n5.Horror\n6.Romance\n7.History\n8.Educational\n9.Warfare\n10.Comedy\n");
                int genre = input.nextInt();
                if (genre > 10 || genre < 1) {
                    System.out.println("Invalid Entry");
                    System.out.print("Would you like to try again[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 1) {
                    System.out.println(Fiction.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Fiction.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Fiction.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Fiction.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Fiction.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Fiction.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 2) {
                    System.out.println(Mystery.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Mystery.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Mystery.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Mystery.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Mystery.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Mystery.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 3) {
                    System.out.println(childrenLiterature.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(childrenLiterature.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(childrenLiterature.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(childrenLiterature.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(childrenLiterature.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(childrenLiterature.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 4) {
                    System.out.println(Action.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Action.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Action.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Action.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Action.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Action.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 5) {
                    System.out.println(Horror.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Horror.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Horror.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Horror.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Horror.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Horror.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 6) {
                    System.out.println(Romance.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Romance.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Romance.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Romance.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Romance.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Romance.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 7) {
                    System.out.println(History.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(History.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(History.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(History.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(History.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(History.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 8) {
                    System.out.println(Educational.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Educational.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Educational.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Educational.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Educational.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Educational.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 9) {
                    System.out.println(Warfare.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Warfare.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Warfare.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Warfare.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Warfare.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Warfare.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                } else if (genre == 10) {
                    System.out.println(Comedy.getName());
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Comedy.iloc[index:index + 1, 0:1].values[0]);
                    int price = Integer.parseInt(String.valueOf(Comedy.iloc[index:index + 1, 1:2].values[0]));
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    System.out.print("Confirmation: [Y/N]");
                    String confirm = input.next();
                    while (!confirm.equals("Y")) {
                        System.out.println(Comedy.getName());
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Comedy.iloc[index:index + 1, 0:1].values[0]);
                        price = Integer.parseInt(String.valueOf(Comedy.iloc[index:index + 1, 1:2].values[0]));
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList[count] = bookName;
                    costList[count] = price;
                    cost = cost + price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    user_input3 = input.next();
                }
            }
        }
    }
}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> bookList = new ArrayList<>();
        List<Integer> costList = new ArrayList<>();
        int cost = 0;
        int count = 0;
        String interaction = "Y";
        while (interaction.equals("Y")) {
            System.out.println("Welcome to the Book Store!");
            System.out.println("1. Browse Books");
            System.out.println("2. View Cart");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int user_input2 = input.nextInt();
            if (user_input2 == 1) {
                System.out.println("Genres:");
                System.out.println("1. Mystery");
                System.out.println("2. Fiction");
                System.out.println("3. Action");
                System.out.println("4. Romance");
                System.out.println("5. History");
                System.out.println("6. Science Fiction");
                System.out.println("7. Biography");
                System.out.println("8. Educational");
                System.out.println("9. Warfare");
                System.out.println("10. Comedy");
                System.out.print("Enter the genre number: ");
                int genre = input.nextInt();
                if (genre == 1) {
                    System.out.println(Mystery["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Mystery[index][0]);
                    int price = Integer.parseInt(Mystery[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Mystery["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Mystery[index][0]);
                        price = Integer.parseInt(Mystery[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 2) {
                    System.out.println(Fiction["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Fiction[index][0]);
                    int price = Integer.parseInt(Fiction[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Fiction["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Fiction[index][0]);
                        price = Integer.parseInt(Fiction[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 3) {
                    System.out.println(Action["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Action[index][0]);
                    int price = Integer.parseInt(Action[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Action["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Action[index][0]);
                        price = Integer.parseInt(Action[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 4) {
                    System.out.println(Romance["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Romance[index][0]);
                    int price = Integer.parseInt(Romance[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Romance["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Romance[index][0]);
                        price = Integer.parseInt(Romance[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 5) {
                    System.out.println(History["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(History[index][0]);
                    int price = Integer.parseInt(History[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(History["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(History[index][0]);
                        price = Integer.parseInt(History[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 6) {
                    System.out.println(ScienceFiction["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(ScienceFiction[index][0]);
                    int price = Integer.parseInt(ScienceFiction[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(ScienceFiction["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(ScienceFiction[index][0]);
                        price = Integer.parseInt(ScienceFiction[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 7) {
                    System.out.println(Biography["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Biography[index][0]);
                    int price = Integer.parseInt(Biography[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Biography["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Biography[index][0]);
                        price = Integer.parseInt(Biography[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 8) {
                    System.out.println(Educational["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Educational[index][0]);
                    int price = Integer.parseInt(Educational[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Educational["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Educational[index][0]);
                        price = Integer.parseInt(Educational[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 9) {
                    System.out.println(Warfare["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Warfare[index][0]);
                    int price = Integer.parseInt(Warfare[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Warfare["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Warfare[index][0]);
                        price = Integer.parseInt(Warfare[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                } else if (genre == 10) {
                    System.out.println(Comedy["Name"]);
                    System.out.print("Enter Position of Book[as in Output]: ");
                    int index = input.nextInt();
                    String bookName = String.valueOf(Comedy[index][0]);
                    int price = Integer.parseInt(Comedy[index][1]);
                    System.out.println("Book Chosen: " + bookName);
                    System.out.println("Price: " + price);
                    String confirm = "";
                    while (!confirm.equals("Y")) {
                        System.out.println(Comedy["Name"]);
                        System.out.print("Enter Position of Book[as in Output]: ");
                        index = input.nextInt();
                        bookName = String.valueOf(Comedy[index][0]);
                        price = Integer.parseInt(Comedy[index][1]);
                        System.out.println("Book Chosen: " + bookName);
                        System.out.println("Price: " + price);
                        System.out.print("Confirmation: [Y/N]");
                        confirm = input.next();
                    }
                    bookList.add(bookName);
                    costList.add(price);
                    cost += price;
                    count++;
                    System.out.println("Book has been successfully added to cart!");
                    System.out.print("\nWould you like to add another book?[Y/N]: ");
                    String user_input3 = input.next();
                }
            } else if (user_input2 == 2) {
                System.out.print("Would you like to view your cart?[Y/N]");
                String cart = input.next();
                if (cart.equals("Y")) {
                    System.out.println("Number of Items bought -> " + count);
                    System.out.println("List of Books -> " + bookList);
                    System.out.println("Total -> " + cost);
                }
                System.out.println("Please Wait while the bill is being generated...");
                countdown(3);
                System.out.println("*************************************************************************************\n");
                System.out.println("\t\t\t\t\tINVOICE\n");
                System.out.println("\t\t\t\tSTRAHOV MONASTERY LIBRARY\n");
                System.out.println("Bill No:" + generate_code() + "\t\t\t\t\t\tDay: " + day1);
                System.out.println("Date:" + date1 + month + year + "\t\t\t\t\t\t\tTime:" + time1);
                System.out.println("Name: " + uName + "\t\t\t\t\t\t\tMob No:" + mob);
                System.out.println("\n");
                System.out.println("Book Name");
                for (int x = 0; x < count; x++) {
                    System.out.println("\t\t\t" + bookList.get(x));
                }
                System.out.println("Price");
                for (int x = 0; x < count; x++) {
                    System.out.println(costList.get(x));
                }
                System.out.println("\n");
                System.out.println("Quantity: " + count);
                System.out.println("Gross Total: Rs." + cost);
                System.out.println("GST: Rs." + gst(cost));
                System.out.println("Net Total: Rs." + (cost + gst(cost)));
                System.out.println("\n");
                System.out.println("*************************************************************************************\n");
                System.out.println("Redirecting to the payment portal...");
                countdown(5);
                System.out.println("Amount to be paid: Rs." + (cost + gst(cost)));
                System.out.println("Would you like to pay by \n1.Card\n2.UPI");
                int payment = input.nextInt();
                if (payment == 1) {
                    String ques = "Y";
                    while (ques.equals("Y")) {
                        System.out.print("Enter the payment processor[VISA/MASTERCARD]: ");
                        String cardtype = input.next().toUpperCase();
                        System.out.print("Enter Card Number: ");
                        int cardnumber = input.nextInt();
                        while (String.valueOf(cardnumber).length() != 16) {
                            System.out.print("Enter Valid Card Number: ");
                            cardnumber = input.nextInt();
                        }
                        System.out.print("Enter name of holder: ");
                        String cardname = input.next().toUpperCase();
                        System.out.print("Enter expiry Month and Year of the card[MM/YY]: ");
                        String expiry = input.next();
                        System.out.print("Enter CVV: ");
                        int cvv = input.nextInt();
                        if (String.valueOf(cvv).length() != 3) {
                            System.out.print("Enter a valid CVV");
                            cvv = input.nextInt();
                        }
                        System.out.println("Showing the entered details");
                        System.out.println("Holder Name: " + cardname);
                        System.out.println("Card Number: " + cardnumber);
                        System.out.println("Expiry Date: " + expiry);
                        System.out.print("Is there a need to change any of the details?[Y/N]: ");
                        ques = input.next();
                    }
                    System.out.println("An E-mail has been sent to " + eMail + " containing the payment link for the same.");
                } else if (payment == 2) {
                    String ip = "N";
                    while (ip.equals("N")) {
                        System.out.print("Enter UPI ID: ");
                        String upi = input.next();
                        System.out.println("UPI ID: " + upi);
                        System.out.print("Would you like to confirm the above mentioned UPI ID?[Y/N]: ");
                        ip = input.next();
                    }
                    System.out.println("A payment request has been sent. Please make the confirmation.");
                }
                System.out.println("Thank you for using our payment portal.");
                String interaction = "Y";
                while (interaction.equals("Y")) {
                    System.out.println("Would you like to");
                    System.out.println("1.Statistics on the fast-moving books and Genres");
                    System.out.println("2.Give valuable user-feedback");
                    System.out.println("3.View our Website");
                    System.out.println("4.Exit");
                    System.out.print("Enter your choice: ");
                    int option = input.nextInt();
                    if (option == 1) {
                        String iterate = "Y";
                        while (iterate.equals("Y")) {
                            System.out.println("Would you like to see");
                            System.out.println("1. Most popular genres over the years");
                            System.out.println("2. Fast-Moving Books over the years");
                            System.out.print("Enter your choice: ");
                            int graph = input.nextInt();
                            if (graph == 1) {
                                System.out.println("2015: Harry Potter");
                                System.out.println("2016: Peter Pan");
                                System.out.println("2017: The Shining");
                                System.out.println("2018: YOU");
                                System.out.println("2019: Child's Play");
                                String[] objects = {"Harry Potter", "Peter Pan", "The Shining", "YOU", "Child's Play"};
                                int[] y_pos = new int[objects.length];
                                for (int i = 0; i < objects.length; i++) {
                                    y_pos[i] = i;
                                }
                                double[] performance = {8.9, 9.5, 8.5, 10, 9.7};
                                String colour = "purple";
                                for (int i = 0; i < objects.length; i++) {
                                    System.out.println(objects[i] + ": " + performance[i]);
                                }
                                System.out.print("Would you like to look at other statistics?[Y/N]: ");
                                iterate = input.next();
                            } else if (graph == 2) {
                                System.out.println("2015: Mystery");
                                System.out.println("2016: Fiction");
                                System.out.println("2017: Action");
                                System.out.println("2018: Romance");
                                System.out.println("2019: History");
                                int[] X = {2015, 2016, 2017, 2018, 2019};
                                String[] label = {"Mystery", "Fiction", "Action", "Romance", "History"};
                                String[] colours = {"red", "green", "blue", "yellow", "orange"};
                                double[] explode = {0, 0, 0, 0, 0.1};
                                System.out.print("Would you like to look at other statistics?[Y/N]: ");
                                iterate = input.next();
                            }
                        }
                    } else if (option == 2) {
                        System.out.print("How much would you like to rate our service[On a scale of 10]?: ");
                        int feedback1 = input.nextInt();
                        if (feedback1 >= 0 && feedback1 <= 3) {
                            System.out.println("We are sorry for your inconvenience :( ");
                            System.out.print("How would you like to improve our service?: ");
                            String feedback2 = input.next();
                            System.out.print("Would you like to add another suggestion[yes/no]: ");
                            String ques = input.next().toUpperCase();
                            while (ques.equals("YES")) {
                                System.out.print("How would you like to improve our service?: ");
                                feedback2 = input.next();
                                System.out.print("Would you like to add another suggestion[yes/no]: ");
                                ques = input.next().toUpperCase();
                            }
                        } else if (feedback1 >= 4 && feedback1 <= 6) {
                            System.out.print("How would you like to improve our service?: ");
                            String feedback2 = input.next();
                            System.out.print("Would you like to add another suggestion[yes/no]: ");
                            String ques = input.next().toUpperCase();
                            while (ques.equals("YES")) {
                                System.out.print("How would you like to improve our service?: ");
                                feedback2 = input.next();
                                System.out.print("Would you like to add another suggestion[yes/no]: ");
                                ques = input.next().toUpperCase();
                            }
                        } else if (feedback1 >= 7 && feedback1 <= 9) {
                            System.out.print("How would you like to improve our service?: ");
                            String feedback2 = input.next();
                            System.out.print("Would you like to add another suggestion[yes/no]: ");
                            String ques = input.next().toUpperCase();
                            while (ques.equals("YES")) {
                                System.out.print("How would you like to improve our service?: ");
                                feedback2 = input.next();
                                System.out.print("Would you like to add another suggestion[yes/no]: ");
                                ques = input.next().toUpperCase();
                            }
                        } else if (feedback1 == 10) {
                            System.out.println("We are glad to serve you!!");
                        }
                        System.out.println("Thank you for your feedback!!");
                    } else if (option == 3) {
                        System.out.println("You will be redirected to our website");
                        countdown(5);
                        String url = "file:///C:/Users/SaiSid/Downloads/Lipika Project/index.html";
                        openWebpage(url);
                    } else if (option == 4) {
                        System.out.println("Thank You for using our portal.");
                        System.out.println("Logging Off....");
                        System.exit(0);
                    }
                    System.out.print("Would you like to back to the main-menu?[Y/N]");
                    interaction = input.next();
                }
                System.out.print("Would you like to go back to the main-menu?[Y/N]");
                String mainmenu = input.next();
            } else if (user_input2 == 3) {
                System.out.println("Thank You for using our portal.");
                System.out.println("Logging Off....");
                System.exit(0);
            }
        }
    }

    public static void countdown(int seconds) {
        for (int i = seconds; i >= 0; i--) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String generate_code() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    public static double gst(int cost) {
        return cost * 0.18;
    }

    public static void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static String[][] Mystery = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] Fiction = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] Action = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] Romance = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] History = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] ScienceFiction = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] Biography = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] Educational = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] Warfare = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };

    public static String[][] Comedy = {
            {"Book1", "10"},
            {"Book2", "20"},
            {"Book3", "30"}
    };
}





