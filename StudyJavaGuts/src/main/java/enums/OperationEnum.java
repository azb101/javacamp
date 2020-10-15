package enums;

public enum OperationEnum implements Invocable{
    ADD {
        @Override
        public int invoke(int a, int b) {
            return a + b;
        }
    },
    SUB {
        @Override
        public int invoke(int a, int b) {
            return a - b;
        }
    },
    DIV {
        @Override
        public int invoke(int a, int b) {
            return a / b;
        }
    },
    MULT {
        @Override
        public int invoke(int a, int b) {
            return a * b;
        }
    },;
}
