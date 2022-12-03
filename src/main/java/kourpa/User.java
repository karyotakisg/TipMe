package kourpa;
public class User {
    private String username;
    private String password;
    private String mail;
    private String p1;
    private String p2;
    private String p3;
    public User(String username, String password, String mail, String p1, String p2, String p3){
        this.username = username;
        this.password = password; 
        this.mail = mail;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    public User() {

    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setP1(String p1){
        this.p1= p1;
    }
    public void setP2(String p2){
        this.p2 = p2;
    }
    public void setP3(String p3){
        this.p3 = p3;
    }
    public String getPassword(){
        return password;
    }
    public String getMail(){
        return mail;
    }
    public String getp1(){
        return p1;
    }
    public String getp2(){
        return p2;
    }
    public String getp3(){
        return p3;
    }
    public String getUsername(){
        return username;
    }
}
