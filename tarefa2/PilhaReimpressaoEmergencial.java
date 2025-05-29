package tarefa2;

public class PilhaReimpressaoEmergencial {
    private Pilha pilha;
    private int capacidadeMaxima;

    public PilhaReimpressaoEmergencial(int capacidade) {
        this.capacidadeMaxima = capacidade;
        this.pilha = new Pilha(capacidade);
    }

    public boolean solicitarReimpressao(String nomeArquivo, String nomeUsuario, String horarioSolicitacao) {
        if (pilha.estaCheio()) {
            System.out.println("Capacidade máxima atingida! Não é possível adicionar novo documento.");
            return false;
        }
        Documento doc = new Documento(nomeArquivo, nomeUsuario, horarioSolicitacao);
        pilha.inserir(doc);
        System.out.println("Solicitação registrada: " + doc);
        return true;
    }

    public void executarReimpressao(String horarioReimpressao) {
        if (pilha.estaVazio()) {
            System.out.println("Nenhum documento para reimpressão.");
            return;
        }
        Documento doc = pilha.remover();
        System.out.println("Reimprimindo documento: " + doc);
        System.out.println("Horário da reimpressão: " + horarioReimpressao);
        System.out.println("Horário da solicitação: " + doc.getHorarioSolicitacao());
    }

    public void consultarDocumento(String nomeArquivo) {
        int posicao = pilha.indiceDe(nomeArquivo);
        if (posicao == -1) {
            System.out.println("Documento '" + nomeArquivo + "' não está na pilha de reimpressão.");
        } else {
            int posicaoTopo = pilha.getOcupacao() - 1 - posicao;
            Documento doc = pilha.getDocumentoNaPosicao(posicao);
            System.out.println("Documento encontrado: " + doc);
            System.out.println("Posição a partir do topo: " + posicaoTopo);
            System.out.println("Horário de solicitação: " + doc.getHorarioSolicitacao());
        }
    }

    public void relatorio() {
        System.out.println("=== Relatório da Pilha de Reimpressão ===");
        System.out.println(pilha);
    }

    public boolean estaCheia() {
        return pilha.estaCheio();
    }
}
