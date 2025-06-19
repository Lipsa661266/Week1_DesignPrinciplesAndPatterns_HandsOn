public class BuilderPatternExample {

    // Step 1 & 2: Product class - Computer
    static class Computer {
        // Required and optional components
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        // Private constructor to enforce use of Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.graphicsCard = builder.graphicsCard;
            this.operatingSystem = builder.operatingSystem;
        }

        // Method to display computer configuration
        public void showConfig() {
            System.out.println("Computer Configuration:");
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
            System.out.println("Graphics Card: " + graphicsCard);
            System.out.println("Operating System: " + operatingSystem);
            System.out.println();
        }

        // Step 3: Static nested Builder class
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private String graphicsCard;
            private String operatingSystem;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(String graphicsCard) {
                this.graphicsCard = graphicsCard;
                return this;
            }

            public Builder setOperatingSystem(String operatingSystem) {
                this.operatingSystem = operatingSystem;
                return this;
            }

            // Step 4: Build method
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Step 5: Test class
    public static void main(String[] args) {
        // Creating a gaming computer
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel Core i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4090")
            .setOperatingSystem("Windows 11 Pro")
            .build();

        gamingPC.showConfig();

        // Creating a budget office computer
        Computer officePC = new Computer.Builder()
            .setCPU("Intel Core i3")
            .setRAM("8GB")
            .setStorage("500GB HDD")
            .setOperatingSystem("Windows 10 Home")
            .build();

        officePC.showConfig();
    }
}
