package user.action;

import java.util.List;
import java.util.Scanner;

import param.bean.ParamDTO;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchAction implements UserAction {

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. 이름 검색");
        System.out.println("2. 아이디 검색");
        int choice = scan.nextInt();
        String colName = null;
        String value = null;
        scan.nextLine();
        if(choice==1) {
            System.out.print("이름 입력: ");
            colName = "name";
            value = scan.nextLine();
        }else {
            System.out.print("아이디 입력: ");
            colName = "id";
            value = scan.nextLine();
        }
        ParamDTO paramDTO = new ParamDTO(colName, value);
        UserDAO userDAO = UserDAO.getInstance();
        List<UserDTO> list = userDAO.userSearch(paramDTO);
        if(list.size() != 0) {
            for(UserDTO userDTO: list) {
                System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
            }
        }else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

}
