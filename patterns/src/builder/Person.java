package builder;

public class Person {
    private final String lastName;
    private final String firstName;
    private String middleName;
    private String salutation;
    private String suffix;
    private String streetAddress;
    private String city;
    private String state;
    private final boolean isFemale;
    private boolean isEmployed;
    private boolean isHomewOwner;

    private Person(){
        this.lastName = getLastName();
        this.firstName = getFirstName();
        this.isFemale = isFemale();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public boolean isHomewOwner() {
        return isHomewOwner;
    }

    public static Builder newBuilder(){
        return new Person().new Builder();
    }

    public class Builder {

        private Builder(){

        }

        public Builder setMiddleName(String middleName) {
            Person.this.middleName = middleName;
            return this;
        }

        public Builder setSalutation(String salutation) {
            Person.this.salutation = salutation;
            return this;
        }

        public Builder setSuffix(String suffix) {
            Person.this.suffix = suffix;
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            Person.this.streetAddress = streetAddress;
            return this;
        }

        public Builder setCity(String city) {
            Person.this.city = city;
            return this;
        }

        public Builder setIsEmployed(boolean isEmployed) {
            Person.this.isEmployed = isEmployed;
            return this;
        }

        public Builder setState(String state) {
            Person.this.state = state;
            return this;
        }

        public Builder setIsHomeOwner(boolean isHomeOwner) {
            Person.this.isHomewOwner = isHomeOwner;
            return this;
        }

        public Person build(){
            return Person.this;
        }
    }
}
