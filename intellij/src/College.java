public class College {
    /*
    This class meant to model the individual colleges in the dashboard. Future functionality will change the supplement essay so that a college can have 0..*
    Supplement essays.
     */
    private String name;
    private PersonalEssay perEssay;
    private SupplementEssay supEssay;

    public College(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void uploadPersonalEssay(PersonalEssay perEssay){
        this.perEssay = perEssay;
    } //adds a personal essay to the college

    public void uploadSupplementEssay(SupplementEssay supEssay){
        this.supEssay = supEssay;
    } //adds a supplement essay to the college

    public Essay getEssay(String essayType){//generalized method to return the type of essay in a college
        if(essayType.equalsIgnoreCase("Personal")){
            return perEssay;
        } else if (essayType.equalsIgnoreCase("Supplement")) {
            return supEssay;
        }else{
            return null; //Input is not a valid input type
        }

        }


}
