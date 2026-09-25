package pl.mikolaj.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "JobPost")
public class Post {
    @MongoId
    private String id;
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;

    public Post() {
    }

    public Post(String id, String profile, String desc, int exp, String[] techs) {
        this.id = id;
        this.profile = profile;
        this.desc = desc;
        this.exp = exp;
        this.techs = techs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public String getDesc() {
        return desc;
    }

    public int getExp() {
        return exp;
    }

    public String[] getTechs() {
        return techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + java.util.Arrays.toString(techs) +
                '}';
    }
}
