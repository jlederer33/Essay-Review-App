public class College {
    private String name;
    private Essay perEssay;
    private Essay supEssay;

    public College(String name){
        this.name = name;
        this.perEssay = null;
        this.supEssay = null;
    }
    public String getName(){
        return name;
    }

    public Essay getPersonalEssay(){
        return perEssay;
    }

    public Essay getSupplementEssay(){
        return supEssay;
    }

    public void setPersonalEssay(Essay essay){
        if(essay instanceof PersonalEssay){
            perEssay = essay;
        }
    }

    public void setSupplementEssay(Essay essay){
        if(essay instanceof SupEssay){
            supEssay = essay;
        }
    }
}
