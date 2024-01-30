package com.mjv.curso;


import java.util.Scanner;

import com.mjv.curso.model.User;
import com.mjv.curso.service.FileHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MainSystemJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainSystemJavaApplication.class, args);

			Scanner scanner = new Scanner(System.in);

				createDirectoryIfNotExists();

				while (true) {
					System.out.println("1. View record");
					System.out.println("2. Add new record");
					System.out.println("3. Out");
					System.out.print("Choose an option: ");

					int choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
						case 1:
							displayRecords();
							break;
						case 2:
							addUser();
							break;
						case 3:
							System.out.println("Closing the program. Until later!");
							scanner.close();
							System.exit(0);
							break;
						default:
							System.out.println("Invalid option. Try again.");
					}
				}
			}

			private static void createDirectoryIfNotExists() {
				FileHandler.createDirectory();
			}

			private static void displayRecords() {
				List<User> users = FileHandler.readUsersFromFile();
				if (users.isEmpty()) {
					System.out.println("No records found.");
				} else {
					System.out.println("Records found:");
					for (User user : users) {
						System.out.println(user);
					}
				}
			}

			private static void addUser() {
				Scanner scanner = new Scanner(System.in);

				System.out.print("Enter full name: ");
				String nomeCompleto = scanner.nextLine();

				System.out.print("Enter age: ");
				int idade = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter profession: ");
				String profissao = scanner.nextLine();

				User newUser = new User(nomeCompleto, idade, profissao);
				FileHandler.writeUserToFile(newUser);

				System.out.println("Record added successfully!");
			}
		}









