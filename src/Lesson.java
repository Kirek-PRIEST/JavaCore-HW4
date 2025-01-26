public class Lesson {
    private String login;
    private String password;
    private String confirmPassword;

    public Lesson(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }


    public static boolean login(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        try {
            loginCheck(login);
        }catch (WrongLoginException e){
            System.out.println(e.getMessage());;
            return false;
        }
        try {
            passwordCheck(password, confirmPassword);
        }catch (WrongPasswordException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;
    }


    private static void loginCheck(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException(login);
        }
    }
    private static void passwordCheck(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() > 20) {
            throw new WrongPasswordException(String.format(
                    "Длинна пароля не должна превышать 20 символов. Длина вашего логина %s символов", password.length()));
        }else
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static class WrongLoginException extends Exception {
        public WrongLoginException() {
        }

        public WrongLoginException(String login) {
            super(String.format("Длинна логина не должна превышать 20 символов. Длина вашего пароля %s символов", login.length()));
        }
    }

    public static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
}
