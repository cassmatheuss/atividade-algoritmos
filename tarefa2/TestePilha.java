package tarefa2;

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(3);

        Documento doc1 = new Documento("arquivo1.pdf", "Alice", "08:00");
        Documento doc2 = new Documento("arquivo2.docx", "Bob", "08:05");
        Documento doc3 = new Documento("arquivo3.txt", "Carol", "08:10");
        Documento doc4 = new Documento("arquivo4.ppt", "Davi", "08:15");

        pilha.inserir(doc1);
        pilha.inserir(doc2);
        pilha.inserir(doc3);

        System.out.println("Pilha após inserções:");
        System.out.println(pilha);

        pilha.inserir(doc4);
        System.out.println("Pilha após inserir mais um documento:");
        System.out.println(pilha);

        Documento removido = pilha.remover();
        System.out.println("Documento removido: " + removido);
        System.out.println("Pilha após remoção:");
        System.out.println(pilha);

        System.out.println("Pilha contém 'arquivo2.docx'? " + pilha.contem("arquivo2.docx"));
        System.out.println("Índice de 'arquivo1.pdf': " + pilha.indiceDe("arquivo1.pdf"));

        pilha.remover();
        pilha.remover();
        pilha.remover();

        System.out.println("Pilha após remover todos:");
        System.out.println(pilha);

        try {
            pilha.remover();
        } catch (PilhaVaziaException e) {
            System.out.println("erro ao remover: " + e.getMessage());
        }
    }
}
