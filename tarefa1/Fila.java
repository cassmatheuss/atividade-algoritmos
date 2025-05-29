package tarefa1;
public class Fila {
    private DocumentoNo primeiro;
    private DocumentoNo ultimo;

    public boolean filaVazia () {
        return primeiro == null;
    }
    
    public void enfileira (String nomeDocumento, String nomeUsuario, String horarioSolicitacao) {
        DocumentoNo novo = new DocumentoNo(nomeDocumento, nomeUsuario, horarioSolicitacao);
        if (filaVazia())
            primeiro = novo;
        else
            ultimo.setProximo(novo);
        ultimo = novo;
    }

    public DocumentoNo getPrimeiro () {
        return primeiro;
    }

    public String desenfileira () {
        if (filaVazia()) throw new RuntimeException("falha no desenfileiramento");
        String temp = primeiro.getNomeArquivo();
        primeiro = primeiro.getProximo();
        if (primeiro == null)
            ultimo = null;
        return temp;
    } 
    @Override
    public String toString () {
        if (filaVazia()) return "fila vazia";
        String s = "";
        DocumentoNo runner = primeiro;
        while (runner != null) {
            s += runner + "->";
            runner = runner.getProximo();
        }
        return s + "\\\\";
    }
}