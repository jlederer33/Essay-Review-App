public class SupEssay extends Essay{
    public SupEssay(String title, String text){
        super(title, text);
    }

   @Override
   public String getType(){
        return "Supplement Essay";
    }
}
