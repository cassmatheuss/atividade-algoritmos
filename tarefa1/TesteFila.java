package tarefa1;
public class TesteFila {
    public static void main(String[] args) {
        SistemaImpressao sistema = new SistemaImpressao(3);

        sistema.adicionarDocumento("projeto.pdf", "João", "10:00");
        sistema.adicionarDocumento("foto.jpg", "Maria", "10:05");
        sistema.adicionarDocumento("relatorio.docx", "Carlos", "10:10");
        sistema.adicionarDocumento("extra.txt", "Ana", "10:12");

        sistema.mostrarFila();

        sistema.consultarDocumento("foto.jpg");
        sistema.consultarDocumento("naoexiste.txt");

        sistema.imprimirDocumento("10:15");
        sistema.imprimirDocumento("10:20");

        sistema.mostrarFila();
    }
}