package reestr;

import reestr.controllers.UserController;
import reestr.model.FileOperation;
import reestr.model.FileOperationImpl;
import reestr.model.Repository;
import reestr.model.RepositotyFile;
import reestr.views.ViewUser;

public class Main {

    public static void main(String[] args) {
        Repository repository;
        FileOperation fileOperation;
        fileOperation = new FileOperationImpl("animals2.txt");
        repository = new RepositotyFile(fileOperation);
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }

}
