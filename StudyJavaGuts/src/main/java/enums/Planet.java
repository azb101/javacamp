package enums;

public enum Planet {
    JUPITER( 15.23,1300.03){
        @Override
        public String asLowerCase() {
            return JUPITER.toString().toLowerCase();
        }
    },
    MARS(10.923, 100.423){
        @Override
        public String asLowerCase() {
            return MARS.toString().toLowerCase();
        }
    },
    EARTH(9.8, 100) {
        @Override
        public String asLowerCase() {
            return this.toString().toLowerCase();
        }
    },
    PLUTO(6.12, 46){
        @Override
        public String asLowerCase() {
            return this.toString().toLowerCase();
        }

        @Override
        public double getGravity() {
            return super.getGravity() * 0.1;
        }
    };

    private final double g;
    private final double mass;

    Planet(double g, double mass) {
        this.g = g;
        this.mass = mass;
    }

    public double getGravity(){
        return g;
    }

    public abstract String asLowerCase();
}
