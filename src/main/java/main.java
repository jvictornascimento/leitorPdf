import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        String pdfFilePath = "C:\\Users\\joao\\Desktop\\Catalago.pdf";

        try {
            // Carregar o PDF

            PDDocument document = PDDocument.load(new File (pdfFilePath));
            // Extrair texto do PDF
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            // Fechar o documento
            document.close();

            // Expressão regular para encontrar códigos (ajuste conforme necessário)
            Pattern pattern = Pattern.compile("\\b\\d{5,}\\b"); // Exemplo: códigos com 4 ou mais dígitos
            Matcher matcher = pattern.matcher(text);

            System.out.println("Códigos encontrados no PDF:");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo PDF: " + e.getMessage());
        }
    }
}