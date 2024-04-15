package Back.End.Esercizio.S7L1.payloads.dipendenti;

public record DipendentiLoginDTO(String email, String password) {
    public  DipendentiLoginDTO {
        String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

    }


}
