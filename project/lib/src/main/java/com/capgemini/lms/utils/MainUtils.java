package com.capgemini.lms.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.service.BookServiceImpl;
import com.capgemini.lms.service.BooksOrderserviceImpl;
import com.capgemini.lms.service.DamagedBooksServiceImpl;
import com.capgemini.lms.service.IBookService;
import com.capgemini.lms.service.IBooksOrderService;
import com.capgemini.lms.service.IDamagedBooksService;

public class MainUtils {
	Logger logger = LogManager.getLogger(MainUtils.class);

	public void start() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		String choice = null;

		IBookService bookService = new BookServiceImpl();
		IBooksOrderService booksOrderService = new BooksOrderserviceImpl();
		IDamagedBooksService damagedBookService = new DamagedBooksServiceImpl();

		logger.info("Instantiated All instance");
		System.out.println("1. Access Books");
		System.out.println("2. Access Books Order");
		System.out.println("3. Access Damaged Books");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			do {
				System.out.println("1. Add Book");
				System.out.println("2. Update Book Details");
				System.out.println("3. Remove Book");
				System.out.println("4. Search Books by Title");
				System.out.println("5. Search Books by Subject");
				System.out.println("6. View All books");
				System.out.println("Enter your choice: ");
				int selectedOption = sc.nextInt();
				logger.info(String.format("User Selected option %d", selectedOption));
				switch (selectedOption) {
				case 1:
					System.out.println("Enter Book Id:");
					int bookId = sc.nextInt();
					System.out.println("Enter Title:");
					String title = br.readLine();
					System.out.println("Enter Subject:");
					String subject = br.readLine();
					System.out.println("Enter Author Name:");
					String author = br.readLine();
					System.out.println("Enter Published Year:");
					int published_year = sc.nextInt();
					System.out.println("Enter ISBN code:");
					String isbn_code = br.readLine();
					System.out.println("Enter Quantity:");
					int quantity = sc.nextInt();
					System.out.println("Enter Book Cost:");
					int book_cost = sc.nextInt();
					System.out.println("Enter Shelf Details:");
					String shelf_details = br.readLine();

					Books book = new Books(bookId, title, subject, author, published_year, isbn_code, quantity,
							book_cost, shelf_details);
					Books b = bookService.addBook(book);
					System.out.println(b);
					System.out.println("Book is added successfully into the database...");
					break;
				case 2:
					System.out.println("Enter Book Id:");
					int bookId1 = sc.nextInt();
					System.out.println("Enter Title:");
					String title1 = br.readLine();
					System.out.println("Enter Subject:");
					String subject1 = br.readLine();
					System.out.println("Enter Author Name:");
					String author1 = br.readLine();
					System.out.println("Enter Published Year:");
					int published_year1 = sc.nextInt();
					System.out.println("Enter ISBN code:");
					String isbn_code1 = br.readLine();
					System.out.println("Enter Quantity:");
					int quantity1 = sc.nextInt();
					System.out.println("Enter Book Cost:");
					int book_cost1 = sc.nextInt();
					System.out.println("Enter Shelf Details:");
					String shelf_details1 = br.readLine();
					System.out.println("Updating Details where Id = " + bookId1);
					Books book1 = new Books(bookId1, title1, subject1, author1, published_year1, isbn_code1, quantity1,
							book_cost1, shelf_details1);
					Books b1 = bookService.updateBookDetails(book1);
					System.out.println(b1);
					System.out.println("Book Updated Successfully..");
					break;
				case 3:
					System.out.println("Enter Book Id to Delete:");
					int Id = sc.nextInt();
					Books b2 = bookService.removeBook(Id);
					System.out.println(b2);
					System.out.println("Book Deleted Successfully..");
					break;
				case 4:
					System.out.println("Enter Title to search books:");
					String titletosearch = br.readLine();
					List<Books> b3 = bookService.searchBookByTitle(titletosearch);
					System.out.println(b3);
					break;
				case 5:
					System.out.println("Enter Subject to search books:");
					String subjecttosearch = br.readLine();
					List<Books> b4 = bookService.searchBookBySubject(subjecttosearch);
					System.out.println(b4);
					break;
				case 6:
					List<Books> b5 = bookService.viewAllBooks();
					System.out.println(b5);
					break;
				default:
					System.out.println("Please enter valid option!");
				}
				System.out.println("Do you want to continue? yes/no");
				choice = sc.next();
				System.out.println(choice);
			} while (choice.equalsIgnoreCase("yes"));
		case 2:
			do {
				System.out.println("1. Place Books order");
				System.out.println("2. Cancel Order");
				System.out.println("3. Update Order");
				System.out.println("4. View Orders");
				System.out.println("5. View Order by Id");
				int selectedOption = sc.nextInt();
				logger.info(String.format("User Selected option %d", selectedOption));
				switch (selectedOption) {
				case 1:
					Books book = new Books();
					System.out.println("Enter Order Id:");
					int orderId = sc.nextInt();
					System.out.println("Enter Quantity:");
					int quantity = sc.nextInt();
					System.out.println("Enter Order Date:");
					Date orderDate = Date.valueOf(sc.next());
					System.out.println("Enter Order status:");
					String orderStatus = br.readLine();
					System.out.println("Enter Book Id");
					book.setBookid(sc.nextInt());
					Books b1 = book;
					BooksOrder booksOrder = new BooksOrder(orderId, quantity, orderDate, orderStatus, b1);
					BooksOrder bo = booksOrderService.placeBooksOrder(booksOrder);
					System.out.println(bo);
					System.out.println("Order Placed Successfully...");
					break;
				case 2:
					System.out.println("Enter Order Id to Cancel:");
					int orderIdtocancel = sc.nextInt();
					BooksOrder bo1 = booksOrderService.cancelOrder(orderIdtocancel);
					System.out.println(bo1);
					System.out.println("Order Cancelled Successfully...");
					break;
				case 3:
					Books book1 = new Books();
					System.out.println("Enter Order Id:");
					int orderId1 = sc.nextInt();
					System.out.println("Enter Quantity:");
					int quantity1 = sc.nextInt();
					System.out.println("Enter Order Date:");
					Date orderDate1 = Date.valueOf(sc.next());
					System.out.println("Enter Order status:");
					String orderStatus1 = br.readLine();
					System.out.println("Enter Book id:");
					book1.setBookid(sc.nextInt());
					Books b2 = book1;
					System.out.println("Updating Order where OrderId = " + orderId1);
					BooksOrder booksOrder1 = new BooksOrder(orderId1, quantity1, orderDate1, orderStatus1, b2);
					BooksOrder bo2 = booksOrderService.updateOrder(booksOrder1);
					System.out.println(bo2);
					System.out.println("Order Updated Successfully...");
					break;
				case 4:
					List<BooksOrder> bo3 = booksOrderService.viewOrdersList();
					System.out.println(bo3);
					break;
				case 5:
					System.out.println("Enter Id to view order:");
					int idToView = sc.nextInt();
					BooksOrder bo4 = booksOrderService.viewOrderById(idToView);
					System.out.println(bo4);
					break;
				}
				System.out.println("Do you want to continue? yes/no");
				choice = sc.next();
				System.out.println(choice);
			} while (choice.equalsIgnoreCase("yes"));
			break;
		case 3:
			do {
				System.out.println("1. Add Damaged Book");
				System.out.println("2. Update Damaged Book Details");
				System.out.println("3. View Damaged Books");
				System.out.println("4. View Damaged Book by Id");
				int selectedOption = sc.nextInt();
				logger.info(String.format("User Selected option %d", selectedOption));
				switch (selectedOption) {
				case 1:
					Books book = new Books();
					System.out.println("Enter Id:");
					int id = sc.nextInt();
					System.out.println("Enter Quantity:");
					int quantity = sc.nextInt();
					System.out.println("Enter Description:");
					String description = br.readLine();
					System.out.println("Enter Book Id:");
					book.setBookid(sc.nextInt());
					Books b1 = book;

					DamagedBooks damagedbook = new DamagedBooks(id, quantity, description, b1);
					DamagedBooks db = damagedBookService.addDamagedBooks(damagedbook);
					System.out.println(db);
					System.out.println("Damaged Book Added Successfully...");
					break;
				case 2:
					Books book1 = new Books();
					System.out.println("Enter Id:");
					int id1 = sc.nextInt();
					System.out.println("Enter Quantity:");
					int quantity1 = sc.nextInt();
					System.out.println("Enter Description:");
					String description1 = br.readLine();
					System.out.println("Enter Book Id:");
					book1.setBookid(sc.nextInt());
					Books b2 = book1;

					DamagedBooks damagedbook1 = new DamagedBooks(id1, quantity1, description1, b2);
					System.out.println("Updating damaged book details where Id=" + id1);
					DamagedBooks db1 = damagedBookService.updateDamagedBookDetails(damagedbook1);
					System.out.println(db1);
					System.out.println("Damaged Book Details Updated Successfully...");
					break;
				case 3:
					List<DamagedBooks> db2 = damagedBookService.viewDamagedBooksList();
					System.out.println(db2);
					break;
				case 4:
					System.out.println("Enter Id to View Damaged Book");
					int idToView = sc.nextInt();

					DamagedBooks db3 = damagedBookService.viewDamagedBookById(idToView);
					System.out.println(db3);
					break;
				default:
					System.out.println("Please enter valid option!");
					break;
				}
				System.out.println("Do you want to continue? yes/no");
				choice = sc.next();
				System.out.println(choice);
			} while (choice.equalsIgnoreCase("yes"));
			break;
		default:
			System.out.println("Please enter valid option!");
		}
		sc.close();
	}
}
