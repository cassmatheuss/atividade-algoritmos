package tarefa2;

public class TestePilhaReimpressaoEmergencial {
    public static void main(String[] args) {
        PilhaReimpressaoEmergencial pilhaReimp = new PilhaReimpressaoEmergencial(3);

        pilhaReimp.solicitarReimpressao("prova1.pdf", "Alice", "09:00");
        pilhaReimp.solicitarReimpressao("relatorio.docx", "João", "09:10");
        pilhaReimp.solicitarReimpressao("folheto.ppt", "Carol", "09:20");

        pilhaReimp.solicitarReimpressao("extra.txt", "Davi", "09:30");

        pilhaReimp.relatorio();

        pilhaReimp.consultarDocumento("relatorio.docx");
        pilhaReimp.consultarDocumento("extra.txt");

        pilhaReimp.executarReimpressao("09:25");
        pilhaReimp.executarReimpressao("09:30");

        pilhaReimp.relatorio();

        pilhaReimp.consultarDocumento("prova1.pdf");

        pilhaReimp.executarReimpressao("09:40");

        pilhaReimp.executarReimpressao("09:50");

        pilhaReimp.relatorio();
    }
}
