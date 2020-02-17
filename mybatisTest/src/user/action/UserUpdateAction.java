package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 ID 입력: ");
        String id = scan.nextLine();
        
        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = userDAO.getUser(id);
        if(userDTO == null) System.out.println("찾고자하는 아이디가 없습니다.");
        else {
            System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
            System.out.print("수정할 이름 입력: ");
            String name = scan.nextLine();
            userDTO.setName(name);
            System.out.print("수정할 비밀번호 입력: ");
            String pwd = scan.nextLine();
            userDTO.setPwd(pwd);
            userDAO.userUpdate(userDTO);
            System.out.println("수정 완료!!");
        }
        
             
    }

}
