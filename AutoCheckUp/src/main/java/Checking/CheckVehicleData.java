package Checking;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckVehicleData {
    public static boolean CheckPlaca(String str){
        String regex = "[A-Z]{3}[0-9]([A-Z]|[0-9])[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean CheckAno(String str){
        int i = Integer.parseInt(str);
        Calendar cal = Calendar.getInstance();
        return i > 1886 && i <= cal.get(Calendar.YEAR);
    }

    public static boolean CheckManutencao(String str, int anoModelo){
        int[] dias_por_mes = {31,28,31,30,31,30,31,31,30,31,30,31};
        int dia = Integer.parseInt(str.split("/")[0]);
        int mes = Integer.parseInt(str.split("/")[1]);
        int ano = Integer.parseInt(str.split("/")[2]);
        return (mes > 0 && mes <= 12 && dia > 0 && dia <= dias_por_mes[mes-1] && ano >= anoModelo && ano <= anoModelo) || str == null;
    }

    public static boolean CheckKm(String str){
        return Integer.parseInt(str) >= 0;
    }





}
