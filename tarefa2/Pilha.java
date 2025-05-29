package tarefa2;

public class Pilha {

    private int ocupacao;
    private Documento[] vetor;

    public Pilha(int tamanho) {
        vetor = new Documento[tamanho];
        ocupacao = 0;
    }

    public Pilha() {
        this(10);
    }

    public void inserir(Documento doc) {
        if (estaCheio()) {
            throw new IllegalStateException("Pilha cheia, não é possível adicionar.");
        }
        vetor[ocupacao++] = doc;
    }

    public Documento remover() {
        if (estaVazio()) {
            throw new PilhaVaziaException("pilha vazia, nao ha o que remover");
        }
        Documento aux = vetor[--ocupacao];
        vetor[ocupacao] = null;
        return aux;
    }

    public Documento topo() {
        if (estaVazio()) {
            throw new PilhaVaziaException("pilha vazia.");
        }
        return vetor[ocupacao - 1];
    }

    public boolean estaCheio() {
        return ocupacao == vetor.length;
    }

    public boolean estaVazio() {
        return ocupacao == 0;
    }

    public int getTamanho() {
        return vetor.length;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public boolean contem(String nomeArquivo) {
        for (int i = 0; i < ocupacao; i++) {
            if (vetor[i].getNomeArquivo().equals(nomeArquivo)) {
                return true;
            }
        }
        return false;
    }

    public int indiceDe(String nomeArquivo) {
        for (int i = 0; i < ocupacao; i++) {
            if (vetor[i].getNomeArquivo().equals(nomeArquivo)) {
                return i;
            }
        }
        return -1;
    }

    public Documento getDocumentoNaPosicao(int pos) {
        if (pos < 0 || pos >= ocupacao) {
            throw new IndexOutOfBoundsException("Posição inválida na pilha");
        }
        return vetor[pos];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("ocupacao = " + ocupacao + "\n");
        for (int i = 0; i < ocupacao; i++) {
            s.append(vetor[i]).append("\n");
        }
        return s.toString();
    }

}

class PilhaVaziaException extends RuntimeException {
    public PilhaVaziaException(String msg) {
        super(msg);
    }
}