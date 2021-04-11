package pl.patryklubik.microserviceREST.data;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Create by Patryk Łubik on 08.04.2021.
 */


@Entity
@Table(name = "data")
public class Data {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Integer id;
    private String content;

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    Data() {
    }

    public Data(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}