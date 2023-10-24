public class College {
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
    }

    public void uploadSupplementEssay(SupplementEssay supEssay){
        this.supEssay = supEssay;
    }

    public Essay getEssay(String essayType){
        if(essayType.equalsIgnoreCase("Personal")){
            return perEssay;
        } else if (essayType.equalsIgnoreCase("Supplement")) {
            return supEssay;
        }else{
            return null; //Input is not a valid input type
        }

        }
}
