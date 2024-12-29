// https://www.codewars.com/kata/58e24788e24ddee28e000053
import java.util.HashMap;
import java.util.Map;

public class SimpleAssembler {
    static boolean isNum(String sentence){
        for(int i=0;i<sentence.length();i++)
            if(sentence.charAt(i)!=45&&(sentence.charAt(i)<48||sentence.charAt(i)>57))
                return false;
        return true;
    }
    public static Map<String, Integer> interpret(String[] program){
        Map<String, Integer> resultado=new HashMap<>();
        for(int i=0; i<program.length;i++){
            String instruccion[]=program[i].split(" ");
            switch(instruccion[0]){
            case "mov":
                resultado.put(instruccion[1], isNum(instruccion[2])?Integer.parseInt(instruccion[2]):resultado.get(instruccion[2]));
                break;
            case "inc":
                int incremento=resultado.get(instruccion[1])+1;
                resultado.put(instruccion[1], incremento);
                break;
            case "dec":
                int decremento=resultado.get(instruccion[1])-1;
                resultado.put(instruccion[1], decremento);
                break;
            case "jnz":
                if((isNum(instruccion[1])?Integer.parseInt(instruccion[1]):resultado.get(instruccion[1]))!=0)
                    i+=Integer.parseInt(instruccion[2])-1;
                break;
            }
        }
        return resultado;
    }
}
