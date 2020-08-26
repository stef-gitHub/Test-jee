package beans;

public class Administrateur extends Personne{
    private String email;
    private String motdepasse;

    public Administrateur(String email, String motdepasse) {
        super();
        this.email = email;
        this.motdepasse = motdepasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
}
