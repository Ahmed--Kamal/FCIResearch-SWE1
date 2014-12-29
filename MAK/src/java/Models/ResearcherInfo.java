/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Sho3la
 */
public class ResearcherInfo {
    public String name;
    public String userName;
    public String email;
    public int age;
    public String job;
    public String password;
    public String category;
    public ArrayList<String> research = new ArrayList<String>();
    public ResearcherInfo(){}
    public ResearcherInfo(String name, String userName, String email, int age, String job, String password, String category) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.age = age;
        this.job = job;
        this.password = password;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setResearch(ArrayList<String> research) {
        this.research = research;
    }   

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getPassword() {
        return password;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<String> getResearch() {
        return research;
    }
}
