public class Credential {
    private String website;
    private String username;
    private String password;

    public Credential(String website,String username,String paswaord){
        this.website = website;
        this.username = username;
        this.password = paswaord;

    }
    public String getWebsite(){
        return website;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
