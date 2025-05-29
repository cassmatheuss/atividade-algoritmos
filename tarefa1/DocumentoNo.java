package tarefa1;
class DocumentoNo {
    private String nomeArquivo;
    private String nomeUsuario;
    private String horarioSolicitacao;
    private DocumentoNo proximo;

    public DocumentoNo(String nomeArquivo, String nomeUsuario, String horarioSolicitacao) {
        this.nomeArquivo = nomeArquivo;
        this.nomeUsuario = nomeUsuario;
        this.horarioSolicitacao = horarioSolicitacao;
    }

    public DocumentoNo getProximo() {
        return proximo;
    }
    public void setProximo(DocumentoNo proximo) {
        this.proximo = proximo;
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