package edu.matc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;

import javax.persistence.*;

/**
 * A class to represent a character in The Office.
 *
 * @author jordynbx
 */
@Entity(name = "Character")
@Table(name = "characters")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "character_name")
    @NonNull
    private String characterName;

    @Column(name = "actor_name")
    @NonNull
    private String actorName;

    @Column(name = "memorable_quote")
    @NonNull
    private String memorableQuote;

    public Character(int id, String characterName, String actorName, String memorbleQuote) {
        this.id = id;
        this.characterName = characterName;
        this.actorName = actorName;
        this.memorableQuote = memorbleQuote;
    }
}
