public class TDDTask {
    public static String removal(String string){
        if(string.length()<=2){
            return string;
        }
        return string.substring(0,2).replace("A","")+string.substring(2,string.length());
    }
}
