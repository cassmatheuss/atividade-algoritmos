package tarefa2;

public class Documento {
    private String nomeArquivo;
    private String nomeUsuario;
    private String horarioSolicitacao;

    public Documento(String nomeArquivo, String nomeUsuario, String horarioSolicitacao) {
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = horarioSolicitacao;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getHorarioSolicitacao() {
        return horarioSolicitacao;
    }

    @Override
    public String toString() {
        return "[" + nomeArquivo + ", " + nomeUsuario + ", " + horarioSolicitacao + "]";
    }
}
