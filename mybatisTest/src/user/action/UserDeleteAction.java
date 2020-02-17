package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 아이디 입력: ");
        String id = scan.nextLine();
        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = userDAO.getUser(id);
        if(userDTO==null) {
            System.out.println("찾고자하는 아이디가 없습니다.");
        } else {
            userDAO.userDelete(id);
            System.out.println("데이터 삭제 완료!!");
        }
    }

}
