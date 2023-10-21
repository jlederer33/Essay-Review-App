public class PersonalEssay extends Essay{
    public PersonalEssay(String title, String text){
        super(title, text);
    }

    @Override
    public String getType() {
        return "Personal Essay";
    }
}
