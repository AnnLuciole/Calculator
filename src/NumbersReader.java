public class NumbersReader {

    public static class DataForCalculator {
        private double numberOne;
        private double numberTwo;
        private String signOfEqualation;

        DataForCalculator(double numberOne, double numberTwo, String signOfEqualation){
            this.numberOne = numberOne;
            this.numberTwo = numberTwo;
            this.signOfEqualation = signOfEqualation;
        }

        public double getNumberOne() {
            return numberOne;
        }

        public double getNumberTwo() {
            return numberTwo;
        }

        public String getSignOfEqualation() {
            return signOfEqualation;
        }

        public void setNumberOne(double numberOne) {
            this.numberOne = numberOne;
        }

        public void setNumberTwo(double numberTwo) {
            this.numberTwo = numberTwo;
        }

        public void setSignOfEqualation(String signOfEqualation) {
            this.signOfEqualation = signOfEqualation;
        }
    }

    public static DataForCalculator convert(String scannedString) {

        String[] numbersForEqualation = scannedString.trim().split(" ");

        double numberOne = Double.parseDouble(numbersForEqualation[0]);
        String signOfEqualation = numbersForEqualation[1];
        double numberTwo = Double.parseDouble(numbersForEqualation[2]);

        return new DataForCalculator(numberOne, numberTwo, signOfEqualation);
    }
}
