package testdome;

public class ShiningStar {

    private String name;
    private double shineFactor;

    public ShiningStar(double shineFactor){
        this.shineFactor = shineFactor;
    }

    public double shine(){
        if(this.shineFactor == 0d){
            throw new IllegalStateException();
        }
        return this.shineFactor;
    }

    public void fadeOut(){
        this.shineFactor = 0d;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    public static void main(String[] args) {
        double shineFactor = 1.5d;
        ShiningStar star = new ShiningStar(shineFactor);

        star.fadeOut();
        star.shine();

    }
}