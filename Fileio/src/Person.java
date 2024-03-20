public class Person {

    private String name;
    private int birthYear;
    private int height;
    private String jobTitle;

    public Person(String name, int birthYear, int height, String jobTitle) {
        this.name = name;
        this.birthYear = birthYear;
        this.height = height;
        this.jobTitle = jobTitle;
    }

    public String GetCSVString(){
return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", height=" + height +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;



    }
}
