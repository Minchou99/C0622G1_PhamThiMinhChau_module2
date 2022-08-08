package ss5_access_modifier_static_method_property.practise.oop.exercise_1;

public class Candidate {
    private String code = "";
    private String name = "";
    private String dateOfBirth = "";
    private double mathScore = 0;
    private double literatureScore = 0;
    private double englishScore = 0;

    //constructor: no parameter
    public Candidate() {

    }

    //constructor: full property
    public Candidate(String name, double mathScore, double literatureScore, double englishScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.literatureScore = literatureScore;
        this.englishScore = englishScore;
    }

    //setter and getter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(double literatureScore) {
        this.literatureScore = literatureScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    //get Total Score
    public double getTotalScore() {
        return (getMathScore() + getEnglishScore() + getLiteratureScore());
    }

    @Override
    public String toString() {
        return "Candidate{" +
                ", name='" + name + '\'' +
                ", mathScore=" + mathScore +
                ", literatureScore=" + literatureScore +
                ", englishScore=" + englishScore +
                ", totalScore" + getTotalScore() +
                '}';
    }
}
