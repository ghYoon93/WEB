package guestbook.bean;

public class GuestbookDTO {
    String name, email, homepage, subject, content, date;

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
    
    public void setDate(String date) {
        this.date = date;
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

    public String getDate() {
        return date;
    }
    
}
