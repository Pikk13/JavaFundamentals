public class BankAccount {

    private String name;
    private String accountNumber;
    private String email;
    private boolean newsLetter;

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", email='" + email + '\'' +
                ", newsLetter=" + newsLetter +
                '}';
    }
//osztályon belüli osztály

    public static class BankAccountBuilder {

        private String name;
        private String accountNumber;
        private String email;
        private boolean newsLetter;

        public BankAccountBuilder(String name, String accountNumber) {
            this.name = name;
            this.accountNumber = accountNumber;
        }

        public BankAccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public BankAccountBuilder wantNewsLetter(boolean newsLetter) {
            this.newsLetter = newsLetter;
            return this;
        }

        public BankAccount build(){
            var instance = new BankAccount();
            instance.name = this.name;
            instance.accountNumber = this.accountNumber;
            instance.email = this.email;
            instance.newsLetter = this.newsLetter;

            return instance;
        }

        @Override
        public String toString() {
            return "BankAccountBuilder{" +
                    "name='" + name + '\'' +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", email='" + email + '\'' +
                    ", newsLetter=" + newsLetter +
                    '}';
        }
    }
}
