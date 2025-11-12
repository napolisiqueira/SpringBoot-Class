package dio.my_first_web_api.repository;

import dio.my_first_web_api.handler.BussinesException;
import dio.my_first_web_api.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user) throws BussinesException {
        if (user.getLogin() == null) {
            throw new BussinesException("O campo login é obrigatorio.");
        }
        if (user.getPassword() == null) {
            throw new BussinesException("O campo password é obrigatorio.");
        }

        if(user.getId()==null) {
            System.out.println("SAVE - Recebendo o usuario na camada repository");
        } else {
            System.out.println("UPDATE - Recebendo o usuario na camada repository");
        }
        System.out.println(user);
    }

    public void deleteById(Integer id) {
        System.out.printf("DELETE/id - Recebendo o id %d para exclução", id);
        System.out.println(id);
    }

    public List<User> findAll() {
        System.out.println("LIST - Listando os usuarios do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("henrique", "password"));
        users.add(new User("nathalia", "masterpass"));
        return users;
    }

    public User findById(Integer id) {
        System.out.println("FIND/id - REcebendo id para localizar user");
        return new User("nathalia", "masterpass");
    }

    public User findByUsername(String username) {
        System.out.println("FIND/username - Recebendo o username para localizar user");
        return new User("henrique", "masterpass");
    }

}
