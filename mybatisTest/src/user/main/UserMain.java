package user.main;

import java.util.Scanner;

import user.action.UserAction;
import user.action.UserDeleteAction;
import user.action.UserInsertAction;
import user.action.UserSearchAction;
import user.action.UserSelectAction;
import user.action.UserUpdateAction;

public class UserMain {
    public static void main(String[] args) {
        new UserMain().menu();
    }
    public void menu() {
        Scanner scan = new Scanner(System.in);
        UserAction userAction = null;
        int choice = 0;
        while(true) {
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 검색");
            System.out.println("6. 끝");
            System.out.print("번호 입력: ");
            choice = scan.nextInt();
            scan.nextLine();
            if(choice == 1) {
                userAction = new UserInsertAction();
            }else if(choice == 2) {
                userAction = new UserSelectAction();
            }else if(choice == 3) {
                userAction = new UserUpdateAction();
            }else if(choice == 4) {
                userAction = new UserDeleteAction();
            }else if(choice == 5) {
                userAction = new UserSearchAction();
            }else if(choice == 6) {
                scan.close();
                break;
            }else {
                System.out.println("잘못 입력하셨습니다.");
            }
            userAction.execute();
        }
    }
}
