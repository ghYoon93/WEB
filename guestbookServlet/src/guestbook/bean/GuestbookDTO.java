package guestbook.bean;

public class GuestbookDTO {
    private int seq;
    private String name, email, homepage, subject, content, logTime;

    
    
    
    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomepage(String hompage) {
        this.homepage = hompage;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHompage() {
        return homepage;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getLogTime() {
        return logTime;
    }
    
}
