import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // Додавання користувачів
        userRepository.addUser(new User(1, "Alice", "alice@example.com"));
        userRepository.addUser(new User(2, "Bob", "bob@example.com"));
        userRepository.addUser(new User(3, "Charlie", "charlie@example.com"));

        // a. Пошук користувача за id
        int searchId = 2;
        Optional<User> userById = userRepository.findUserById(searchId);
        userById.ifPresentOrElse(
                user -> System.out.println("Знайдено користувача за id: " + user),
                () -> System.out.println("Користувача з id " + searchId + " не знайдено")
        );

        // b. Пошук користувача за email
        String searchEmail = "alice@example.com";
        Optional<User> userByEmail = userRepository.findUserByEmail(searchEmail);
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Знайдено користувача за email: " + user),
                () -> System.out.println("Користувача з email " + searchEmail + " не знайдено")
        );

        // c. Отримання списку всіх користувачів
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> {
                    System.out.println("Список всіх користувачів:");
                    users.forEach(System.out::println);
                    System.out.println("Загальна кількість користувачів: " + users.size());
                },
                () -> System.out.println("Список користувачів порожній")
        );
    }
}