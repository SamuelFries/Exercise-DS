import java.util.HashMap;
import java.util.Map;


interface EstrategiaCodificacao {
    String codifica(String str);
    String decodifica(String str);
}

class CodSimples implements EstrategiaCodificacao {
    private Map<Character, Character> tabCod;
    private Map<Character, Character> tabDeCod;

    public CodSimples() {
        tabCod = new HashMap<>();
        tabCod.put('a','@');
        tabCod.put('e','#');
        tabCod.put('i','!');
        tabCod.put('o','$');
        tabCod.put('u','%');

        tabDeCod = new HashMap<>();
        tabDeCod.put('@','a');
        tabDeCod.put('#','e');
        tabDeCod.put('!','i');
        tabDeCod.put('$','o');
        tabDeCod.put('%','u');
    }

    public String codifica(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            if (tabCod.containsKey(aux[i])){
                resp[i] = tabCod.get(aux[i]);
            }else{
                resp[i] = aux[i];
            }
        }
        return(new String(resp));
    }

    public String decodifica(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            if (tabDeCod.containsKey(aux[i])){
                resp[i] = tabDeCod.get(aux[i]);
            }else{
                resp[i] = aux[i];
            }
        }
        return(new String(resp));
    }
}

class CodDesloca implements EstrategiaCodificacao {
    public String codifica(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            resp[i] = (char)(Character.valueOf(aux[i])+1);
        }
        return(new String(resp));
    }

    public String decodifica(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for(int i=0;i<aux.length;i++){
            resp[i] = (char)(Character.valueOf(aux[i])-1);
        }
        return(new String(resp));
    }
}

public class Codificador{
    private EstrategiaCodificacao estrategia;

    public Codificador(EstrategiaCodificacao estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaCodificacao estrategia) {
        this.estrategia = estrategia;
    }

    public String codifica(String str){
        return estrategia.codifica(str);
    }

    public String deCodifica(String str){
        return estrategia.decodifica(str);
    }
}
