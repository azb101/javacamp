package orm;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(catalog = "SpeakNativeDB", schema = "[dbo]" , name = "[Phrases]")
class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public UUID id;

    @Column(name = "ReferenceLang")
    public String eng;

    @Column(name = "TargetLang")
    public String rus;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "UserId")
    public User user;

    @Override
    public String toString() {
        return "Phrase{" +
                ", Eng='" + eng +
                "', Rus='" + rus + "' >>" +
                user.getEmail() + "<< " +
                " } ";
    }
}
