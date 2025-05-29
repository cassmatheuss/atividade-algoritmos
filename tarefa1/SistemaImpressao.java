package tarefa1;
public class SistemaImpressao {
    private Fila fila;
    private final int capacidadeMaxima;

    public SistemaImpressao(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.fila = new Fila();
    }

    public void adicionarDocumento(String nomeArquivo, String nomeUsuario, String horarioSolicitacao) {
        if (tamanhoFila() >= capacidadeMaxima) {
            System.out.println("Fila cheia! Não é possível adicionar o documento: " + nomeArquivo);
        }
        fila.enfileira(nomeArquivo, nomeUsuario, horarioSolicitacao);
        System.out.println("Documento adicionado: " + nomeArquivo + " | Usuário: " + nomeUsuario + " | Horário: " + horarioSolicitacao);
    }

    public void imprimirDocumento(String horarioImpressao) {
        if (fila.filaVazia()) {
            System.out.println("Fila vazia! Nenhum documento para imprimir.");
        }
        DocumentoNo doc = fila.getPrimeiro();
        fila.desenfileira();
        int tempoEspera = calcularTempoEspera(doc.getHorarioSolicitacao(), horarioImpressao);

        System.out.println("Imprimindo: " + doc.getNomeArquivo() + " | Usuário: " + doc.getNomeUsuario());
        System.out.println("Solicitado: " + doc.getHorarioSolicitacao() + " | Impresso: " + horarioImpressao);
        System.out.println("Tempo de espera: " + tempoEspera + " minutos\n");
    }

    public void consultarDocumento(String nomeArquivo) {
        DocumentoNo atual = fila.getPrimeiro();
        int pos = 1;
        while (atual != null) {
            if (atual.getNomeArquivo().equals(nomeArquivo)) {
                System.out.println("Documento '" + nomeArquivo + "' está na posição " + pos + " | Usuário: " + atual.getNomeUsuario() + " | Solicitado: " + atual.getHorarioSolicitacao());
                return;
            }
            atual = atual.getProximo();
            pos++;
        }
        System.out.println("Documento '" + nomeArquivo + "' não está na fila.");
    }

    public void mostrarFila() {
        if (fila.filaVazia()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("Fila de Impressão (" + tamanhoFila() + "/" + capacidadeMaxima + "):");
        DocumentoNo atual = fila.getPrimeiro();
        int pos = 1;
        while (atual != null) {
            System.out.println(pos + ". " + atual.getNomeArquivo() + " | Usuário: " + atual.getNomeUsuario() + " | Solicitado: " + atual.getHorarioSolicitacao());
            atual = atual.getProximo();
            pos++;
        }
        System.out.println();
    }

    private int tamanhoFila() {
        DocumentoNo atual = fila.getPrimeiro();
        int count = 0;
        while (atual != null) {
            count++;
            atual = atual.getProximo();
        }
        return count;
    }

    private int calcularTempoEspera(String inicio, String fim) {
        String[] ini = inicio.split(":");
        String[] fi = fim.split(":");
        int h1 = Integer.parseInt(ini[0]), m1 = Integer.parseInt(ini[1]);
        int h2 = Integer.parseInt(fi[0]), m2 = Integer.parseInt(fi[1]);
        return (h2 * 60 + m2) - (h1 * 60 + m1);
    }

}
