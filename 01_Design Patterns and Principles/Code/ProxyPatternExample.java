public class ProxyPatternExample {

    // Step 1 & 2: Subject Interface
    interface Image {
        void display();
    }

    // Step 3: Real Subject Class - loads image from server
    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer(); // Simulate heavy loading
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading image from remote server: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // Step 4: Proxy Class
    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // Lazy initialization
            } else {
                System.out.println("Using cached image: " + filename);
            }
            realImage.display();
        }
    }

    // Step 5: Test class
    public static void main(String[] args) {
        System.out.println("Creating proxy image...");
        Image image = new ProxyImage("high_res_photo.jpg");

        System.out.println("\nFirst display call (image should load):");
        image.display();

        System.out.println("\nSecond display call (should use cached image):");
        image.display();
    }
}
