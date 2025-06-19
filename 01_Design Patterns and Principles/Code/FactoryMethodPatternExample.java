public class FactoryMethodPatternExample {

    // Step 1: Document interface (common for all document types)
    interface Document {
        void open();
    }

    // Step 2: Concrete document classes
    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening a Word document...");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening a PDF document...");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening an Excel document...");
        }
    }

    // Step 3: Abstract DocumentFactory class
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Step 4: Concrete factory classes for each document type
    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Testing the Factory Method implementation
    public static void main(String[] args) {
        // Create Word document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Create PDF document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Create Excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
