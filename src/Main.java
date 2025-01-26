public class Main {
    public static void main(String[] args) {
        Lesson lesson = new Lesson("aaaaaaaaaaaaaaaa", "sf", "sd");
        try {
            System.out.println(Lesson.login("aaaaaadaaaaaaaaaaaa", "22222222222222222222sd", "sd"));
        } catch (Lesson.WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (Lesson.WrongPasswordException e) {
            throw new RuntimeException(e);
        }

    }
}