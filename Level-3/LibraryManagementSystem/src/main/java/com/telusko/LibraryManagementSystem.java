
package com.telusko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LibraryManagementSystem {

    Scanner sc = new Scanner(System.in);

    public void start() {

        while (true) {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    borrowBook();
                    break;

                case 4:
                    returnBook();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public void addBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            String query =
                    "INSERT INTO books(title, author, available) VALUES (?, ?, 1)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, title);
            ps.setString(2, author);

            ps.executeUpdate();

            System.out.println("Book Added Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM books";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Books =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                (rs.getBoolean("available")
                                        ? "Available"
                                        : "Borrowed")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrowBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            String check =
                    "SELECT available FROM books WHERE id=?";

            PreparedStatement ps1 =
                    con.prepareStatement(check);

            ps1.setInt(1, id);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                if (rs.getBoolean("available")) {

                    String query =
                            "UPDATE books SET available=0 WHERE id=?";

                    PreparedStatement ps2 =
                            con.prepareStatement(query);

                    ps2.setInt(1, id);

                    ps2.executeUpdate();

                    System.out.println("Book Borrowed Successfully!");

                } else {

                    System.out.println("Book Already Borrowed!");
                }

            } else {

                System.out.println("Book Not Found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook() {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            String query =
                    "UPDATE books SET available=1 WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book Returned Successfully!");
            } else {
                System.out.println("Book Not Found!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
