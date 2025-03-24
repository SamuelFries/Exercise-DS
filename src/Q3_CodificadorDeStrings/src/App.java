public class App {
    public static void main(String[] args) throws Exception {
        Codificador cod = new Codificador(new CodSimples());

        String aux = "Desafio Padrões de Projeto";

        System.out.println(aux);

        aux = cod.codifica(aux);
        System.out.println(aux);

        aux = cod.deCodifica(aux);
        System.out.println(aux);

        cod.setEstrategia(new CodDesloca());

        aux = cod.codifica(aux);
        System.out.println(aux);

        aux = cod.deCodifica(aux);
        System.out.println(aux);
    }
}