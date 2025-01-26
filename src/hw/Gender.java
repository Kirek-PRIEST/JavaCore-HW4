package hw;

public enum Gender {
    MALE("М"), FEMALE("Ж");

    public String getCelebMassage() {
        return genderLiteral;
    }

    private final String genderLiteral;

    Gender(String celebMassage) {
        this.genderLiteral = celebMassage;
    }
}
